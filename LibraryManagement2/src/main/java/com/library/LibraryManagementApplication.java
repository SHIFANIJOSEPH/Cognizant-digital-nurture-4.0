package com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import com.library.service.BookService;

public class LibraryManagementApplication {
	    public static void main(String[] args) {
	        
	        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	       
	        BookService bookService = (BookService) context.getBean("bookService");

	        
	        bookService.addBook("Effective Java by Joshua Bloch");
	    }
	
}
