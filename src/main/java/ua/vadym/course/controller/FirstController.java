package ua.vadym.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hello")
    public String helloPage() {
        return "first/hello";
    }
    @GetMapping("/bye")
    public String beyPage() {
        return "first/bye";
    }
}
