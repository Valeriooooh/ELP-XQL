package org.example

data class Attribute(val name: String, val value: String)

interface Content;

data class Text(val text: String): Content;

data class Tag(val ident: String, val atributes: List<Attribute>, val inner: List<Content>):Content{

}

data class XML(val tag: List<Tag>){

}
