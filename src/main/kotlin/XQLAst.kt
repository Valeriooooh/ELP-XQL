package org.example

import XMLLexer
import XMLParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File


data class XQL(val params: List<String>, val inst: List<Instruction>){
    val dict: MutableMap<String, Query> = mutableMapOf()
    fun run(){
        for( i in inst){
            when(i){
                is Load -> {
                    val file = File(params[i.number-1]).readText()
                    val xml_lexer = XMLLexer(
                        CharStreams.fromString(file.trimIndent()))
                    val xml_parser = XMLParser(CommonTokenStream(xml_lexer))
                    val xml_ast = xml_parser.document().toAst()
                    println(xml_ast)
                    dict[i.name] = Query.Variable(xml =xml_ast)
                }
                is Assign -> {

                }
                else -> {}
            }
        }


    }}

interface Instruction

data class Assign(val name: String, val query: Query): Instruction
data class Load(val number: Int, val name: String): Instruction
data class Save(val name: String, val number: Int): Instruction


sealed class Query {
    abstract fun exec(): XMLItem?
    data class Dot(val prev: Query, val query: String) : Query() {
        override fun exec(): XMLItem?{
            val p = prev.exec()
            if (p == null){
                return null
            }else{
                when(p){
                    is XMLItem.Attribute -> return null
                    is XMLItem.Tag -> {
                        p.find(query)

                    }
                    is XMLItem.Text -> return null;
                    is XMLItem.XML -> {
                        p.find(query)
                    }
                }
            }
            return null;
        }
    }


    data class Arrow(val prev: Query,val query: String) : Query(){
        override fun exec(): XMLItem?{
            return null
        }
    }
    data class Number(val prev: Query,val query: String) : Query(){
        override fun exec(): XMLItem?{
            return null
        }
    }
    data class Variable(val xml: XMLItem): Query(){
        override fun exec(): XMLItem?{
            return xml
        }

    }
}
