package com.epam.jwd.core_final.context.impl;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.domain.*;
import com.epam.jwd.core_final.exception.InvalidStateException;
import com.epam.jwd.core_final.exception.UnknownEntityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// todo
public class NasaContext implements ApplicationContext {

    private final ApplicationProperties APPLICATION_PROPERTIES = ApplicationProperties.getInstance();
    private static final Logger LOGGER = LoggerFactory.getLogger(NasaContext.class);

    // no getters/setters for them
    private Collection<CrewMember> crewMembers = new ArrayList<>();
    private Collection<Spaceship> spaceships = new ArrayList<>();
    private Collection<FlightMission> flightMissions = new ArrayList<>();

    @Override
    public <T extends BaseEntity> Collection<T> retrieveBaseEntityList(Class<T> tClass) {
        if (tClass == CrewMember.class) {
            return (Collection<T>) crewMembers;
        }
        else if (tClass == Spaceship.class) {
            return (Collection<T>) spaceships;
        }
        else if (tClass == FlightMission.class) {
            return (Collection<T>) flightMissions;
        }
        throw new UnknownEntityException(tClass.getSimpleName());
    }

    /**
     * You have to read input files, populate collections
     * @throws InvalidStateException
     */
    @Override
    public void init() throws InvalidStateException {
        throw new InvalidStateException();
    }


    private Scanner openFile(String fileName, String fileDir){
        Scanner scanner = null;

        try {
            scanner = new Scanner(new File(fileDir, fileName));
        } catch (FileNotFoundException e) {
            LOGGER.info("File with name '" + fileName + "' not found");
        }
        return scanner;
    }



    private void populateCrewMembersList(){
        Long roleId;
        String name;
        Long rankId;

        String fileName = APPLICATION_PROPERTIES.getCrewFileName();
        String fileDir = "src/main/resources/" + APPLICATION_PROPERTIES.getInputRootDir();

        Scanner scanner = openFile(fileName, fileDir);
        scanner.useDelimiter("...");
        System.out.println(scanner.next());
        scanner.nextLine();

        ArrayList<String> crewMembersFromFile = new ArrayList<>();

        scanner.useDelimiter(";");

        while(scanner.hasNext()){
            crewMembersFromFile.add(scanner.next());
        }

        Scanner anotherScanner;
        for (String s : crewMembersFromFile) {
            anotherScanner = new Scanner(s);
            anotherScanner.useDelimiter(",");

            while (anotherScanner.hasNext()){
                CrewMember crewMember = (new CrewMemberCriteria().setCrewMemberRoleId(anotherScanner.nextLong())
                        .setCrewMemberName(anotherScanner.next())
                        .setCrewMemberRankId(anotherScanner.nextLong()).build());
                crewMembers.add(crewMember);
                System.out.println(crewMember);
            }
        }
    }

    private void populateSpaceshipsList(){
        String name;
        Long distance;
        Map<Long,Short> crew;

        String fileName = APPLICATION_PROPERTIES.getSpaceshipsFileName();
        String fileDir = "src/main/resources/" + APPLICATION_PROPERTIES.getInputRootDir();

        Scanner scanner = openFile(fileName, fileDir);
        scanner.nextLine();
        scanner.nextLine();
        scanner.nextLine();

        ArrayList<String> spaceshipsFromFile = new ArrayList<>();

        while(scanner.hasNextLine()){
            spaceshipsFromFile.add(scanner.nextLine());
        }

        Scanner anotherScanner;
        for (String s : spaceshipsFromFile) {
            anotherScanner = new Scanner(s);
            anotherScanner.useDelimiter(";");

            while (anotherScanner.hasNext()){
                name = anotherScanner.next();
                distance = anotherScanner.nextLong();

                crew = new HashMap<>();
//                Scanner scanner1 = new Scanner(anotherScanner.next());
//                scanner1.
//                while (scanner.hasNext())

                //Spaceship spaceship = new Spaceship(name, distance, crew);
                //spaceships.add(spaceship);
            }
        }
    }
}
