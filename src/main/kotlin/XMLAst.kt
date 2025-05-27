package org.example

import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

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
                return tags[0].content.first()
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

        // TODO // Review.
        fun sum(): XMLElement? {
            val isString: MutableList<Boolean> = mutableListOf()
            val numberFormat = NumberFormat.getNumberInstance(Locale.ENGLISH) as DecimalFormat
            for (i in elements) {
                try {
                    when (i) {
                        is Text -> {
                            numberFormat.parse(i.text)
                            isString.add(false)
                        }

                        else -> return null
                    }
                } catch (_: Exception) {
                    isString.add(true)
                }
            }
            if (isString.distinct().size > 1 || isString.distinct()[0]) {
                val teste = ""
                for (i in elements)
                    when (i) {
                        is Text -> teste + i.text
                        else -> teste + ""
                    }
                return Text(teste)
            } else {
                var sum = 0
                for (i in elements) {
                    when (i) {
                        is Text -> sum += (numberFormat.parse(i.text)).toInt()
                        else -> {}
                    }
                }
                return Text("" + sum)
            }
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