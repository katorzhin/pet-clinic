package com.katorzhin.spring.petclinic.repositories;

import com.katorzhin.spring.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
