package org.example

import XMLLexer
import XMLParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

fun main() {
    val lexer = XMLLexer(CharStreams.fromString("<test/>"))
    val parser = XMLParser(CommonTokenStream(lexer))


    parser.document().toAst()



    println("Hello World!")
}


fun XMLParser.DocumentContext.toAst() : XML{
    if (this.element()!=null){
        return XML(listOf(this.element().toAst()))
    }
    return XML(listOf())
}


fun XMLParser.ElementContext.toAst(): Tag{
    val atribs: MutableList<Attribute> = mutableListOf();
    for(i in this.attribute()){
        atribs.add(Attribute(name = i.Name().text, value = i.STRING().text))
    }
    return Tag(ident = this.Name().toString(), atributes = atribs, inner = this.content().toAst())
}

fun XMLParser.ContentContext.toAst(): Content{
    if (this.element().isEmpty()){
        return
    }
}

