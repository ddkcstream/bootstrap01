package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DemoController {


    //初期化
    @RequestMapping(value = "/")
    public String login(Model model) {
        UserDao user =new UserDao();
        model.addAttribute("user", user);
        return "login";
    }

    //登录
    @RequestMapping(value = "/login", params = "action=login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "userName") String userName,
                        @RequestParam(value = "userPsw") String userPsw, Model model, RedirectAttributes redirectAttributes) {
        if (userName.equals(userPsw)) {
            redirectAttributes.addFlashAttribute("userName", userName);
            redirectAttributes.addFlashAttribute("userPsw", userPsw);
            return "redirect:index";
        } else {
            model.addAttribute("loginError", true);
            return "login";
        }
    }

    //進入頁面
    @RequestMapping("/index")
    public void welcomeIndex(@ModelAttribute("userName") String userName, Model model) {
        model.addAttribute("userName", userName);
    }
}
