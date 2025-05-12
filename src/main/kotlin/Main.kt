package org.example

import XMLLexer
import XMLParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream


fun main() {
 /*   val xml_lexer = XMLLexer(CharStreams.fromString("""
<uc-set id="demo">
     <course code="ELP">
         <credits>6</credits>
         <evaluation>
             <item name="test" weight="40"/>
             <item name="project" weight="60"/>
         </evaluation>
     </course>
     <course code="PA">
         <credits>6</credits>
         <evaluation>
             <item name="quizzes" weight="20"/>
             <item name="project" weight="80"/>
         </evaluation>
    </course>
</uc-set>
    """.trimIndent()))
*/
 //   val xml_parser = XMLParser(CommonTokenStream(xml_lexer))
 //   val xml_ast = xml_parser.document().toAst()


    val code = XQL(params = listOf("file.xml", "out.xml"), inst = listOf(
        Load(1, "file"),
        //Assign("test", )


    )).run()


    //println(xml_ast)
}


fun XMLParser.DocumentContext.toAst() : XMLItem.XML{
    if (this.element()!=null){
        return XMLItem.XML(listOf(this.element().toAst()))
    }
    return XMLItem.XML(listOf())
}

fun XMLParser.ElementContext.toAst(): XMLItem.Tag{
    val attribs: MutableList<XMLItem.Attribute> = mutableListOf();
    for(i in this.attribute()){
        attribs.add(XMLItem.Attribute(name = i.Name().text, value = i.STRING().text))
    }
    return if (this.content() == null){
        XMLItem.Tag(ident = this.Name().toString(), attributes = attribs, inner = listOf())
    }else{
        XMLItem.Tag(ident = this.Name().toString(), attributes = attribs, inner = this.content().toAst())
    }
}

fun XMLParser.ContentContext.toAst(): List<Content>{
    val cont: MutableList<Content> = mutableListOf()
    if (this.chardata().isNotEmpty() && this.chardata() != null){
       cont.addAll(this.chardata().map { it.toAst() })
    }
    if (this.element().isNotEmpty() && this.element() != null){
        cont.addAll(this.element().map { it.toAst() })
    }
    cont.removeAll { it == XMLItem.Text("") }
    return cont
}

fun XMLParser.ChardataContext.toAst(): Content{
    if(this.TEXT() == null){
        return XMLItem.Text("")
    }
    return XMLItem.Text(this.TEXT().toString());
}

