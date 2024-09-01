package com.example.performance

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.runApplication

@EnableAutoConfiguration
class PerformanceApplicationNotScanning

fun main(args: Array<String>) {
    runApplication<PerformanceApplicationNotScanning>(*args)
}