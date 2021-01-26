package com.epam.jwd.core_final.util.EntityListCreateUtil.impl;

import com.epam.jwd.core_final.context.impl.NasaContext;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.FlightMission;
import com.epam.jwd.core_final.domain.MissionResult;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.exception.InvalidStateException;
import com.epam.jwd.core_final.factory.impl.FlightMissionFactory;
import com.epam.jwd.core_final.util.GenerateModelsProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightMissionsGenerateUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(NasaContext.class);
    private static FlightMissionsGenerateUtil instance;

    private FlightMissionsGenerateUtil() {
    }

    public static FlightMissionsGenerateUtil getInstance(){
        if (instance == null){
            instance = new FlightMissionsGenerateUtil();
        }

        return instance;
    }

    public ArrayList<FlightMission> populateList(ArrayList<Spaceship> spaceships, ArrayList<CrewMember> crewMembers) throws InvalidStateException {

        try{
            checkPopulateFlightMissionsArgs(spaceships, crewMembers);
        } catch (NullPointerException e){
            throw new InvalidStateException();
        }


        ArrayList<FlightMission> flightMissions = new ArrayList<>();

        LocalDate startDate = GenerateModelsProperties.generateRandomLocalDate();
        LocalDate endDate = GenerateModelsProperties.generateRandomLocalDate(startDate.plusDays(20).toEpochDay(),
                LocalDate.now().toEpochDay());
        Long flightDistance = GenerateModelsProperties.generateRandomDistance();
        MissionResult missionResult = GenerateModelsProperties.chooseRandomMissionResult();
        Spaceship spaceship = assignSpaceshipRandom();
        List<CrewMember> crew = assignCrewFromSpaceship(spaceship);

        flightMissions.add(FlightMissionFactory.getInstance().create("name", startDate, endDate, flightDistance,
                spaceship, crew, missionResult));

        return flightMissions;
    }

    private boolean checkPopulateFlightMissionsArgs(ArrayList<Spaceship> spaceships, ArrayList<CrewMember> crewMembers) throws NullPointerException{
        if (spaceships == null || spaceships.size() == 0){
            LOGGER.error("Can't create any flight mission. There is no spaceships.");
            throw new NullPointerException();
        } else if (crewMembers == null || crewMembers.size() == 0){
            LOGGER.error("Can't create any flight mission. There is no crew members.");
            throw new NullPointerException();
        }
        return true;
    }


    private Spaceship assignSpaceshipRandom(){
//        int spaceshipPosition = new Random().nextInt(spaceships.size());
//        return spaceships.stream().collect(Collectors.toList()).get(spaceshipPosition);
        return null;
    }

    private List<CrewMember> assignCrewFromSpaceship(Spaceship spaceship){
//        List<CrewMember> assignCrew = new ArrayList<>();
//        Map<Role, Short> requiredCrew = new HashMap<>(spaceship.getCrew());
//        for (Map.Entry<Role, Short> requiredCrewMember : requiredCrew.entrySet()){
//            requiredCrewMember.getKey(); //Role
//            List<CrewMember> existingCrewMembersByRole = crewMembers.stream().filter(existingCrewMember -> existingCrewMember.getRole()
//                    .equals(requiredCrewMember.getKey())).collect(Collectors.toList());
//            requiredCrewMember.getValue(); //amountOfMembers with that roleId
//            for (int i = 0; i <= requiredCrewMember.getValue(); i++) {
//                assignCrew.add(existingCrewMembersByRole.get(i)); //todo if existingCreMembersByRole.size() < i
//            }
//        }
        return null;
    }
}
