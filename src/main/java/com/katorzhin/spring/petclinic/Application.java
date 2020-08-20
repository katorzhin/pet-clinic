package com.katorzhin.spring.petclinic;

import com.katorzhin.spring.petclinic.controller.*;
import com.katorzhin.spring.petclinic.service.GreetingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class);

        AnimalsController animalsController = (AnimalsController)context.getBean("animalsController");
        System.out.println(animalsController.sayAnything());

        I18nController i18nController = (I18nController)context.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        MyController myController = (MyController) context.getBean("myController");


        System.out.println("----------Primary Bean");
        System.out.println(myController.sayHello());



        System.out.println("---------- Property");
        PropertyInjectController propertyInjectController = (PropertyInjectController) context.getBean("propertyInjectController");
        System.out.println(propertyInjectController.getGreeting());

        System.out.println("----------Setter");
        SetterInjectController setterInjectController = (SetterInjectController)context.getBean("setterInjectController");
        System.out.println(setterInjectController.getGreeting());

        System.out.println("-------Constructor");
        ConstructorInjectController constructorInjectController = (ConstructorInjectController)context.getBean("constructorInjectController");
        System.out.println(constructorInjectController.getGreeting());
    }
}
