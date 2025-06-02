package org.example

import kotlin.system.exitProcess

class XQLErrors {
    companion object {

        const val RESET = "\u001B[0m"
        const val RED = "\u001B[31m"
        const val GREEN = "\u001B[32m"
        const val PURPLE = "\u001B[35m"
        const val CYAN = "\u001B[36m"

        fun colorPrint(color: String, text: String) {
            print("$color$text$RESET")
        }

        fun colorPrintln(color: String, text: String) {
            println("$color$text$RESET")
        }

        fun undeclaredAssign(name: String, line: Int?, region: String) {
            colorPrint(RED, "BUILD ERROR:")
            colorPrint(RESET, " variable")
            colorPrint(GREEN, " \"$name\"")
            colorPrint(RESET, " undeclared on line")
            colorPrintln(CYAN, " $line")

            colorPrint(CYAN, "$line:")
            colorPrintln(RESET, "\t${region.trim()}")

            colorPrintln(
                RED,
                "\t"
                        + " ".repeat(region.findAnyOf(listOf(name))?.first.toString().toInt())
                        + "^".repeat(name.length)
            )

            exitProcess(1)
        }

        fun undeclaredSave(name: String, line: Int?, region: String) {
            colorPrint(RED, "BUILD ERROR:")
            colorPrint(RESET, " variable")
            colorPrint(GREEN, " \"$name\"")
            colorPrint(RESET, " undeclared on line")
            colorPrintln(CYAN, " $line")

            colorPrint(CYAN, "$line:")
            colorPrintln(RESET, "\t$region")

            colorPrintln(
                RED,
                "\t"
                        + " ".repeat(region.findAnyOf(listOf(name))?.first.toString().toInt())
                        + "^".repeat(name.length)
            )

            exitProcess(1)
        }

        fun indexOutOfBounds(query: Query.Offset) {
            colorPrint(RED, "RUNTIME ERROR:")
            colorPrintln(RESET, " index out of bounds")

            colorPrintln(CYAN, "│")

            colorPrint(CYAN, "╰─>")
            colorPrintln(RESET, "\t$query")

            val length = query.num.toString().length
            colorPrintln(
                RED,
                "\t"
                        + " ".repeat(query.toString().length - length - 1)
                        + "^".repeat(length)
            )

            exitProcess(1)
        }

        fun notExists(element: String) {
            colorPrint(RED, "RUNTIME ERROR:")
            colorPrint(RESET, " element")
            colorPrint(PURPLE, " \"$element\"")
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

        fun illegalSumOperation(query: Query) {
            colorPrint(RED, "RUNTIME ERROR:")
            colorPrint(RESET, " illegal")
            colorPrint(RESET, " sum")
            colorPrint(RESET, " (")
            colorPrint(CYAN, "++")
            colorPrint(RESET, ")")
            colorPrintln(RESET, " operation")

            colorPrintln(CYAN, "│")

            colorPrint(CYAN, "╰─>")
            colorPrintln(RESET, "\t$query")

            colorPrintln(
                RED,
                "\t" + " ".repeat(query.toString().length - 2) + "^^"
            )

            exitProcess(1)
        }

        fun illegalSumOperation(element: XMLElement) {
            colorPrint(RED, "RUNTIME ERROR:")
            colorPrint(RESET, " illegal")
            colorPrint(RESET, " sum")
            colorPrint(RESET, " (")
            colorPrint(CYAN, "++")
            colorPrint(RESET, ")")
            colorPrintln(RESET, " operation on element")

            colorPrintln(CYAN, "│")

            when (element) {
                is XMLElement.Document -> {
                    colorPrintln(CYAN, "v")
                    colorPrintln(RESET, element.indentToString())
                }

                is XMLElement.Tag -> {
                    colorPrintln(CYAN, "v")
                    colorPrintln(RESET, element.indentToString(0))
                }

                else -> {
                    colorPrint(CYAN, "╰─>")
                    colorPrintln(RESET, "\t$element")
                }
            }

            exitProcess(1)
        }

        fun illegalDotOperation(query: Query.Dot) {
            colorPrint(RED, "RUNTIME ERROR:")
            colorPrint(RESET, " illegal")
            colorPrint(RESET, " dot")
            colorPrint(RESET, " (")
            colorPrint(CYAN, ".")
            colorPrint(RESET, ")")
            colorPrintln(RESET, " operation")

            colorPrintln(CYAN, "│")

            colorPrint(CYAN, "╰─>")
            colorPrintln(RESET, "\t$query")

            val length = query.query.length + 1
            colorPrintln(
                RED,
                "\t"
                        + " ".repeat(query.toString().length - length)
                        + "^".repeat(length)
            )

            colorPrint(CYAN, "help:")
            colorPrint(RESET, " did you mean")
            colorPrint(
                CYAN,
                " ${query.toString().reversed().replaceFirst(".", ">-").reversed()}"
            )
            colorPrintln(RESET, " ?")

            exitProcess(1)
        }

        fun invalidMapOperation(query: Query.Arrow) {
            colorPrint(RED, "RUNTIME ERROR:")
            colorPrint(RESET, " invalid")
            colorPrint(RESET, " map")
            colorPrint(RESET, " (")
            colorPrint(CYAN, "->")
            colorPrint(RESET, ")")
            colorPrintln(RESET, " operation")

            colorPrintln(CYAN, "│")

            colorPrint(CYAN, "╰─>")
            colorPrintln(RESET, "\t$query")

            val length = query.query.length + 2
            colorPrintln(
                RED,
                "\t"
                        + " ".repeat(query.toString().length - length)
                        + "^".repeat(length)
            )

            colorPrint(CYAN, "help:")
            colorPrint(RESET, " did you mean")
            colorPrint(
                CYAN,
                " ${query.toString().reversed().replaceFirst(">-", ".").reversed()}"
            )
            colorPrintln(RESET, " ?")

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
            colorPrintln(RESET, "\t$query")

            val length = query.query.length + 2
            colorPrintln(
                RED,
                "\t"
                        + " ".repeat(query.toString().length - length)
                        + "^".repeat(length)
            )

            colorPrint(CYAN, "help:")
            colorPrintln(RESET, " map operations should be used on lists")

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
            colorPrintln(RESET, "\t$query")

            colorPrintln(
                RED,
                "\t" + " ".repeat(query.toString().length - 1) + "^"
            )

            colorPrint(CYAN, "help:")
            colorPrintln(RESET, " count operations should be used on lists/entities")

            exitProcess(1)
        }

    }
}