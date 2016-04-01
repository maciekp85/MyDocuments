package com.apress.isf.spring.aop;

import com.apress.isf.java.model.Type;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nishi on 2016-04-01.
 */
public class CachingModule implements MethodInterceptor {
    private static final Logger log = LoggerFactory.getLogger(CachingModule.class);
    private static final Map<String, Object> cache = new HashMap<String, Object>();

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result = null;
        Type documentType = null;

        log.debug("@@@@(Buforowanie) sprawdza, czy to wywołanie można buforować...");

        if("findByType".equals(invocation.getMethod().getName()) &&
                invocation.getArguments().length == 1 &&
                    invocation.getArguments()[0] instanceof Type) {
            documentType = (Type)invocation.getArguments()[0];
            log.debug("@@@@(Buforowanie) Można buforować!!");
            if(cache.containsKey(documentType.getName())) {
                log.debug("@@@@(Buforowanie) Znaleziono w buforze!");
                return cache.get(documentType.getName());
            }
            log.debug("@@@@(Buforowanie) Nie znaleziono! Ale można buforować!");
            result = invocation.proceed();
            cache.put(documentType.getName(), result);
            return result;
        }

        return invocation.proceed();
    }
}
