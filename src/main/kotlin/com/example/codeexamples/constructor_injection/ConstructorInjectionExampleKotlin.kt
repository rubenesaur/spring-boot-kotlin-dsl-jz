package com.example.codeexamples.constructor_injection

import com.example.codeexamples.beans.SomeDependency
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ConstructorInjectionExampleKotlin @Autowired constructor(
    private val someDependency: SomeDependency
) {
    init {
        println("Constructed with $someDependency")
    }
}
