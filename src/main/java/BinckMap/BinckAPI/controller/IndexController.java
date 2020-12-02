package BinckMap.BinckAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/homepage")
    public String homepage(HttpServletRequest request){
        return "homepage";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        return "logout";
    }

    @GetMapping("/userinput")
    public String userinput(HttpServletRequest request){
        return "userinput";
    }

}