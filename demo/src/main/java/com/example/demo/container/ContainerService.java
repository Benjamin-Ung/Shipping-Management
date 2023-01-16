package com.example.demo.container;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ContainerService {

    private final ContainerRepository containerRepository;

    @Autowired
    public ContainerService(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    public List<Container> getContainers(){
        return containerRepository.findAll();
    }

    public void addNewContainer(Container container) {
        Optional<Container> containerOptional =
                containerRepository.findContainerByEmail(container.getEmail());
        if( containerOptional.isPresent() ){
            throw new IllegalStateException("email taken");
        }
        containerRepository.save(container);
        System.out.println(container);
    }

    public void deleteContainer(Long containerId){
        boolean exists = containerRepository.existsById(containerId);
            if(!exists){
                throw new IllegalStateException("Container with the id of " + containerId + " does not exist");
            }
            containerRepository.deleteById(containerId);
    }

    @Transactional
    public void updateContainer(Long containerId,
                              String name,
                              String email){
        Container container = containerRepository.findById(containerId)
                .orElseThrow(() -> new IllegalStateException(
                        "Container with id " + containerId + " does not exist"));

        if(name != null
                && name.length() > 0
                && !Objects.equals(container.getVendor(), name)){
            container.setVendor(name);
        }

        if(email != null
                && email.length() > 0
                && !Objects.equals(container.getEmail(), email)){

            Optional<Container> containerOptional = containerRepository
                    .findContainerByEmail((email));
            if(containerOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }

            container.setEmail(email);
        }
    }
}
