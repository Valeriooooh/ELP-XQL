package org.example

import XMLLexer
import XMLParser
import XQLBaseListener
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File

interface Instruction

data class Load(val name: String, val number: Int) : Instruction
data class Assign(val name: String, val query: Query) : Instruction
data class Save(val name: String, val number: Int) : Instruction

sealed class Query {

    data class Dot(val prev: Query, val query: String) : Query() {
        override fun toString() = "$prev.$query"
    }

    data class Arrow(val prev: Query, val query: String) : Query() {
        override fun toString() = "$prev->$query"
    }

    data class Count(val prev: Query) : Query() {
        override fun toString() = "$prev#"
    }

    data class Variable(val name: String) : Query() {
        override fun toString() = name
    }

    data class Offset(val prev: Query, val num: Int) : Query() {
        override fun toString() = "$prev[$num]"
    }

    data class Sum(val prev: Query) : Query() {
        override fun toString() = "$prev++"
    }

    data class Template(val xml: String) : Query() {
        override fun toString() = xml
    }

}

data class XQL(val parameters: List<String>, val instructions: List<Instruction?>) {

    private val dict: MutableMap<String, XMLElement?> = mutableMapOf()

    fun run() {
        instructions.forEach {
            when (it) {
                is Load ->
                    dict[it.name] = XMLParser(
                        CommonTokenStream(
                            XMLLexer(
                                CharStreams.fromString(File(parameters[it.number - 1]).readText().trimIndent())
                            )
                        )
                    ).document().toAst().root

                is Assign -> dict[it.name] = exec(it.query)

                is Save -> {
                    val buffer = dict[it.name]
                    when (buffer) {
                        is XMLElement.Document -> File(parameters[it.number - 1]).writeText(buffer.indentToString())
                        is XMLElement.Tag -> File(parameters[it.number - 1]).writeText(buffer.indentToString(0))
                        else -> File(parameters[it.number - 1]).writeText(buffer.toString())
                    }
                }
            }
        }
    }

