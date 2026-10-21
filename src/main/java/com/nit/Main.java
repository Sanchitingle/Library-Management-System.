package com.nit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        // Start Spring Container

        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        BookConfiguration.class);

        // Get BookDao bean

        BookDao bean =
                context.getBean("book", BookDao.class);

        // Operation 1

        System.out.println(
                "Total number of books:");

        System.out.println(
                bean.getNumberOfBooks());

        System.out.println(
                "------------------------------");

        // Operation 2

        System.out.println(
                "Book name based on ID:");

        String bookNameById =
                bean.getBookNameById(102);

        System.out.println(
                "Book name: " + bookNameById);

        System.out.println(
                "------------------------------");

        // Operation 3

        System.out.println(
                "Complete book details based on ID:");

        System.out.println(
                bean.getAllBookById(103));
    }
}
