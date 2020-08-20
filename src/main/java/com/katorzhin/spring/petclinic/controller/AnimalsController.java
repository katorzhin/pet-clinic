package com.katorzhin.spring.petclinic.controller;

import com.katorzhin.spring.petclinic.service.PetService;
import org.springframework.stereotype.Controller;

@Controller
public class AnimalsController {
    private final PetService petService;

    public AnimalsController(PetService petService) {
        this.petService = petService;
    }

    public String sayAnything(){
        return petService.getPetType();
    }
}
