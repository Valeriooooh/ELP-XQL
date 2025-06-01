package org.example

import kotlin.system.exitProcess

class XQLErrors{
    class ErrorColor {
        val RESET = "\u001B[0m"
        val BLACK = "\u001B[30m"
        val RED = "\u001B[31m"
        val GREEN = "\u001B[32m"
        val YELLOW = "\u001B[33m"
        val BLUE = "\u001B[34m"
        val PURPLE = "\u001B[35m"
        val CYAN = "\u001B[36m"
        val WHITE = "\u001B[37m"

        fun colorPrint(color: String, str: String){
            print("$color$str$RESET")
        }
        fun colorPrintln(color: String, str: String){
            print("$color$str$RESET\n")
        }
    }

    fun undeclared(name: String, line: Int?, region: String){
        ErrorColor().colorPrint(ErrorColor().RED,"ERROR:")
        ErrorColor().colorPrint(ErrorColor().RESET," variable")
        ErrorColor().colorPrint(ErrorColor().GREEN," $name")
        ErrorColor().colorPrint(ErrorColor().RESET," undeclared on line:")
        ErrorColor().colorPrintln(ErrorColor().RED," $line")

        ErrorColor().colorPrint(ErrorColor().CYAN,"$line:")
        ErrorColor().colorPrintln(ErrorColor().RESET,"\t$region")
        ErrorColor().colorPrintln(ErrorColor().RED, "\t" + "^".repeat(name.length))
        exitProcess(1)
    }

    fun indexOutOfBounds(query: Query){
        ErrorColor().colorPrint(ErrorColor().RED,"ERROR:")
        ErrorColor().colorPrintln(ErrorColor().RESET," index out of bounds")
        if (query is Query.Offset){
            ErrorColor().colorPrintln(ErrorColor().CYAN,"│")
            ErrorColor().colorPrint(ErrorColor().CYAN,"╰─>")
            ErrorColor().colorPrintln(ErrorColor().RESET,"\t${query.toString()}")
            val digits  = query.num.toString().length
            ErrorColor().colorPrintln(ErrorColor().RED,"\t"+ " ".repeat(query.toString().length -1 -digits) + "^".repeat(digits))
        }
        exitProcess(1)
    }

    fun notExist(query: String){
        ErrorColor().colorPrint(ErrorColor().RED,"ERROR:")
        ErrorColor().colorPrint(ErrorColor().RESET," element")
        ErrorColor().colorPrint(ErrorColor().PURPLE," $query")
        ErrorColor().colorPrintln(ErrorColor().RESET," does not exist")
        exitProcess(1)
    }

    fun invalidSumOperation(element: String){
        ErrorColor().colorPrint(ErrorColor().RED,"ERROR:")
        ErrorColor().colorPrint(ErrorColor().RESET," invalid")
        ErrorColor().colorPrint(ErrorColor().RESET," sum")
        ErrorColor().colorPrint(ErrorColor().RESET," (")
        ErrorColor().colorPrint(ErrorColor().CYAN,"++")
        ErrorColor().colorPrint(ErrorColor().RESET,")")
        ErrorColor().colorPrint(ErrorColor().RESET," operation on element")
        ErrorColor().colorPrint(ErrorColor().GREEN," \"$element\"")
        ErrorColor().colorPrint(ErrorColor().RESET," of type")
        ErrorColor().colorPrint(ErrorColor().PURPLE," string")
        exitProcess(1)
    }

