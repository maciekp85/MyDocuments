import com.apress.isf.java.service.Login

/**
 * Created by nishi on 2016-04-18.
 */
class GroovyLoginService implements Login {

    String username
    String password

    boolean isAuthorized(String email, String pass) {
        if(username.equals(email) && password.equals(pass))
            return true
        return false
    }
}