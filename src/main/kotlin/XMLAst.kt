package org.example

interface Content;

interface Queryable{
    fun find(query: String)

    fun count(query: String): Int
}
sealed class XMLItem{
    data class Attribute(val name: String, val value: String): XMLItem()

    data class Text(val text: String): Content, XMLItem();


    data class Tag(val ident: String, val attributes: List<Attribute>, val inner: List<Content>):Content,Queryable,XMLItem(){
        override fun find(query: String){

        }

        override fun count(query: String): Int {
            return 0
        }
    }


    data class XML(val tag: List<Tag>): Queryable, XMLItem(){
        override fun find(query: String){

        }

        override fun count(query: String): Int {
            return 0
        }
    }
}

