package org.example

interface Content;

interface Queryable{
    fun find(query: String): XMLItem?

    fun count(query: String): Int
}
sealed class XMLItem{
    data class Attribute(val name: String, val value: String): XMLItem()

    data class Text(val text: String): Content, XMLItem();


    data class Tag(val ident: String, val attributes: List<Attribute>, val inner: List<Content>):Content,Queryable,XMLItem(){
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

                }
            }
            return ResultList(tt);
        }

        override fun count(query: String): Int {
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

        override fun count(query: String): Int {
            return 0
        }
    }

    data class ResultList(val items: List<XMLItem>): Queryable,XMLItem(){
        override fun find(query: String): XMLItem?{
            return null
        }

        override fun count(query: String): Int {
            return 0
        }
    }
}

