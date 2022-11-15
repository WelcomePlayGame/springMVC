package ua.vadym.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname) {
        System.out.println("Your name "+name);
        System.out.println("Your surname "+surname);
        return "first/hello";
    }
    @GetMapping("/bye")
    public String beyPage() {
        return "first/bye";
    }
}
