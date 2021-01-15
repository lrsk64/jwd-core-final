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

    private SpaceshipCriteria() {
    }

    public String getName() {
        return name;
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

    public static Builder newBuilder(){
        return new SpaceshipCriteria().new Builder();
    }

    public class Builder{
        public Builder() {
        }

        public Builder setName(String name){
            SpaceshipCriteria.this.name = name;
            return this;
        }

        public Builder setCrew(Map<Role, Short> crew) {
            SpaceshipCriteria.this.crew = crew;
            return this;
        }

        public Builder setFlightDistance(Long flightDistance) {
            SpaceshipCriteria.this.flightDistance = flightDistance;
            return this;
        }

        public Builder setReadyForNextMissions(boolean readyForNextMissions) {
            SpaceshipCriteria.this.isReadyForNextMissions = readyForNextMissions;
            return this;
        }

        public SpaceshipCriteria build(){
            return SpaceshipCriteria.this;
        }
    }
}
