package com.spring_book_app.Spring_book_app.AOP;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("execution (* com.spring_book_app.Spring_book_app.model.BookService.*(..))")
    public Object performanceMonitor (ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();

        Object obj = jp.proceed();

        long end = System.currentTimeMillis();
        LOGGER.info("Time for execution = "+jp.getSignature().getName()+" : "+ (end - start) +" milliseconds");

        return obj;
    }

}
