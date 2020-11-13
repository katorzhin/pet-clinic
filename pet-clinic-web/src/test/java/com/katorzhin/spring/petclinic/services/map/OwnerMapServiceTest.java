package com.katorzhin.spring.petclinic.services.map;

import com.katorzhin.spring.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastName = "Katorzhin";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().lastName(lastName).id(ownerId).build());
    }

    @Test
    void findALL() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner saveOwner = ownerMapService.save(owner2);
        assertEquals(id, saveOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());

    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findALL().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findALL().size());
    }

    @Test
    void findByLastName() {
        Owner katorzhin = ownerMapService.findByLastName(lastName);
        assertNotNull(katorzhin);
        assertEquals(ownerId,katorzhin.getId());
    }
    @Test
    void findByLastNameNotFound() {
        Owner katorzhin = ownerMapService.findByLastName("foo");
       assertNull(katorzhin);

    }
}