package com.example.demo.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/container")
public class ContainerController {
    private final ContainerService containerService;
    @Autowired
    public ContainerController(ContainerService containerService){
        this.containerService = containerService;
    }

    @GetMapping
    public List<Container> getContainers(){
        return containerService.getContainers();
    }

    @PostMapping
    public void registerNewContainer(@RequestBody Container container){
        containerService.addNewContainer(container);
    }

    @DeleteMapping(path = "{containerId}")
    public void deleteContainer(@PathVariable("containerId") Long containerId){
        containerService.deleteContainer(containerId);
    }

    @PutMapping(path = "{containerId}")
    public void updateContainer(
            @PathVariable("containerId") Long containerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        containerService.updateContainer(containerId,name,email);
    }
}
