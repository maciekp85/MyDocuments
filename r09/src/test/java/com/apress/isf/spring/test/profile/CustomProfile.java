package com.apress.isf.spring.test.profile;

import org.springframework.test.annotation.ProfileValueSource;

/**
 * Created by nishi on 2016-03-31.
 */
public class CustomProfile implements ProfileValueSource {

    public String get(String key) {
        if(key.equals("environment"))
            return "dev";
        else if(key.equals("os.name"))
            return "Unix";
        return null;
    }
}
