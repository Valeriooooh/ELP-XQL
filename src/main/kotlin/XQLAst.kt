package org.example

import XMLLexer
import XMLParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File

interface Instruction

data class Load(val number: Int, val name: String) : Instruction
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
                    ).document().toAst().tag.first()
                }

                is Assign -> dict[i.name] = exec(i.query)

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
                    is XMLElement.XML -> p.find(query.query)
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

            is Query.Template -> {
                null
            }
        }
    }

}