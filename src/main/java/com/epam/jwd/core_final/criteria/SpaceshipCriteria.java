package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.domain.Role;
import com.epam.jwd.core_final.domain.Spaceship;

import java.util.Map;

/**
 * Should be a builder for {@link Spaceship} fields
 */
public class SpaceshipCriteria extends Criteria<Spaceship> {

    private String name;
    private Map<Role, Short> crew;
    private Long flightDistance;
    private boolean isReadyForNextMissions = true;


    public SpaceshipCriteria setName(String name) {
        this.name = name;
        return this;
    }

    public SpaceshipCriteria setCrew(Map<Role, Short> crew) {
        this.crew = crew;
        return this;
    }

    public SpaceshipCriteria setFlightDistance(Long flightDistance) {
        this.flightDistance = flightDistance;
        return this;
    }

    public SpaceshipCriteria setReadyForNextMissions(boolean readyForNextMissions) {
        isReadyForNextMissions = readyForNextMissions;
        return this;
    }

    public Spaceship build(){
        return new Spaceship(name, flightDistance, crew);
    }
}
