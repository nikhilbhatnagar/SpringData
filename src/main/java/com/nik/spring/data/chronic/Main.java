package com.nik.spring.data.chronic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * hadoop fs -rm -r spark_output
 * hadoop fs -rm -r spark_output/*
 * 
 * hadoop fs -cat spark_output/part-r-00000
 * */
public class Main {
    public static void main(String[] arguments) {
        @SuppressWarnings("unused")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-avg.xml");
    }
}