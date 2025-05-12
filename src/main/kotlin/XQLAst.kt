package org.example

import XMLLexer
import XMLParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File


data class XQL(val params: List<String>, val inst: List<Instruction>) {
    val dict: MutableMap<String, XMLItem?> = mutableMapOf()
    fun run() {
        for (i in inst) {
            when (i) {
                is Load -> {
                    val file = File(params[i.number - 1]).readText()
                    val xml_lexer = XMLLexer(
                        CharStreams.fromString(file.trimIndent())
                    )
                    val xml_parser = XMLParser(CommonTokenStream(xml_lexer))
                    val xml_ast = xml_parser.document().toAst()
                    println(xml_ast)
                    dict[i.name] = xml_ast
                }

                is Assign -> {
                    dict[i.name] = exec(i.query)
                    println(dict[i.name])

                }

                else -> {}
            }
        }
    }
    fun exec(query: Query): XMLItem?{
        return when(query){
            is Query.Arrow -> TODO()
            is Query.Dot -> {
                when(val p = exec(query.prev)){
                     is XMLItem.Tag -> p.find(query.query)
                     is XMLItem.XML -> p.find(query.query)
                     else -> null
                 }
            }
            is Query.Number -> TODO()
            is Query.Variable -> dict[query.name]
            is Query.Offset -> TODO()
        }
    }
}
interface Instruction

data class Assign(val name: String, val query: Query): Instruction
data class Load(val number: Int, val name: String): Instruction
data class Save(val name: String, val number: Int): Instruction


sealed class Query {
    data class Dot(val prev: Query, val query: String) : Query() {}
    data class Arrow(val prev: Query,val query: String) : Query(){}
    data class Number(val prev: Query,val query: String) : Query(){}
    data class Variable(val name: String): Query(){}

    data class Offset(val prev: Query, val num: Int): Query(){}
}

