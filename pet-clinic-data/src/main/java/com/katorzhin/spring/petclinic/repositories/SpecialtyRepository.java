package com.katorzhin.spring.petclinic.repositories;

import com.katorzhin.spring.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository <Speciality,Long> {
}
