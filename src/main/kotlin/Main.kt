package org.example

fun main() {
    val code = XQL(
        parameters = listOf("uc.xml", "out.xml"), instructions = listOf(
            // load $1 to doc        // carrega xml do primeiro argumento
            Load("doc", 1),
            // setid = doc.id        // "demo"
            Assign("setid", Query.Dot(Query.Variable("doc"), "id")),
            // courses = doc.course  // [<course ..>..</course>,<course ..>..</course>]
            Assign("courses", Query.Dot(Query.Variable("doc"), "course")),
            // elp = doc.course[0]   // <course code="elp">..</course>
            Assign("elp", Query.Offset(Query.Dot(Query.Variable("doc"), "course"), 0)),
            // pacredits = doc.course[1].credits // 6
            Assign("pacredits", Query.Dot(Query.Offset(Query.Dot(Query.Variable("doc"), "course"), 1), "credits")),
            // elpeval = doc.course[0].evaluation // [<item ..>, <item ..>]
            Assign("elpeval", Query.Dot(Query.Offset(Query.Dot(Query.Variable("doc"), "course"), 0), "evaluation")),
            // total = doc.course# // 2
            Assign("total", Query.Count(Query.Dot(Query.Variable("doc"), "course"))),
            // ids = doc.course->code // ["elp","pa"]
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
    code.run()
    println(code)
}