package com.wyh.aop;


import com.wyh.domain.Book;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookControllerAdvice {
    @Around("ptOnSave()")
    public boolean aroundSave(ProceedingJoinPoint Pjp) throws Throwable {
//        System.out.println("表单校验...");
        Object[] args = Pjp.getArgs();
        Book book = (Book) args[0];
        if (book.getName() == null || book.getType() == null) {
            return false;
        } else {
            Pjp.proceed(args);
            return true;
        }
    }

    @Pointcut("execution(boolean com.wyh.service.BookService.addNew(..))")
    public void ptOnSave() {}
}
