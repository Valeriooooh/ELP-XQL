package org.example

import XMLLexer
import XMLParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File

interface Instruction

data class Load(val name: String, val number: Int) : Instruction
data class Assign(val name: String, val query: Query) : Instruction
data class Save(val name: String, val number: Int) : Instruction

sealed class Query {
    data class Dot(val prev: Query, val query: String) : Query()
    data class Arrow(val prev: Query, val query: String) : Query()
    data class Count(val prev: Query) : Query()
    data class Variable(val name: String) : Query()
    data class Offset(val prev: Query, val num: Int) : Query()
    data class Sum(val prev: Query) : Query()
    data class Template(val xml: String) : Query()
}

data class XQL(val parameters: List<String>, val instructions: List<Instruction>) {

    private val dict: MutableMap<String, XMLElement?> = mutableMapOf()

    fun run() {
        for (i in instructions) {
            when (i) {
                is Load -> {
                    dict[i.name] = XMLParser(
                        CommonTokenStream(
                            XMLLexer(
                                CharStreams.fromString(File(parameters[i.number - 1]).readText().trimIndent())
                            )
                        )
                    ).document().toAst().tags.first()
                }

                is Assign -> dict[i.name] = exec(i.query)

                is Save -> File(parameters[i.number - 1]).writeText(dict[i.name].toString())

                else -> {}
            }
        }
    }

    private fun exec(query: Query): XMLElement? {
        return when (query) {
            is Query.Arrow -> {
                when (val p = exec(query.prev)) {
                    is XMLElement.ResultList -> p.map(query.query)
                    else -> null
                }
            }

            is Query.Sum -> {
                when (val p = exec(query.prev)) {
                    is XMLElement.ResultList -> p.sum()
                    else -> null
                }
            }

            is Query.Dot -> {
                when (val p = exec(query.prev)) {
                    is XMLElement.Tag -> p.find(query.query)
                    is XMLElement.Document -> p.find(query.query)
                    else -> null
                }
            }

            is Query.Count -> {
                when (val p = exec(query.prev)) {
                    is XMLElement.ResultList -> XMLElement.Text(text = "" + p.count())
                    else -> XMLElement.Text("0")
                }
            }

            is Query.Variable -> dict[query.name]

            is Query.Offset -> {
                when (val p = exec(query.prev)) {
                    is XMLElement.ResultList -> try {
                        p.elements[query.num]
                    } catch (e: Exception) {
                        null
                    }

                    else -> if (query.num == 0) {
                        p
                    } else {
                        null
                    }
                }
            }

            is Query.Template -> fillXML(query)
        }
    }

    // TODO // Incomplete.
    private fun fillXML(query: Query.Template): XMLElement {
        fun iterate(elements: List<XMLElement>) {
            elements.forEach { element ->
                if (element is XMLElement.Tag) {
                    element.attributes.forEach { attribute ->
                        if (Regex("\\$\\w*").matches(attribute.value)) {
                            attribute.value = dict[attribute.value.removePrefix("$")].toString()
                        }
                    }
                    iterate(element.content)
                }
            }
        }

        val parents = XMLParser(
            CommonTokenStream(
                XMLLexer(
                    CharStreams.fromString(query.xml.trimIndent())
                )
            )
        ).document().toAst().tags

        iterate(parents)
        return XMLElement.Document(parents)
    }

    override fun toString(): String {
        val builder = StringBuilder()
        for (i in dict.keys) {
            builder.append("$i: " + dict[i] + "\n")
        }
        return builder.toString()
    }

}