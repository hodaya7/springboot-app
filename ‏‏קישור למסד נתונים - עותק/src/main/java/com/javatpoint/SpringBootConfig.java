package com.javatpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//מכאן מתחילים להריץ את האפליקציה
//מסד הנתונים נטען לבד
@SpringBootApplication
public class SpringBootConfig
{
public static void main(String[] args) throws Exception 
{
SpringApplication.run(SpringBootConfig.class, args);
}
}
