package com.katorzhin.spring.petclinic.services;

import com.katorzhin.spring.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);



}
