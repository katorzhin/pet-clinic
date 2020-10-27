package com.katorzhin.spring.petclinic.repositories;

import com.katorzhin.spring.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
