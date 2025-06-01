package org.example

interface Queryable {
    fun find(query: String): XMLElement?
    fun count(): Int
}

sealed class XMLElement {

    data class Attribute(val name: String, var value: String) : XMLElement() {
        override fun toString(): String = "$name=\"$value\""
    }

    data class Text(val text: String) : XMLElement() {
        override fun toString(): String = text
    }

    data class Tag(
        val name: String,
        val attributes: List<Attribute>,
        var content: List<XMLElement>
    ) : Queryable, XMLElement() {
        override fun find(query: String): XMLElement {
            for (i in attributes) {
                if (i.name == query) {
                    return Text(i.value)
                }
            }
            val tags: MutableList<Tag> = mutableListOf()
            for (i in content) {
                when (i) {
                    is Tag -> {
                        if (i.name == query) {
                            tags.add(i)
                        }
                    }

                    else -> {}
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
            return ResultList(tags)
        }

        override fun count(): Int = 0

        override fun toString(): String {
            val builder = StringBuilder()
            builder.append("<$name")
            for (i in attributes) {
                builder.append(" $i")
            }
            if (content.isEmpty()) {
                builder.append(" />")
                return builder.toString()
            }
            builder.append(">")
            for (i in content) {
                builder.append(i)
            }
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

        override fun count(): Int = 0

        override fun toString(): String {
            return root.toString()
        }
    }

    data class ResultList(val elements: List<XMLElement>) : Queryable, XMLElement() {

        override fun find(query: String): XMLElement? = null
        override fun count(): Int = elements.size

        fun get(index: Int): XMLElement? {
            return try {
                this.elements[index]
            } catch (_: Exception) {
                null
            }
        }

        fun sum(): XMLElement? {
            var sum = 0
            for (i in elements) {
                if (i is Text) {
                    try {
                        sum += i.text.toInt()
                    } catch (_: NumberFormatException) {
                        throw IllegalArgumentException("Invalid sum operation: \"" + i.text + "\" is not a valid integer.")
                    }
                }
            }
            return Text("" + sum)
        }

        fun map(query: String): XMLElement {
            val results: MutableList<XMLElement> = mutableListOf()
            for (i in elements) {
                when (i) {
                    is Tag -> {
                        for (j in i.attributes) {
                            if (j.name == query) {
                                results.add(Text(j.value))
                            }
                        }
                        for (j in i.content) {
                            when (j) {
                                is Tag -> {
                                    if (j.name == query) {
                                        results.add(j.content[0])
                                    }
                                }

                                else -> {}
                            }
                        }
                    }

                    else -> {}
                }
            }
            return ResultList(results)
        }
    }

}

fun XMLParser.DocumentContext.toAst(): XMLElement.Document {
    return XMLElement.Document(this.element().toAst())
}

fun XMLParser.ElementContext.toAst(): XMLElement.Tag {
    val attributes: MutableList<XMLElement.Attribute> = mutableListOf()
    for (i in this.attribute()) {
        attributes.add(XMLElement.Attribute(name = i.Name().text, value = i.STRING().text.trim('"')))
    }
    return if (this.content() == null) {
        XMLElement.Tag(name = this.Name()[0].text, attributes = attributes, content = listOf())
    } else {
        XMLElement.Tag(name = this.Name()[0].text, attributes = attributes, content = this.content().toAst())
    }
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