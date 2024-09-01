package com.example.codeexamples.beans

class SomeBeanWithOtherDependency(
    val someOtherDependency: SomeDependency
) {
    init {
        println("Constructed bean with dependency: $someOtherDependency")
    }
}