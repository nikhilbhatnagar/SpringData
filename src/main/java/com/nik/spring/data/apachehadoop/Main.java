package com.nik.spring.data.apachehadoop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * hadoop fs -rm -r spark_output
 * hadoop fs -rm -r spark_output/*
 * */
public class Main {
    public static void main(String[] arguments) {
        @SuppressWarnings("unused")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-wordcount.xml");
    }
}