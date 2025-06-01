package org.example

import XMLLexer
import XMLParser
import XQLBaseListener
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File
import kotlin.system.exitProcess

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
                    is XMLElement.Tag -> {
                        XQLErrors().invalidMapOperation(query)
                        exitProcess(1)
                    }
                    else -> {
                        XQLErrors().illegalMapOperation(query)
                        exitProcess(1)
                    }
                }
            }

            is Query.Sum -> {
                when (val p = exec(query.prev)) {
                    is XMLElement.ResultList -> p.sum()
                    else -> {
                        XQLErrors().illegalSumOperation(query)
                        exitProcess(1)
                    }
                }
            }

            is Query.Dot -> {
                when (val p = exec(query.prev)) {
                    is XMLElement.Tag -> p.find(query.query)
                    is XMLElement.Document -> p.find(query.query)
                    else -> {null
                    }
                }
            }

            is Query.Count -> {
                when (val p = exec(query.prev)) {
                    is XMLElement.ResultList , is XMLElement.Tag , is XMLElement.Document -> XMLElement.Text(""+p.count())
                    else -> {
                        XQLErrors().illegalCountOperation(query)
                        exitProcess(1)
                    }
                }
            }

            is Query.Variable -> {
                dict[query.name]
            }

            is Query.Offset -> {
                when (val p = exec(query.prev)) {
                    is XMLElement.ResultList -> try {
                        p.elements[query.num]
                    } catch (_: Exception) {
                        XQLErrors().indexOutOfBounds(query)
                        exitProcess(1)
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
    return when {
        this.load() != null ->
            Load(
                this.load().variable().NAME().toString(),
                this.load().ARGUMENT().toString().removePrefix("$").toInt()
            )

        this.save() != null ->
            Save(
                this.save().variable().NAME().toString(),
                this.save().ARGUMENT().toString().removePrefix("$").toInt()
            )

        this.assign() != null ->
            Assign(
                this.assign().variable().NAME().toString(),
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
            this.composition().toAst(Query.Variable(this.variable().NAME().toString()))

        else -> Query.Variable(this.variable().NAME().toString())
    }
}

fun XQLParser.CompositionContext.toAst(branch: Query): Query {
    return when {
        this.DOT() != null ->
            if (this.composition() != null) {
                this.composition().toAst(
                    Query.Dot(
                        branch,
                        this.variable().NAME().toString()
                    )
                )
            } else {
                Query.Dot(branch, this.variable().NAME().toString())
            }

        this.ARROW() != null ->
            when {
                this.SUM() != null -> Query.Sum(Query.Arrow(branch, this.attribute().NAME().toString()))
                this.COUNT() != null -> Query.Count(Query.Arrow(branch, this.attribute().NAME().toString()))
                else -> Query.Arrow(branch, this.attribute().NAME().toString())
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

        else -> throw IllegalArgumentException("Invalid type of query.")
    }
}


class XQLListener : XQLBaseListener() {
    val declared = mutableListOf<String>()

    override fun enterAssign(ctx: XQLParser.AssignContext?) {
        if (ctx == null){
            return
        }
        val name  = ctx.variable()?.NAME()?.text.toString()
        declared.add(name)
    }

    override fun enterLoad(ctx: XQLParser.LoadContext?) {
        if (ctx == null){
            return
        }
        val name  = ctx.variable()?.NAME()?.text.toString()
        declared.add(name)
    }

    override fun enterExpression(ctx: XQLParser.ExpressionContext?) {
        if (ctx == null){
            return
        }
        val name = ctx.variable()?.NAME()?.text.toString()
        if (name != "null"){
            if (!declared.contains(name)){
                val region = ctx.text
                val line = ctx.variable().start?.line
                XQLErrors().undeclared(name, line, region)
            }
        }
    }
}