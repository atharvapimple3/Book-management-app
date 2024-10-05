package com.spring_book_app.Spring_book_app.AOP;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution (* com.spring_book_app.Spring_book_app.model.BookService.getBook(..)) && args(bookID)")
    public Object checkAndUpdate(ProceedingJoinPoint jp, int bookID) throws Throwable {

        if (bookID < 0)
        {
            LOGGER.info("BookId is negative, Updating it");
            bookID = -bookID;
            LOGGER.info("Updated BookID is = "+bookID);
        }
        Object object = jp.proceed(new Object [] {bookID});

        return object;
    }
}
