package org.example

import XMLLexer
import XMLParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File


fun main() {
    val code = XQL(params = listOf("file.xml", "out.xml"), inst = listOf(
        //       load $1 to doc        // carrega xml do primeiro argumento
        Load(1, "doc"),
        //setid = doc.id        // "demo"
        Assign("setid", Query.Dot(Query.Variable("doc"), "id")),
        //courses = doc.course  // [<course ..>..</course>,<course ..>..</course>]
        Assign("courses", Query.Dot(Query.Variable("doc"), "course")),
        //elp = doc.course[0]   // <course code="elp">..</course>
        Assign("elp", Query.Offset(Query.Dot(Query.Variable("doc"), "course"), 0)),
        //pacredits = doc.course[1].credits // 6
        Assign("pacredits", Query.Dot(Query.Offset(Query.Dot(Query.Variable("doc"), "course"), 1), "credits")),
        //elpeval = doc.course[0].evaluation // [<item ..>, <item ..>]
        Assign("pacredits", Query.Dot(Query.Offset(Query.Dot(Query.Variable("doc"), "course"), 1), "evaluation")),
        //total = doc.course# // 2
        Assign("total", Query.Count(Query.Dot(Query.Variable("doc"), "course"))),
        //ids = doc.course->code // ["elp","pa"]
        Assign("ids", Query.Arrow(Query.Dot(Query.Variable("doc"), "course"), "code")),
        //credits = doc.course->credits++
        Assign("credits", Query.Sum(Query.Arrow(Query.Dot(Query.Variable("doc"), "course"), "credits"))),


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
        attribs.add(XMLItem.Attribute(name = i.Name().text, value = i.STRING().text.trim('"')))
    }
    return if (this.content() == null){
        XMLItem.Tag(ident = this.Name()[0].text, attributes = attribs, inner = listOf())
    }else{
        XMLItem.Tag(ident = this.Name()[0].text, attributes = attribs, inner = this.content().toAst())
    }
}

fun XMLParser.ContentContext.toAst(): List<XMLItem>{
    val cont: MutableList<XMLItem> = mutableListOf()
    if (this.chardata().isNotEmpty() && this.chardata() != null){
       cont.addAll(this.chardata().map { it.toAst() })
    }
    if (this.element().isNotEmpty() && this.element() != null){
        cont.addAll(this.element().map { it.toAst() })
    }
    cont.removeAll { it == XMLItem.Text("") }
    return cont
}

fun XMLParser.ChardataContext.toAst(): XMLItem{
    if(this.TEXT() == null){
        return XMLItem.Text("")
    }
    return XMLItem.Text(this.TEXT().toString());
}

