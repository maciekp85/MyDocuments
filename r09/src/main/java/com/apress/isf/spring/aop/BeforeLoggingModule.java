package com.apress.isf.spring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by nishi on 2016-04-01.
 */
public class BeforeLoggingModule implements MethodBeforeAdvice {
    private static final Logger log = LoggerFactory.getLogger(BeforeLoggingModule.class);

    public void before(Method method, Object[] args, Object target) throws Throwable {
        if(log.isDebugEnabled()) {
            log.debug("@@@@(BEFORE) Wywołana metoda: " + method.getName());
            if(args.length == 0)
                log.debug("@@@@(BEFORE) Nie przekazano argumentów.");
            for(Object arg: args)
                log.debug("@@@@(BEFORE) Przekazany argument: " + arg);
        }
    }

}
