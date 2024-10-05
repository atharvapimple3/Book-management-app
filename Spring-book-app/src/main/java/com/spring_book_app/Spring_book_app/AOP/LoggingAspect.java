package com.spring_book_app.Spring_book_app.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //syntax for before execution
    //return type,fully qualified class name, method name,arguments;
   // @Before("execution(void com.spring_book_app.Spring_book_app.model.BookService.java.deleteBook(int bookID) ) ")
    @Before("execution(* com.spring_book_app.Spring_book_app.model.BookService.getBook(..)) execution (* com.spring_book_app.Spring_book_app.model.BookService.getAllBooks(..)) ")
    public void logMethodCalled(JoinPoint jp)
    {
        LOGGER.info("Method called "+ jp.getSignature().getName());
    }

   @After("execution (* com.spring_book_app.Spring_book_app.model.BookService.getBook(..)) || execution (* com.spring_book_app.Spring_book_app.model.BookService.getAllBooks(..))")
    public void logMethodSuccess(JoinPoint jp)
    {
        LOGGER.info("Method returned " + jp.getSignature().getName());
    }

}
