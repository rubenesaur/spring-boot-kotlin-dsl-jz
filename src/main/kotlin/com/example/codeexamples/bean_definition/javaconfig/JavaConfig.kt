package com.example.codeexamples.bean_definition.javaconfig

import com.example.codeexamples.beans.SomeBeanWithDependency
import com.example.codeexamples.beans.SomeDependency
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JavaConfig {

    @Bean
    fun someDependency() = SomeDependency()

    @Bean
    fun someBeanWithDependency(someDependency: SomeDependency) = SomeBeanWithDependency(someDependency)
}
