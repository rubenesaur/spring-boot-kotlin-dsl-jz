package com.example.codeexamples.bean_definition.kotlindsl

import org.springframework.boot.runApplication
import org.springframework.context.support.beans
import org.springframework.http.MediaType
import org.springframework.web.servlet.function.RouterFunctionDsl
import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.router

fun main(args: Array<String>) {
    runApplication<KotlinSampleApplication>(*args){
        addInitializers(beans {
            bean {
                router {
                    sb1GET("/my-router-function") {
                        ServerResponse.ok().body("Yo world")
                    }
                }
            }
        })
    }
}

fun RouterFunctionDsl.sb1GET(
    pattern: String,
    version: Int = 1,
    f: (ServerRequest) -> ServerResponse
){
    accept(MediaType.parseMediaType("application/json+$version")).nest {
        GET(pattern, f)
    }
}
