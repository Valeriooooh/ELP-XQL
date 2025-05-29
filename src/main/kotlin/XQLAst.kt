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

data class XQL(val parameters: List<String>, val instructions: List<Instruction?>) {

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
                    ).document().toAst().root
                }

                is Assign -> dict[i.name] = exec(i.query)

                is Save -> File(parameters[i.number - 1]).writeText(dict[i.name].toString())
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
                    } catch (_: Exception) {
                        null
                    }

                    else -> if (query.num == 0) {
                        p
                    } else {
                        null
                    }
                }
            }

            is Query.Template -> refactor(query)
        }
    }

    private fun refactor(query: Query.Template): XMLElement {

        fun eval(parent: XMLElement.Tag): XMLElement.Tag {

            fun expand(element: XMLElement.Tag, content: List<XMLElement>): List<XMLElement> {
                val content = content.toMutableList()
                var index = content.indexOf(element)
                content.removeAt(index)
                val branches = dict[element.name.split("$")[1]]
                if (branches is XMLElement.ResultList) {
                    branches.elements.forEach { branch ->
                        if (branch is XMLElement.Tag) {
                            val attributes = mutableListOf<XMLElement.Attribute>()
                            element.attributes.forEach { attribute ->
                                if (Regex("\\$\\w+").matches(attribute.value)) {
                                    val search = branch.find(attribute.value.removePrefix("$"))
                                    if (search is XMLElement.Text) {
                                        attributes.add(XMLElement.Attribute(attribute.name, search.toString()))
                                    } else {
                                        attributes.add(attribute)
                                    }
                                } else {
                                    attributes.add(attribute)
                                }
                            }
                            content.add(
                                index++,
                                XMLElement.Tag(
                                    element.name.split("$")[0],
                                    attributes,
                                    element.content
                                )
                            )
                        }
                    }
                }
                return content
            }

            parent.attributes.forEach { attribute ->
                if (Regex("\\$\\w*").matches(attribute.value)) {
                    attribute.value = dict[attribute.value.removePrefix("$")].toString()
                }
            }
            parent.content.forEach { child ->
                if (child is XMLElement.Tag) {
                    if (Regex("\\w+\\$\\w+").matches(child.name)) {
                        parent.content = expand(child, parent.content)
                    }
                    eval(child)
                }
            }
            return parent
        }

        return XMLElement.Document(
            eval(
                XMLParser(
                    CommonTokenStream(
                        XMLLexer(
                            CharStreams.fromString(query.xml.trimIndent())
                        )
                    )
                ).document().toAst().root
            )
        )
    }

    override fun toString(): String {
        val builder = StringBuilder()
        for (i in dict.keys) {
            builder.append("$i: " + dict[i] + "\n")
        }
        return builder.toString()
    }

}

fun XQLParser.DocumentContext.toAst(parameters: List<String>): XQL {
    val instructions = mutableListOf<Instruction?>()
    this.instruction().forEach { instructions.add(it.toAst()) }
    return XQL(parameters, instructions)
}

fun XQLParser.InstructionContext.toAst(): Instruction? {
    return if (this.load() != null) {
        Load(
            this.load().variable().NAME().toString(),
            this.load().ARGUMENT().toString().removePrefix("$").toInt()
        )
    } else if (this.save() != null) {
        Save(
            this.save().variable().NAME().toString(),
            this.save().ARGUMENT().toString().removePrefix("$").toInt()
        )
    } else if (this.assign() != null) {
        Assign(
            this.assign().variable().NAME().toString(),
            this.assign().expression().toAst()
        )
    } else {
        null
    }
}

// TODO
fun XQLParser.ExpressionContext.toAst(): Query {
    return Query.Variable("")
}