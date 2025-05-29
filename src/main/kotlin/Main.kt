package org.example

import XQLLexer
import XQLParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File

fun main(args: Array<String>) {
    val xql = XQLParser(
        CommonTokenStream(
            XQLLexer(
                CharStreams.fromString(File(args[0]).readText().trimIndent())
            )
        )
    ).document().toAst(listOf(args[1], args[2]))
    xql.run()
    println(xql)
}

// Here temporarily.
fun example() {
    XQL(
        parameters = listOf("uc.xml", "out.xml"), instructions = listOf(

            // load $1 to doc
            Load("doc", 1),

            // setid = doc.id
            Assign("setid", Query.Dot(Query.Variable("doc"), "id")),

            // courses = doc.course
            Assign("courses", Query.Dot(Query.Variable("doc"), "course")),

            // elp = doc.course[0]
            Assign("elp", Query.Offset(Query.Dot(Query.Variable("doc"), "course"), 0)),

            // pacredits = doc.course[1].credits
            Assign("pacredits", Query.Dot(Query.Offset(Query.Dot(Query.Variable("doc"), "course"), 1), "credits")),

            // elpeval = doc.course[0].evaluation
            Assign("elpeval", Query.Dot(Query.Offset(Query.Dot(Query.Variable("doc"), "course"), 0), "evaluation")),

            // total = doc.course#
            Assign("total", Query.Count(Query.Dot(Query.Variable("doc"), "course"))),

            // ids = doc.course->code
            Assign("ids", Query.Arrow(Query.Dot(Query.Variable("doc"), "course"), "code")),

            // credits = doc.course->credits++
            Assign("credits", Query.Sum(Query.Arrow(Query.Dot(Query.Variable("doc"), "course"), "credits"))),

            // XML template
            Assign(
                "xml", Query.Template(
                    "<summary count=\"\$total\" credits=\"\$credits\">\n" +
                            "<uc\$courses name=\"\$code\"/>\n" +
                            "</summary>"
                )
            ),

            // save xml to $2
            Save("xml", 2)
        )
    )
}