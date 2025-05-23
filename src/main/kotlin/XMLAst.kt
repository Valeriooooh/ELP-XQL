package org.example

import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

interface Queryable {
    fun find(query: String): XMLElement?
    fun count(): Int
}

sealed class XMLElement {

    data class Attribute(val name: String, val value: String) : XMLElement()

    data class Text(val text: String) : XMLElement()

    data class Tag(
        val name: String,
        val attributes: List<Attribute>,
        val content: List<XMLElement>
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
    }

    data class XML(val tag: List<Tag>) : Queryable, XMLElement() {
        override fun find(query: String): XMLElement? {
            for (i in tag) {
                if (i.name == query) {
                    return i
                }
            }
            return null
        }

        override fun count(): Int = 0
    }

    data class ResultList(val elements: List<XMLElement>) : Queryable, XMLElement() {

        override fun find(query: String): XMLElement? = null
        override fun count(): Int = elements.size

        fun get(index: Int): XMLElement? {
            return try {
                this.elements[index]
            } catch (e: Exception) {
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
                } catch (e: Exception) {
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