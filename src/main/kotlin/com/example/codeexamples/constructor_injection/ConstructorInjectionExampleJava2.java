package com.example.codeexamples.constructor_injection;

import com.example.codeexamples.beans.SomeDependency;
import org.springframework.stereotype.Component;

@Component
public class ConstructorInjectionExampleJava2 {
    private final SomeDependency someDependency;

    public ConstructorInjectionExampleJava2(SomeDependency someDependency) {
        this.someDependency = someDependency;
        System.out.println("Constructed" + this.someDependency);
    }
}
