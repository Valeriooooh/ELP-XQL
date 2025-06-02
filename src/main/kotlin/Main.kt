package org.example

import XQLLexer
import XQLParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import java.io.File
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 3) {
        println(
            "XQL Interpreter\n" +
                    "Usage:\n" +
                    "\txql <XQL file> <Input XML file> <Output XML file>"
        )
        exitProcess(1)
    }
    val parser = XQLParser(
        CommonTokenStream(
            XQLLexer(
                CharStreams.fromString(File(args[0]).readText().trimIndent())
            )
        )
    ).document()
    ParseTreeWalker().walk(XQLListener(), parser)
    val xql = parser.toAst(listOf(args[1], args[2]))
    xql.run()

    // Uncomment this for verbose mode.
    // println(xql)
}