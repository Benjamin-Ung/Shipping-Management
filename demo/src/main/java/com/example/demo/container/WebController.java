package com.example.demo.container;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    //It works. 8080/____ instead of /api/vi/container/___
    @GetMapping(path = "/addContainer")
    public String sendForm(Model model) {
        Container container = new Container();
        model.addAttribute("container", container);
        return "index";
    }
}
