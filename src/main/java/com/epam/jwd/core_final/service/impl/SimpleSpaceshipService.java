package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.exception.DuplicateEntityException;
import com.epam.jwd.core_final.exception.NotAbleToAssignException;
import com.epam.jwd.core_final.service.SpaceshipService;

import java.util.List;
import java.util.Optional;

public class SimpleSpaceshipService implements SpaceshipService {

    private static SimpleSpaceshipService instance;

    private SimpleSpaceshipService() {
    }

    public static SimpleSpaceshipService getInstance(){
        if (instance == null){
            instance = new SimpleSpaceshipService();
        }

        return instance;
    }

    @Override
    public List<Spaceship> findAllSpaceships() {
        return null;
    }

    @Override
    public List<Spaceship> findAllSpaceshipsByCriteria(Criteria<? extends Spaceship> criteria) {
        return null;
    }

    @Override
    public Optional<Spaceship> findSpaceshipByCriteria(Criteria<? extends Spaceship> criteria) {
        return Optional.empty();
    }

    @Override
    public Spaceship updateSpaceshipDetails(Spaceship spaceship) {
        return null;
    }

    @Override
    public void assignSpaceshipOnMission(Spaceship crewMember) throws NotAbleToAssignException {

    }

    @Override
    public Spaceship createSpaceship(Spaceship spaceship) throws DuplicateEntityException {
        return null;
    }
}
