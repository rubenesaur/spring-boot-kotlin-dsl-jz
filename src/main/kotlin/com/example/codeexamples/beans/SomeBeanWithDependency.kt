package com.example.codeexamples.beans

class SomeBeanWithDependency(
    val someDependency: SomeDependency
){
    init {
        println("Constructed bean with dependency: $someDependency")
    }
}