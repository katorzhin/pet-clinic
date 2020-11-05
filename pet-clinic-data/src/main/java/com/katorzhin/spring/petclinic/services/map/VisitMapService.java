package com.katorzhin.spring.petclinic.services.map;

import com.katorzhin.spring.petclinic.model.Visit;
import com.katorzhin.spring.petclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findALL() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Visit save(Visit visits) {
        if (visits.getPet() == null || visits.getPet().getOwner() == null || visits.getPet().getId() == null) {
            throw new RuntimeException("invalid visit");
        }
        return super.save(visits);
    }

    @Override
    public void delete(Visit visits) {
        super.delete(visits);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
