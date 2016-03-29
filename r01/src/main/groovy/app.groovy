import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by nishi on 2016-03-29.
 */

@Controller
class MyApp {

    @RequestMapping("/")
    @ResponseBody
    String message() {
        return "<h1>Witaj, świecie</h1>"
    }

}