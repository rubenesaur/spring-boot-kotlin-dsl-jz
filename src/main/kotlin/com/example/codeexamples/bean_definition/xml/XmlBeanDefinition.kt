package com.example.codeexamples.bean_definition.xml

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ImportResource

@SpringBootApplication
@ImportResource("classpath:beans.xml")
class KotlinSampleXMLApplication

fun main(args: Array<String>) {
    runApplication<KotlinSampleXMLApplication>(*args)
}
