package prof.leu.shiro1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MiscController {
    @ResponseBody
    @RequestMapping("un_auth")
    public  String un_auth() {

        return "un_auth" ;
    }
}
