package com.katorzhin.spring.petclinic.repositories;

import com.katorzhin.spring.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
