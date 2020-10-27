package com.katorzhin.spring.petclinic.repositories;

import com.katorzhin.spring.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
