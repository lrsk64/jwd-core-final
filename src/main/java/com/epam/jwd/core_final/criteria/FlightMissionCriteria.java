package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.FlightMission;
import com.epam.jwd.core_final.domain.MissionResult;
import com.epam.jwd.core_final.domain.Spaceship;

import java.time.LocalDate;
import java.util.List;

/**
 * Should be a builder for {@link com.epam.jwd.core_final.domain.FlightMission} fields
 */
public class FlightMissionCriteria extends Criteria<FlightMission> {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long distance;
    private Spaceship assignedSpaceship;
    private List<CrewMember> assignedCrew;
    private MissionResult missionResult;

    private FlightMissionCriteria() {
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Long getDistance() {
        return distance;
    }

    public Spaceship getAssignedSpaceship() {
        return assignedSpaceship;
    }

    public List<CrewMember> getAssignedCrew() {
        return assignedCrew;
    }

    public MissionResult getMissionResult() {
        return missionResult;
    }

    public static FlightMissionCriteria.Builder newBuilder(){
        return new FlightMissionCriteria().new Builder();
    }

    public class Builder{
        private Builder() {
        }

        public Builder setName(String name) {
            FlightMissionCriteria.this.name = name;
            return this;
        }

        public Builder setStartDate(LocalDate startDate) {
            FlightMissionCriteria.this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(LocalDate endDate) {
            FlightMissionCriteria.this.endDate = endDate;
            return this;
        }

        public Builder setDistance(Long distance) {
            FlightMissionCriteria.this.distance = distance;
            return this;
        }

        public Builder setAssignedSpaceship(Spaceship assignedSpaceship) {
            FlightMissionCriteria.this.assignedSpaceship = assignedSpaceship;
            return this;
        }

        public Builder setAssignedCrew(List<CrewMember> assignedCrew) {
            FlightMissionCriteria.this.assignedCrew = assignedCrew;
            return this;
        }

        public Builder setMissionResult(MissionResult missionResult) {
            FlightMissionCriteria.this.missionResult = missionResult;
            return this;
        }

        public FlightMissionCriteria build(){
            return FlightMissionCriteria.this;
        }
    }
}
