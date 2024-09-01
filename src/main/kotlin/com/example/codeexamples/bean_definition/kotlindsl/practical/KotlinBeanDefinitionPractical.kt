package com.example.codeexamples.bean_definition.kotlindsl.practical

import com.example.codeexamples.bean_definition.kotlindsl.KotlinSampleApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.beans
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.router

fun main(args: Array<String>) {
    runApplication<KotlinSampleApplication>(*args) {
        addInitializers(
            initCustomAppBeans(requiresAuthentication = true, AppType.BOTH),
            beans {
                bean<MyService>()
                bean {
                    router {
                        GET("/my-practical-example") {
                            ServerResponse.ok().body(ref<MyService>().getIds())
                        }
                    }
                }
            }
        )
    }
}

class MyService(
    private val customerContext: CustomerContext,
    private val officeContext: OfficeContext
) {
    fun getIds(): String {
        return "${customerContext.customerId} , ${officeContext.officeId}"
    }
}