package com.apress.isf.spring.service;

import com.apress.isf.java.service.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nishi on 2016-04-18.
 */
public class SecurityServiceFacade {
    private Logger log = LoggerFactory.getLogger(SecurityServiceFacade.class);

    private Login login;

    public void setLogin(Login login) {
        this.login = login;
    }

    public boolean areCredentialsValid(String email, String pass) {
        log.debug("Sprawdzanie poświadczeń > email: " + email + " , hasło: " + pass);
        return this.login.isAuthorized(email, pass);
    }
}
