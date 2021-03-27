package com.upgrad.course.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Inventory Api to handle stocks
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.upgrad.course.demo"})
public class InventoryApiMain
{
    public static void main( String[] args )
    {
        SpringApplication.run(InventoryApiMain.class, args);
    }
}
