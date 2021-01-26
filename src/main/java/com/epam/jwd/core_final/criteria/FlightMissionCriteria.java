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

//    public FlightMissionCriteria(String name, LocalDate startDate, LocalDate endDate,
//                                 Long distance, Spaceship assignedSpaceship, List<CrewMember> assignedCrew, MissionResult missionResult) {
//        this.name = name;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.distance = distance;
//        this.assignedSpaceship = assignedSpaceship;
//        this.assignedCrew = assignedCrew;
//        this.missionResult = missionResult;
//    }

    public FlightMissionCriteria setName(String name) {
        this.name = name;
        return this;
    }

    public FlightMissionCriteria setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public FlightMissionCriteria setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public FlightMissionCriteria setDistance(Long distance) {
        this.distance = distance;
        return this;
    }

    public FlightMissionCriteria setAssignedSpaceship(Spaceship assignedSpaceship) {
        this.assignedSpaceship = assignedSpaceship;
        return this;
    }

    public FlightMissionCriteria setAssignedCrew(List<CrewMember> assignedCrew) {
        this.assignedCrew = assignedCrew;
        return this;
    }

    public FlightMissionCriteria setMissionResult(MissionResult missionResult) {
        this.missionResult = missionResult;
        return this;
    }

    public FlightMission build(){
        return new FlightMission(name, startDate, endDate, distance, assignedSpaceship, assignedCrew, missionResult);
    }
}