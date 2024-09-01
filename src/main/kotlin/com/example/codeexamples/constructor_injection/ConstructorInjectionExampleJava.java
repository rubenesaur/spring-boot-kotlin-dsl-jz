package com.example.codeexamples.constructor_injection;

import com.example.codeexamples.beans.SomeDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructorInjectionExampleJava {
    private final SomeDependency someDependency;

    @Autowired
    public ConstructorInjectionExampleJava(SomeDependency someDependency) {
        this.someDependency = someDependency;
        System.out.println("Constructed with " + this.someDependency);
    }
}

