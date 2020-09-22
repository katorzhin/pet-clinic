package com.katorzhin.spring.petclinic.bootstrap;

import com.katorzhin.spring.petclinic.model.Owner;
import com.katorzhin.spring.petclinic.model.Vet;
import com.katorzhin.spring.petclinic.services.OwnerService;
import com.katorzhin.spring.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Alex");
        owner1.setLastName("Katorzhin");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(1L);
        owner2.setFirstName("Denis");
        owner2.setLastName("Karalev");
        ownerService.save(owner2);

        System.out.println("Loaded owners : .....");

        Vet vet1 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("John");
        vet1.setLastName("Bruklin");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Gen");
        vet2.setLastName("Drilis");
        vetService.save(vet2);
    }

}
