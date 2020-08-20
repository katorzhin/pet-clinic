package com.katorzhin.spring.petclinic.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"cat","default"})
@Service
public class CatPetService implements PetService{
    @Override
    public String getPetType() {
        return "Cats - are the best !";
    }
}
