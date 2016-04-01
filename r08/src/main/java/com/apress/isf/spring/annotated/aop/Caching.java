package com.apress.isf.spring.annotated.aop;

import com.apress.isf.java.model.Type;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nishi on 2016-04-01.
 */
@Component
@Aspect
public class Caching{
    private static final Logger log = LoggerFactory.getLogger(Caching.class);
    private static final Map<String, Object> cache = new HashMap<String, Object>();

    @Around("execution(* com.apress.isf.java.service.SearchEngine.*(..))")
    public Object caching(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        Type documentType = null;

        log.debug("@@@@(Buforowanie) sprawdza, czy to wywołanie można buforować...");

        if("findByType".equals(pjp.getSignature().getName()) &&
                pjp.getArgs().length == 1 &&
                    pjp.getArgs()[0] instanceof Type) {
            documentType = (Type)pjp.getArgs()[0];
            log.debug("@@@@(Buforowanie) Można buforować!!");
            if(cache.containsKey(documentType.getName())) {
                log.debug("@@@@(Buforowanie) Znaleziono w buforze!");
                return cache.get(documentType.getName());
            }
            log.debug("@@@@(Buforowanie) Nie znaleziono! Ale można buforować!");
            result = pjp.proceed();
            cache.put(documentType.getName(), result);
            return result;
        }

        return pjp.proceed();
    }
}
