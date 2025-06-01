package org.example

import XQLLexer
import XQLParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import java.io.File

fun main(args: Array<String>) {
    if (args.size != 3) {
        println(
            "XQL Interpreter\n" +
                    "Usage:\n" +
                    "\txql <XQL file> <Input XML file> <Output XML file>"
        )
        return;
    }
    val listener = XQLListener()
    val walker = ParseTreeWalker()

    val xql_tree = XQLParser(
        CommonTokenStream(
            XQLLexer(
                CharStreams.fromString(File(args[0]).readText().trimIndent())
            )
        )
    ).document();
    walker.walk(listener, xql_tree)

    xql_tree.toAst(listOf(args[1], args[2])).run()
}