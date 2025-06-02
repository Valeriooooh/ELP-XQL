package org.example

interface Queryable {
    fun find(query: String): XMLElement?
    fun count(): Int
}

sealed class XMLElement {

    data class Attribute(val name: String, var value: String) : XMLElement() {
        override fun toString() = "$name=\"$value\""
    }

    data class Text(val text: String) : XMLElement() {
        override fun toString() = text
    }

    data class Tag(
        val name: String, val attributes: List<Attribute>, var content: List<XMLElement>
    ) : Queryable, XMLElement() {

        override fun find(query: String): XMLElement {
            attributes.forEach {
                if (it.name == query) {
                    return Text(it.value)
                }
            }
            val tags: MutableList<Tag> = mutableListOf()
            content.forEach {
                if (it is Tag) {
                    if (it.name == query) {
                        tags.add(it)
                    }
                }
            }
            if (tags.size == 1) {
                if (tags[0].attributes.isEmpty()) {
                    if (tags[0].content.size == 1) {
                        return tags[0].content.first()
                    }
                    return ResultList(tags[0].content)
                }
                return tags[0]
            }
            if (tags.isEmpty()) {
                XQLErrors.notExists(query)
            }
            return ResultList(tags)
        }

        override fun count() = 1

        fun indentToString(indentation: Int): String {
            val builder = StringBuilder()
            builder.append("<$name")
            attributes.forEach { builder.append(" $it") }
            if (content.isEmpty()) {
                builder.append(" />")
                return builder.toString()
            }
            builder.append(">\n")
            content.forEach {
                if (it is Tag) {
                    builder.append("\t".repeat(indentation + 1) + it.indentToString(indentation + 1) + "\n")
                } else {
                    builder.append("\t".repeat(indentation + 1) + it.toString().trim() + "\n")
                }
            }
            builder.append("\t".repeat(indentation) + "</$name>")
            return builder.toString()
        }

        override fun toString(): String {
            val builder = StringBuilder()
            builder.append("<$name")
            attributes.forEach { builder.append(" $it") }
            if (content.isEmpty()) {
                builder.append(" />")
                return builder.toString()
            }
            builder.append(">")
            content.forEach { builder.append(it) }
            builder.append("</$name>")
            return builder.toString()
        }

    }

    data class Document(val root: Tag) : Queryable, XMLElement() {

        override fun find(query: String): XMLElement? {
            if (root.name == query) {
                return root
            }
            return null
        }

        override fun count() = 1

        fun indentToString() = root.indentToString(0)

        override fun toString() = root.toString()

    }

    data class ResultList(val elements: List<XMLElement>) : Queryable, XMLElement() {

        override fun find(query: String): XMLElement? {
            XQLErrors.notExists(query)
            return null
        }

        override fun count() = elements.size

        fun sum(): XMLElement? {
            var sum = 0.0
            elements.forEach {
                if (it is Text) {
                    try {
                        sum += it.text.toDouble()
                    } catch (_: NumberFormatException) {
                        XQLErrors.invalidSumOperation(it.text)
                    }
                } else {
                    XQLErrors.illegalSumOperation(it)
                }
            }
            if (sum - sum.toInt().toDouble() == 0.0) {
                return Text("" + sum.toInt())
            }
            return Text("" + sum)
        }

        fun map(query: String): XMLElement {
            val results: MutableList<XMLElement> = mutableListOf()
            elements.forEach { element ->
                if (element is Tag) {
                    element.attributes.forEach { attribute ->
                        if (attribute.name == query) {
                            results.add(Text(attribute.value))
                        }
                    }
                    element.content.forEach { child ->
                        if (child is Tag) {
                            if (child.name == query) {
                                results.add(child.content[0])
                            }
                        }
                    }
                }
            }
            if (results.isEmpty()) {
                XQLErrors.notExists(query)
            }
            return ResultList(results)
        }

        override fun toString(): String {
            val builder = StringBuilder()
            elements.forEach {
                builder.append("\"$it\",")
            }
            return "[" + builder.removeSuffix(",") + "]"
        }

    }

}

fun XMLParser.DocumentContext.toAst(): XMLElement.Document {
    return XMLElement.Document(this.element().toAst())
}

fun XMLParser.ElementContext.toAst(): XMLElement.Tag {
    val attributes: MutableList<XMLElement.Attribute> = mutableListOf()
    this.attribute().forEach {
        attributes.add(XMLElement.Attribute(it.Name().text, it.STRING().text.trim('"')))
    }
    if (this.content() == null) {
        return XMLElement.Tag(this.Name()[0].text, attributes, listOf())
    }
    return XMLElement.Tag(this.Name()[0].text, attributes, this.content().toAst())
}

fun XMLParser.ContentContext.toAst(): List<XMLElement> {
    val content: MutableList<XMLElement> = mutableListOf()
    if (this.chardata().isNotEmpty() && this.chardata() != null) {
        content.addAll(this.chardata().map { it.toAst() })
    }
    if (this.element().isNotEmpty() && this.element() != null) {
        content.addAll(this.element().map { it.toAst() })
    }
    content.removeAll { it == XMLElement.Text("") }
    return content
}

fun XMLParser.ChardataContext.toAst(): XMLElement {
    if (this.TEXT() == null) {
        return XMLElement.Text("")
    }
    return XMLElement.Text(this.TEXT().toString())
}