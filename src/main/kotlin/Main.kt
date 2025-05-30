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