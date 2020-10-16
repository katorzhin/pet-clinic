package com.katorzhin.spring.petclinic.bootstrap;

import com.katorzhin.spring.petclinic.model.*;
import com.katorzhin.spring.petclinic.services.OwnerService;
import com.katorzhin.spring.petclinic.services.PetTypeService;
import com.katorzhin.spring.petclinic.services.SpecialitiesService;
import com.katorzhin.spring.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesService specialitiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findALL().size();
        if (count==0){
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Libi");
        PetType savedDogPetType= petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Busya");
        PetType savedCatPetType= petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialitiesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialitiesService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialitiesService.save(dentistry);

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
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Gen");
        vet2.setLastName("Drilis");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);
    }

}