    fun illegalSumOperation(query: Query){
        ErrorColor().colorPrint(ErrorColor().RED,"ERROR:")
        ErrorColor().colorPrint(ErrorColor().RESET," illegal")
        ErrorColor().colorPrint(ErrorColor().RESET," sum")
        ErrorColor().colorPrint(ErrorColor().RESET," (")
        ErrorColor().colorPrint(ErrorColor().CYAN,"++")
        ErrorColor().colorPrint(ErrorColor().RESET,")")
        ErrorColor().colorPrintln(ErrorColor().RESET," operation")
        if (query is Query.Sum){
            ErrorColor().colorPrintln(ErrorColor().CYAN,"│")
            ErrorColor().colorPrint(ErrorColor().CYAN,"╰─>")
            ErrorColor().colorPrintln(ErrorColor().RESET,"\t${query.toString()}")
            val digits  = 2
            ErrorColor().colorPrintln(ErrorColor().RED,"\t"+ " ".repeat(query.toString().length -digits) + "^".repeat(digits))
        }
        exitProcess(1)
    }
    fun invalidMapOperation(query: Query){
        ErrorColor().colorPrint(ErrorColor().RED,"ERROR:")
        ErrorColor().colorPrint(ErrorColor().RESET," invalid")
        ErrorColor().colorPrint(ErrorColor().RESET," map")
        ErrorColor().colorPrint(ErrorColor().RESET," (")
        ErrorColor().colorPrint(ErrorColor().CYAN,"->")
        ErrorColor().colorPrint(ErrorColor().RESET,")")
        ErrorColor().colorPrintln(ErrorColor().RESET," operation:")
        if (query is Query.Arrow){
            ErrorColor().colorPrintln(ErrorColor().CYAN,"│")
            ErrorColor().colorPrint(ErrorColor().CYAN,"╰─>")
            ErrorColor().colorPrintln(ErrorColor().RESET,"\t${query.toString()}")
            val digits  = query.query.length
            ErrorColor().colorPrintln(ErrorColor().RED,"\t"+ " ".repeat(query.toString().length -2 -digits) + "^".repeat(digits+2))
            ErrorColor().colorPrintln(ErrorColor().YELLOW,"// map operation on tags should be:")
            ErrorColor().colorPrintln(ErrorColor().YELLOW,"// ${query.toString().reversed().replaceFirst(">-",".").reversed()}")
        }
        exitProcess(1)
    }

    fun illegalMapOperation(query: Query){
        ErrorColor().colorPrint(ErrorColor().RED,"ERROR:")
        ErrorColor().colorPrint(ErrorColor().RESET," illegal")
        ErrorColor().colorPrint(ErrorColor().RESET," map")
        ErrorColor().colorPrint(ErrorColor().RESET," (")
        ErrorColor().colorPrint(ErrorColor().CYAN,"->")
        ErrorColor().colorPrint(ErrorColor().RESET,")")
        ErrorColor().colorPrintln(ErrorColor().RESET," operation")
        if (query is Query.Arrow){
            ErrorColor().colorPrintln(ErrorColor().CYAN,"│")
            ErrorColor().colorPrint(ErrorColor().CYAN,"╰─>")
            ErrorColor().colorPrintln(ErrorColor().RESET,"\t${query.toString()}")
            val digits  = query.query.length
            ErrorColor().colorPrintln(ErrorColor().RED,"\t"+ " ".repeat(query.toString().length -2 -digits) + "^".repeat(digits+2))
            ErrorColor().colorPrintln(ErrorColor().YELLOW,"// map operation should be used on lists of tags")
        }
        exitProcess(1)
    }

    fun illegalCountOperation(query: Query){
        ErrorColor().colorPrint(ErrorColor().RED,"ERROR:")
        ErrorColor().colorPrint(ErrorColor().RESET," illegal")
        ErrorColor().colorPrint(ErrorColor().RESET," count")
        ErrorColor().colorPrint(ErrorColor().RESET," (")
        ErrorColor().colorPrint(ErrorColor().CYAN,"#")
        ErrorColor().colorPrint(ErrorColor().RESET,")")
        ErrorColor().colorPrintln(ErrorColor().RESET," operation")
        if (query is Query.Count){
            ErrorColor().colorPrintln(ErrorColor().CYAN,"│")
            ErrorColor().colorPrint(ErrorColor().CYAN,"╰─>")
            ErrorColor().colorPrintln(ErrorColor().RESET,"\t${query.toString()}")
            val digits  = 1
            ErrorColor().colorPrintln(ErrorColor().RED,"\t"+ " ".repeat(query.toString().length -digits) + "^".repeat(digits))
            ErrorColor().colorPrintln(ErrorColor().YELLOW,"// count operation should be used on lists/entities")
        }
        exitProcess(1)
    }

}
