package com.katorzhin.spring.petclinic.controllers;

import com.katorzhin.spring.petclinic.model.Owner;
import com.katorzhin.spring.petclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController controller;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1l).build());
        owners.add(Owner.builder().id(2l).build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

//    @Test
//    void listOwners() throws Exception {
//        when(ownerService.findALL()).thenReturn(owners);
//
//        mockMvc.perform(get("/owners"))
//                .andExpect(view().name("owners/index"))
//                .andExpect(model().attribute("owners", hasSize(2)));
//    }

    @Test
    void listOwnersByIndex() throws Exception {
        when(ownerService.findALL()).thenReturn(owners);

        mockMvc.perform(get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"))
                .andExpect(model().attributeExists("owner"));

            verifyZeroInteractions(ownerService);
    }

    @Test
    void processFindFormReturnMany() throws Exception {
        when(ownerService.findAllByLastNameLike(anyString()))
                .thenReturn(Arrays.asList(Owner.builder().id(1l).build(),
                        Owner.builder().id(2l).build()));

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("selections", hasSize(2)));
    }

    @Test
    void processFindFormReturnOne() throws Exception {
        when(ownerService.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(Owner.builder().id(1l).build()));

        mockMvc.perform(get("/owners"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));
    }

    @Test
    void displayOwner()throws Exception{
        when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());

        mockMvc.perform(get("/owners/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id",is(1L))));
    }
}










