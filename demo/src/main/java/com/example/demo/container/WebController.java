package com.example.demo.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WebController {
    //It works. 8080/____ instead of /api/___
    private final ContainerService containerService;

    @Autowired
    public WebController(ContainerService containerService){
        this.containerService = containerService;
    }
    @GetMapping(value = "/")
    public String getList(Model model){
        List<Container> list = containerService.getContainers();
        model.addAttribute("list", list);
        return "index";
    }

    @GetMapping(value = "/addContainer")
    public String sendForm(Model model) {
        Container container = new Container();
        model.addAttribute("container", container);
        return "addContainer";
    }

    @GetMapping(value = "/deleteContainer")
    public String deleteForm(Model model) {
//        Long id = -5L;
//        model.addAttribute("id", id);
        return "deleteContainer";
    }

    @PostMapping(value = "/addContainer")
    public String processForm(Container container) {
       containerService.addNewContainer(container);
        return "results";
    }
    @PostMapping(value = "/deleteContainer")
    public String delete(Long id) {
        containerService.deleteContainer(id);
        return "index";
    }
}
