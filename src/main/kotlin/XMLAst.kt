package org.example

import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*


interface Queryable{
    fun find(query: String): XMLItem?

    fun count(): Int
}
sealed class XMLItem{
    data class Attribute(val name: String, val value: String): XMLItem()

    data class Text(val text: String): XMLItem();


    data class Tag(val ident: String, val attributes: List<Attribute>, val inner: List<XMLItem>):Queryable,XMLItem(){
        override fun find(query: String): XMLItem?{
            for( i in attributes){
                if(i.name == query){
                    return Text(i.value)
                }
            }
            val tt: MutableList<Tag> = mutableListOf()
            for( i in inner){
                when(i){
                    is Tag -> {
                        if(i.ident == query){
                            tt.add(i)
                        }
                    }
                    else -> {}

                }
            }
            if(tt.size == 1){
                return tt[0].inner.first()
            }
            return ResultList(tt);
        }

        override fun count(): Int {
            return 0
        }
    }


    data class XML(val tag: List<Tag>): Queryable, XMLItem(){
        override fun find(query: String): XMLItem?{
           for (i in tag){
               println(i.ident)
               if(i.ident == query){
                   return i
               }
           }
            return null
        }

        override fun count(): Int {
            return 0
        }
    }

    data class ResultList(val items: List<XMLItem>): Queryable,XMLItem(){
        override fun find(query: String): XMLItem?{
            return null
        }

        override fun count(): Int {
            return items.size
        }
        fun get(index: Int):XMLItem?{
            return try {
                this.items[index];
            }catch (e: Exception){
                null
            }

        }
        fun sum(): XMLItem?{
            val isString: MutableList<Boolean> = mutableListOf()
            val numberFormat = NumberFormat.getNumberInstance(Locale.ENGLISH) as DecimalFormat
            for (i in items){
                try {
                    when(i){
                        is Text -> {
                            numberFormat.parse(i.text)
                            isString.add(false)
                        }
                        else -> return null
                    }
                }catch (e: Exception){
                    isString.add(true)
                }
            }
            val _isString = isString.distinct()
            if(_isString.size > 1 || _isString[0] == true){
                var teste = ""
                for (i in items)
                    when(i){
                        is Text -> teste + i.text
                        else -> teste + ""
                    }

                return Text(teste)
            }else{
                var sum= 0;
                for(i in items){
                    when(i){
                        is Text -> sum += (numberFormat.parse(i.text)).toInt()
                        else -> {}
                    }
                }
                return Text(""+sum)
            }
        }

        fun map(query: String): XMLItem?{
            val tt: MutableList<XMLItem> = mutableListOf()
            for( i in items){
                when(i){
                    is Tag -> {
                        for( j in i.attributes){
                            if(j.name == query){
                                tt.add(Text(j.value))
                            }
                        }
                        for (j in i.inner){
                            when(j){
                                is Tag -> {
                                    if(j.ident == query){
                                        tt.add(j.inner[0])
                                    }
                                }
                                else -> {}
                            }
                        }
                    }
                    else -> {}
                }
            }
            return ResultList(tt)
        }
    }
}

