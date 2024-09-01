package com.example.codeexamples.bean_definition.kotlindsl

import com.example.codeexamples.beans.SomeBeanWithDependency
import com.example.codeexamples.beans.SomeDependency
import org.springframework.boot.runApplication
import org.springframework.context.support.beans

fun main(args: Array<String>) {
    runApplication<KotlinSampleApplication>(*args) {
        addInitializers(beans {
            bean<SomeDependency>()
            bean<SomeBeanWithDependency>()
        })
    }
}
