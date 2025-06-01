package org.example

import kotlin.system.exitProcess

class XQLErrors {
    companion object {

        const val RESET = "\u001B[0m"
        const val BLACK = "\u001B[30m"
        const val RED = "\u001B[31m"
        const val GREEN = "\u001B[32m"
        const val YELLOW = "\u001B[33m"
        const val BLUE = "\u001B[34m"
        const val PURPLE = "\u001B[35m"
        const val CYAN = "\u001B[36m"
        const val WHITE = "\u001B[37m"

        fun colorPrint(color: String, str: String) {
            print("$color$str$RESET")
        }

        fun colorPrintln(color: String, str: String) {
            print("$color$str$RESET\n")
        }

        fun undeclaredAssign(name: String, line: Int?, region: String) {
            colorPrint(RED, "SYNTAX ERROR:")
            colorPrint(RESET, " variable")
            colorPrint(GREEN, " $name")
            colorPrint(RESET, " undeclared on line")
            colorPrintln(CYAN, " $line")
            colorPrint(CYAN, "$line:")
            colorPrintln(RESET, "\t${region.trimStart()}")
            colorPrintln(
                RED, "\t" + " "
                    .repeat(region.findAnyOf(listOf(name))?.first.toString().toInt())
                        + "^"
                    .repeat(name.length)
            )
            exitProcess(1)
        }

        fun undeclaredSave(name: String, line: Int?, region: String) {
            colorPrint(RED, "SYNTAX ERROR:")
            colorPrint(RESET, " variable")
            colorPrint(GREEN, " $name")
            colorPrint(RESET, " undeclared on line")
            colorPrintln(CYAN, " $line")
            colorPrint(CYAN, "$line:")
            colorPrintln(RESET, "\t$region")
            colorPrintln(
                RED, "\t" + " "
                    .repeat(region.findAnyOf(listOf(name))?.first.toString().toInt())
                        + "^"
                    .repeat(name.length)
            )
            exitProcess(1)
        }

        fun indexOutOfBounds(query: Query.Offset) {
            colorPrint(RED, "RUNTIME ERROR:")
            colorPrintln(RESET, " index out of bounds")
            colorPrintln(CYAN, "│")
            colorPrint(CYAN, "╰─>")
            colorPrintln(RESET, "\t${query.toString()}")
            val digits = query.num.toString().length
            colorPrintln(
                RED,
                "\t" + " ".repeat(query.toString().length - 1 - digits) + "^".repeat(digits)
            )
            exitProcess(1)
        }

        fun notExists(query: String) {
            colorPrint(RED, "RUNTIME ERROR:")
            colorPrint(RESET, " element")
            colorPrint(PURPLE, " $query")
            colorPrintln(RESET, " does not exist")
            exitProcess(1)
        }

        fun invalidSumOperation(element: String) {
            colorPrint(RED, "RUNTIME ERROR:")
            colorPrint(RESET, " invalid")
            colorPrint(RESET, " sum")
            colorPrint(RESET, " (")
            colorPrint(CYAN, "++")
            colorPrint(RESET, ")")
            colorPrint(RESET, " operation on element")
            colorPrint(GREEN, " \"$element\"")
            colorPrint(RESET, " of type")
            colorPrintln(PURPLE, " string")
            exitProcess(1)
        }

        fun illegalSumOperation(query: Query.Sum) {
            colorPrint(RED, "RUNTIME ERROR:")
            colorPrint(RESET, " illegal")
            colorPrint(RESET, " sum")
            colorPrint(RESET, " (")
            colorPrint(CYAN, "++")
            colorPrint(RESET, ")")
            colorPrintln(RESET, " operation")
            colorPrintln(CYAN, "│")
            colorPrint(CYAN, "╰─>")
            colorPrintln(RESET, "\t${query.toString()}")
            val digits = 2
            colorPrintln(
                RED,
                "\t" + " ".repeat(query.toString().length - digits) + "^".repeat(digits)
            )
            exitProcess(1)
        }

        fun invalidMapOperation(query: Query.Arrow) {
            colorPrint(RED, "RUNTIME ERROR:")
            colorPrint(RESET, " invalid")
            colorPrint(RESET, " map")
            colorPrint(RESET, " (")
            colorPrint(CYAN, "->")
            colorPrint(RESET, ")")
            colorPrintln(RESET, " operation:")
            colorPrintln(CYAN, "│")
            colorPrint(CYAN, "╰─>")
            colorPrintln(RESET, "\t${query.toString()}")
            val digits = query.query.length
            colorPrintln(
                RED,
                "\t" + " ".repeat(query.toString().length - 2 - digits) + "^".repeat(digits + 2)
            )
            colorPrint(CYAN, "help:")
            colorPrintln(RESET, " map operation on tags should be:")
            colorPrintln(
                RESET,
                "\t${query.toString().reversed().replaceFirst(">-", ".").reversed()}"
            )
            exitProcess(1)
        }

        fun illegalMapOperation(query: Query.Arrow) {
            colorPrint(RED, "RUNTIME ERROR:")
            colorPrint(RESET, " illegal")
            colorPrint(RESET, " map")
            colorPrint(RESET, " (")
            colorPrint(CYAN, "->")
            colorPrint(RESET, ")")
            colorPrintln(RESET, " operation")
            colorPrintln(CYAN, "│")
            colorPrint(CYAN, "╰─>")
            colorPrintln(RESET, "\t${query.toString()}")
            val digits = query.query.length
            colorPrintln(
                RED,
                "\t" + " ".repeat(query.toString().length - 2 - digits) + "^".repeat(digits + 2)
            )
            colorPrint(CYAN, "help:")
            colorPrint(RESET, " map operation should be used on lists of tags")
            exitProcess(1)
        }

        fun illegalCountOperation(query: Query.Count) {
            colorPrint(RED, "RUNTIME ERROR:")
            colorPrint(RESET, " illegal")
            colorPrint(RESET, " count")
            colorPrint(RESET, " (")
            colorPrint(CYAN, "#")
            colorPrint(RESET, ")")
            colorPrintln(RESET, " operation")
            colorPrintln(CYAN, "│")
            colorPrint(CYAN, "╰─>")
            colorPrintln(RESET, "\t${query.toString()}")
            val digits = 1
            colorPrintln(
                RED,
                "\t" + " ".repeat(query.toString().length - digits) + "^".repeat(digits)
            )
            colorPrint(CYAN, "help:")
            colorPrint(RESET, " count operation should be used on lists/entities")
            exitProcess(1)
        }

    }
}