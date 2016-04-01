package com.apress.isf.spring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by nishi on 2016-04-01.
 */
public class ThrowsLoggingModule implements ThrowsAdvice {
    private static final Logger log = LoggerFactory.getLogger(ThrowsLoggingModule.class);

    public void afterThrowing(Method m, Object[] args, Object target, Exception ex) {
        if(log.isDebugEnabled())
            log.debug("@@@@(THROWS) Wywołana metoda: " + m.getName());
        if(args.length == 0)
            log.debug("@@@@(THROWS) Nie przekazano argumentów.");
        for(Object arg: args)
            log.debug("@@@@(THROWS) Przekazany argument: " + arg);
        log.debug("@@@@(THROWS) Błąd: " + ex.getMessage());
    }
}