    private fun exec(query: Query): XMLElement? {
        return when (query) {
            is Query.Arrow ->
                when (val p = exec(query.prev)) {
                    is XMLElement.ResultList -> p.map(query.query)

                    is XMLElement.Tag -> {
                        XQLErrors.invalidMapOperation(query)
                        null
                    }

                    else -> {
                        XQLErrors.illegalMapOperation(query)
                        null
                    }
                }

            is Query.Sum ->
                when (val p = exec(query.prev)) {
                    is XMLElement.ResultList -> p.sum()

                    else -> {
                        XQLErrors.illegalSumOperation(query)
                        null
                    }
                }

            is Query.Dot ->
                when (val p = exec(query.prev)) {
                    is XMLElement.Tag -> p.find(query.query)
                    is XMLElement.Document -> p.find(query.query)

                    else -> {
                        XQLErrors.illegalDotOperation(query)
                        null
                    }
                }

            is Query.Count ->
                when (val p = exec(query.prev)) {
                    is XMLElement.ResultList, is XMLElement.Tag, is XMLElement.Document ->
                        XMLElement.Text("" + p.count())

                    else -> {
                        XQLErrors.illegalCountOperation(query)
                        null
                    }
                }

            is Query.Variable -> dict[query.name]

            is Query.Offset ->
                when (val p = exec(query.prev)) {
                    is XMLElement.ResultList ->
                        try {
                            p.elements[query.num]
                        } catch (_: Exception) {
                            XQLErrors.indexOutOfBounds(query)
                            null
                        }

                    else ->
                        if (query.num == 0) {
                            p
                        } else {
                            XQLErrors.indexOutOfBounds(query)
                            null
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

            parent.attributes.forEach {
                if (Regex("\\$\\w*").matches(it.value)) {
                    it.value = dict[it.value.removePrefix("$")].toString()
                }
            }
            parent.content.forEach {
                if (it is XMLElement.Tag) {
                    if (Regex("\\w+\\$\\w+").matches(it.name)) {
                        parent.content = expand(it, parent.content)
                    }
                }
            }
            parent.content.forEach {
                if (it is XMLElement.Tag) {
                    eval(it)
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
        dict.keys.forEach { builder.append("$it: " + dict[it] + "\n") }
        return builder.toString()
    }

}

fun XQLParser.DocumentContext.toAst(parameters: List<String>): XQL {
    val instructions = mutableListOf<Instruction?>()
    this.instruction().forEach { instructions.add(it.toAst()) }
    return XQL(parameters, instructions)
}

fun XQLParser.InstructionContext.toAst(): Instruction? {
    return when {
        this.load() != null ->
            Load(
                this.load().NAME().toString(),
                this.load().ARGUMENT().toString().removePrefix("$").toInt()
            )

        this.save() != null ->
            Save(
                this.save().NAME().toString(),
                this.save().ARGUMENT().toString().removePrefix("$").toInt()
            )

        this.assign() != null ->
            Assign(
                this.assign().NAME().toString(),
                this.assign().expression().toAst()
            )

        else -> throw IllegalStateException("Invalid type of instruction.")
    }
}

fun XQLParser.ExpressionContext.toAst(): Query {
    return when {
        this.TEMPLATE() != null ->
            Query.Template(this.TEMPLATE().toString().removeSurrounding("***"))

        this.composition() != null ->
            this.composition().toAst(Query.Variable(this.NAME().toString()))

        else -> Query.Variable(this.NAME().toString())
    }
}

fun XQLParser.CompositionContext.toAst(branch: Query): Query {
    return when {
        this.DOT() != null ->
            if (this.composition() != null) {
                this.composition().toAst(
                    Query.Dot(
                        branch,
                        this.NAME().toString()
                    )
                )
            } else {
                Query.Dot(branch, this.NAME().toString())
            }

        this.ARROW() != null ->
            when {
                this.SUM() != null -> Query.Sum(Query.Arrow(branch, this.NAME().toString()))
                this.COUNT() != null -> Query.Count(Query.Arrow(branch, this.NAME().toString()))

                this.OFFSET() != null ->
                    Query.Offset(
                        Query.Arrow(branch, this.NAME().toString()),
                        this.OFFSET().toString().removeSurrounding("[", "]").toInt()
                    )

                else -> Query.Arrow(branch, this.NAME().toString())
            }

        this.COUNT() != null -> Query.Count(branch)

        this.OFFSET() != null ->
            if (this.composition() != null) {
                this.composition().toAst(
                    Query.Offset(
                        branch,
                        this.OFFSET().toString().removeSurrounding("[", "]").toInt()
                    )
                )
            } else {
                Query.Offset(
                    branch,
                    this.OFFSET().toString().removeSurrounding("[", "]").toInt()
                )
            }

        this.SUM() != null -> Query.Sum(branch)

        else -> throw IllegalStateException("Invalid type of expression.")
    }
}

class XQLListener : XQLBaseListener() {

    // Maximum allowed number of arguments, minus one.
    val parameters = 2

    val declared = mutableListOf<String>()

    override fun enterLoad(context: XQLParser.LoadContext?) {
        if (context == null) {
            return
        }
        val argument = context.ARGUMENT()?.text.toString().removePrefix("$").toInt()
        if (argument > parameters) {
            XQLErrors.invalidArgument(argument, context.start?.line, context.text)
        }
        declared.add(context.NAME()?.text.toString())
    }

    override fun enterAssign(context: XQLParser.AssignContext?) {
        if (context == null) {
            return
        }
        declared.add(context.NAME()?.text.toString())
    }

    override fun enterExpression(context: XQLParser.ExpressionContext?) {
        if (context == null) {
            return
        }
        val name = context.NAME()?.text.toString()
        if (!(name == "null" || declared.contains(name))) {
            XQLErrors.undeclaredAssign(name, context.start?.line, context.text)
        }
    }

    override fun enterSave(context: XQLParser.SaveContext?) {
        if (context == null) {
            return
        }
        val name = context.NAME()?.text.toString()
        if (!(name == "null" || declared.contains(name))) {
            XQLErrors.undeclaredSave(name, context.start?.line, context.text)
        }
        val argument = context.ARGUMENT()?.text.toString().removePrefix("$").toInt()
        if (argument > parameters) {
            XQLErrors.invalidArgument(argument, context.start?.line, context.text)
        }
    }

}