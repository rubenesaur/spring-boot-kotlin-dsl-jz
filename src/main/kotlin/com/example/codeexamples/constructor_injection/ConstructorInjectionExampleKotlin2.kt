package com.example.codeexamples.constructor_injection

import com.example.codeexamples.beans.SomeDependency
import org.springframework.stereotype.Component

@Component
class ConstructorInjectionExampleKotlin2(
    private val someDependency: SomeDependency
) {
    init {
        println("Constructed with $someDependency")
    }
}
