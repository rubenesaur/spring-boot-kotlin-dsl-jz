package com.example.codeexamples.bean_definition.javaconfig

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSampleJavaConfigApplication

fun main(args: Array<String>) {
    runApplication<KotlinSampleJavaConfigApplication>(*args)
}

