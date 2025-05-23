package org.example

import XMLParser

fun main() {
    XQL(
        parameters = listOf("uc.xml", "out.xml"), instructions = listOf(
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
        )
    ).run()
}

fun XMLParser.DocumentContext.toAst(): XMLElement.XML {
    if (this.element() != null) {
        return XMLElement.XML(listOf(this.element().toAst()))
    }
    return XMLElement.XML(listOf())
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