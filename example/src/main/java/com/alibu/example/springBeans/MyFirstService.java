/*
package com.alibu.example.springBeans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom.properties")
public class MyFirstService {


    private final MyFirstClass myFirstClass;

    @Value("${my.prop}")
    private String customProperty;
    @Value("${my.custom.property}")
    private String profileProperty;


    // Constructor injection always recommended
    public MyFirstService(
           @Qualifier("myFirstBean") MyFirstClass myFirstClass
    ) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory(){
        return " the dependency is saying " + myFirstClass.sayHello();
    }

    public String getCustomProperty() {
        return customProperty;
    }

    public String getProfileProperty() {
        return profileProperty;
    }
}
*/
