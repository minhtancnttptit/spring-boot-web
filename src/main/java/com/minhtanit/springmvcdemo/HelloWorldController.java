package com.minhtanit.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/home")
public class HelloWorldController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @GetMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @GetMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        String name = request.getParameter("studentName");
        name = name.toUpperCase();
        String result = "Yo! " + name;
        model.addAttribute("message", result);
        return "helloworld";
    }


    @GetMapping("/processFormVersionThree")
    public String prcessFormVersionThree(@RequestParam("studentName") String theName, Model model) {
        theName = theName.toUpperCase();
        String result = "Hey my friend from v3 " + theName;
        model.addAttribute("message", result);
        return "helloworld";
    }
}
