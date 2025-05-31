package org.example

import XQLLexer
import XQLParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File

fun main(args: Array<String>) {
    if (args.size != 3) {
        print(
            "XQL Interpreter\n" +
                    "Usage:\n" +
                    "\txql <XQL file> <Input XML file> <Output XML file>"
        )
        return;
    }
    XQLParser(
        CommonTokenStream(
            XQLLexer(
                CharStreams.fromString(File(args[0]).readText().trimIndent())
            )
        )
    ).document().toAst(listOf(args[1], args[2])).run()
}