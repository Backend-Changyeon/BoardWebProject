package BoardWeb.controller;

import BoardWeb.domain.User;
import BoardWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    //로그인 (get)
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login(){
        return "login";
    }

    //로그인 (post)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Login(User user) throws Exception {
        if(userService.Login(user)) {
            return "redirect:/board";
        }
        else
            return "login";
    }

    //로그아웃
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String Logout () {
        userService.Logout();
        return "redirect:/login";
    }

    //회원가입 (get)
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String Signup(){
        return "signup";
    }

    //회원가입 (post)
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String Signup(User user) throws Exception {
        if(userService.insertUser(user))
        {
            return "redirect:/login";
        }
        else return "redirect:/signup";
    }
}