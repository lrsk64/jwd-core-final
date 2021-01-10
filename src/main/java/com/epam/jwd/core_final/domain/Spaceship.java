package com.epam.jwd.core_final.domain;


import java.util.Map;
import java.util.Objects;

/**
 * crew {@link java.util.Map<Role, Short>}
 * flightDistance {@link Long} - total available flight distance
 * isReadyForNextMissions {@link Boolean} - true by default. Set to false, after first failed mission
 */
public class Spaceship extends AbstractBaseEntity {

    private static Long spaceshipId = 0L;

    private Map<Role, Short> crew;
    private Long flightDistance;
    private boolean isReadyForNextMissions = true;

    public Spaceship(String spaceshipName, Long flightDistance, Map<Role, Short> crew) {
        super(spaceshipId++, spaceshipName);
        this.flightDistance = flightDistance;
        this.crew = crew;
    }

    public Map<Role, Short> getCrew() {
        return crew;
    }

    public Long getFlightDistance() {
        return flightDistance;
    }

    public boolean isReadyForNextMissions() {
        return isReadyForNextMissions;
    }

    public void setNotReadyForNextMissions(){
        isReadyForNextMissions = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spaceship spaceship = (Spaceship) o;
        return isReadyForNextMissions == spaceship.isReadyForNextMissions &&
                crew.equals(spaceship.crew) &&
                flightDistance.equals(spaceship.flightDistance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crew, flightDistance, isReadyForNextMissions);
    }

    @Override
    public String toString() {
        return "Spaceship{" +
                "name=" + getName() +
                ", crew=" + crew +
                ", flightDistance=" + flightDistance +
                ", isReadyForNextMissions=" + isReadyForNextMissions +
                '}';
    }
}
