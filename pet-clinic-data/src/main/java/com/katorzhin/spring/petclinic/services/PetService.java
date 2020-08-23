package com.katorzhin.spring.petclinic.services;

import com.katorzhin.spring.petclinic.model.Owner;
import com.katorzhin.spring.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet owner);

    Set<Pet> findAll();
}
