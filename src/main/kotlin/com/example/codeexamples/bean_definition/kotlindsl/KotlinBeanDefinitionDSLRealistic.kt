package com.example.codeexamples.bean_definition.kotlindsl

import com.example.codeexamples.beans.SomeBeanWithDependency
import com.example.codeexamples.beans.SomeDependency
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans

fun main(args: Array<String>) {
    runApplication<KotlinSampleApplication>(*args)
}

fun someBeans() = beans {
    bean<SomeDependency>()
    bean<SomeBeanWithDependency>()
}

class BeansInitializer: ApplicationContextInitializer<GenericApplicationContext> {
    override fun initialize(applicationContext: GenericApplicationContext) {
        someBeans().initialize(applicationContext)
    }
}
