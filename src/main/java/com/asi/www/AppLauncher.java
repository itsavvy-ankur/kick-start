package com.asi.www;

import org.apache.camel.spring.boot.FatJarRouter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by Ankur on 17-12-2016.
 */
@SpringBootApplication
public class AppLauncher extends FatJarRouter{

public static void main(String... args){
    SpringApplication.run(AppLauncher.class,args);
}
}
