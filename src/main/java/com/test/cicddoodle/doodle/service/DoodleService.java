package com.test.cicddoodle.doodle.service;

import com.test.cicddoodle.doodle.entity.Doodle;
import com.test.cicddoodle.doodle.repository.DoodleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoodleService {

    private final DoodleRepository doodleRepository;

    public Doodle saveDoodle(Doodle doodle) {
        log.info("Saving new doodle: {}", doodle.getName());
        Doodle entity = new Doodle();
        entity.setName(doodle.getName());
        entity.setDescription(doodle.getDescription());
        entity.setUrl(doodle.getUrl());
        Doodle saved = doodleRepository.save(entity);
        log.debug("Saved doodle with id: {}", saved.getId());
        return saved;
    }


    public Doodle getDoodleById(Long id) {
        log.info("Fetching doodle by id: {}", id);
        return doodleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doodle with id => " + id + " does not exist"));
    }

    public void deleteDoodle(Long id) {
        log.warn("Deleting doodle with id: {}", id);
        doodleRepository.deleteById(id);
    }

    public Doodle updateDoodle(Doodle doodle) {
        log.info("Updating doodle with id: {}", doodle.getId());
        Doodle existingDoodle = getDoodleById(doodle.getId());
        existingDoodle.setName(doodle.getName());
        existingDoodle.setDescription(doodle.getDescription());
        existingDoodle.setUrl(doodle.getUrl());
        Doodle updated = doodleRepository.save(existingDoodle);
        log.debug("Updated doodle: {}", updated);
        return updated;
    }

    public List<Doodle> getAllDoodles() {
        return doodleRepository.findAll();
    }
}