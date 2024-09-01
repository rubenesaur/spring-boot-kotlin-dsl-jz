package com.example.codeexamples.bean_definition.kotlindsl

import com.example.codeexamples.beans.SomeBeanWithDependency
import com.example.codeexamples.beans.SomeDependency
import com.example.codeexamples.sample_kt_java.KotlinSampleApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.beans

fun main(args: Array<String>) {
    runApplication<KotlinSampleApplication>(*args) {
        addInitializers(initBeans())
    }
}

fun initBeans() = beans {
    bean<SomeDependency>()
    bean<SomeBeanWithDependency>()
}
