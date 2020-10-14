package com.katorzhin.spring.petclinic.bootstrap;

import com.katorzhin.spring.petclinic.model.Owner;
import com.katorzhin.spring.petclinic.model.Pet;
import com.katorzhin.spring.petclinic.model.PetType;
import com.katorzhin.spring.petclinic.model.Vet;
import com.katorzhin.spring.petclinic.services.OwnerService;
import com.katorzhin.spring.petclinic.services.PetTypeService;
import com.katorzhin.spring.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Libi");
        PetType savedDogPetType= petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Busya");
        PetType savedCatPetType= petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Alex");
        owner1.setLastName("Katorzhin");
        owner1.setAddress("251 Binks");
        owner1.setCity("Kharkiv");
        owner1.setTelephone("+380638029750");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Masya");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Denis");
        owner2.setLastName("Karalev");
        owner2.setAddress("221 Binks");
        owner2.setCity("Kharkiv");
        owner2.setTelephone("+380638029751");

        Pet fionaCat = new Pet();
        fionaCat.setName("Dusa");
        fionaCat.setOwner(owner2);
        fionaCat.setBirthDate(LocalDate.now());
        fionaCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionaCat);

        ownerService.save(owner2);

        System.out.println("Loaded owners : .....");

        Vet vet1 = new Vet();
        vet1.setFirstName("John");
        vet1.setLastName("Bruklin");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Gen");
        vet2.setLastName("Drilis");
        vetService.save(vet2);
    }

}
