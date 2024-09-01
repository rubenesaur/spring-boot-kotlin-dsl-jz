package com.example.codeexamples.bean_definition.kotlindsl

import org.springframework.boot.runApplication
import org.springframework.context.support.beans
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.router

fun main(args: Array<String>) {
    runApplication<KotlinSampleApplication>(*args){
        addInitializers(beans {
            bean {
                router {
                    GET("/my-router-function") {
                        ServerResponse.ok().body("Yo world")
                    }
                }
            }
        })
    }
}
