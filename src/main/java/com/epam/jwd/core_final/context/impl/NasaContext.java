package com.epam.jwd.core_final.context.impl;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.domain.*;
import com.epam.jwd.core_final.exception.InvalidStateException;
import com.epam.jwd.core_final.exception.UnknownEntityException;
import com.epam.jwd.core_final.factory.impl.CrewMemberFactory;
import com.epam.jwd.core_final.factory.impl.SpaceshipFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// todo
public class NasaContext implements ApplicationContext {

    private static NasaContext instance;

    private NasaContext() {
    }

    public static NasaContext getInstance(){
        if (instance == null){
            instance = new NasaContext();
        }
        return instance;
    }

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
        getCrewMembersFromFile();
        getSpaceshipsFromFile();
        throw new InvalidStateException();
    }


    private File getFile(String fileName, String fileDir){
        String rootProjectDir = "src/main/resources/";
        File file = null;

        try{
            file = new File(rootProjectDir + fileDir, fileName);
        } catch (NullPointerException e){
            LOGGER.info("Handled NullPointerException"); //todo change message
        }

        return file;
    }

    private String getTextFromFile(File file){
        Scanner scanner = null;
        StringBuilder textFromFile = new StringBuilder();

        try {
            scanner = new Scanner(file);
            while(scanner.hasNext()){
                textFromFile.append(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            LOGGER.info("File " + file.getName() + " not found");
            //todo throw new Custom Exception
        }

        return textFromFile.toString();
    }

    private Matcher getMatchByPattern(String text, String patternString){
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        return matcher;

    }



    private void getCrewMembersFromFile() throws NullPointerException{
        String fileName = APPLICATION_PROPERTIES.getCrewFileName();
        String fileDir = APPLICATION_PROPERTIES.getInputRootDir();

        String crewMemberSearchPattern = "(?<roleId>\\d+),(?<name>[a-zA-Z]+\\s[a-zA-Z]+),(?<rankId>\\d+)";
        String text = getTextFromFile(getFile(fileName, fileDir));
        Matcher matcher = getMatchByPattern(text, crewMemberSearchPattern);

        CrewMember crewMember;

        while(matcher.find()){
            try{
                crewMember = CrewMemberFactory.getInstance().create(Long.parseLong(matcher.group("rankId")),
                        matcher.group("name"), Long.parseLong(matcher.group("roleId")));
            } catch (NumberFormatException e){
                //LOGGER.info("Crew member was not added. Illegal argument");
                throw new NullPointerException("Crew member was not added. Illegal argument");
            }

            crewMembers.add(crewMember);
        }
    }

    public void getSpaceshipsFromFile(){
        String fileName = APPLICATION_PROPERTIES.getSpaceshipsFileName();
        String fileDir = APPLICATION_PROPERTIES.getInputRootDir();

        String spaceshipSearchPattern =
                //"/(?<name>[^,\n\r][\\w\\s-]+);(?<distance>\\d+);(?<crew>\\{(\\d\\:\\d),(\\d\\:\\d),(\\d\\:\\d),(\\d\\:\\d)\\})";
                "(?<name>[^,.\n\r][\\w\\s]+);(?<distance>\\d+);" +
                        "\\{(?<key1>\\d+):(?<value1>\\d+),(?<key2>\\d+):(?<value2>\\d+)," +
                        "(?<key3>\\d+):(?<value3>\\d+),(?<key4>\\d+):(?<value4>\\d+)}\r?\n?";

        String text = getTextFromFile(getFile(fileName, fileDir));
        Matcher matcher = getMatchByPattern(text, spaceshipSearchPattern);

        Spaceship spaceship;
        Map <Role, Short> requiredCrewMembers;

        while (matcher.find()){
            requiredCrewMembers = setRequiredCrewMembers(matcher);

            spaceship = SpaceshipFactory.getInstance().create(matcher.group("name"),
                    Long.parseLong(matcher.group("distance")), requiredCrewMembers);

            spaceships.add(spaceship);
        }
    }

    private void makeFlightMissions(){
        String fileName = APPLICATION_PROPERTIES.getMissionsFileName();
        String fileDir = APPLICATION_PROPERTIES.getOutputRootDir();

        LocalDate startDate = generateRandomLocalDate();
        LocalDate endDate = generateRandomLocalDate(startDate.plusDays(20).toEpochDay(), LocalDate.now().toEpochDay());
        Long flightDistance = generateRandomDistance();
        MissionResult missionResult = chooseRandomMissionResult();


    }

    private LocalDate generateRandomLocalDate(){ //todo pass minday
        long minDay = LocalDate.of(2000, 1, 1).toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate;
    }

    private LocalDate generateRandomLocalDate(long minDay, long maxDay){
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate;
    }

    private Long generateRandomDistance(){
        long minDistance = 20000;
        long maxDistance = 500000;
        long randomDistance = ThreadLocalRandom.current().nextLong(minDistance, maxDistance);
        return randomDistance;
    }

    private Long generateRandomDistance(long minDistance, long maxDistance){
        long randomDistance = ThreadLocalRandom.current().nextLong(minDistance, maxDistance);
        return randomDistance;
    }

    private MissionResult chooseRandomMissionResult(){
        int missionPosition = new Random().nextInt(MissionResult.values().length);
        return MissionResult.values()[missionPosition];
    }

    private Map<Role, Short> setRequiredCrewMembers(Matcher matcher){
        Map<Role, Short> requiredCrewMembers = new HashMap<>();
        requiredCrewMembers.put(Role.resolveRoleById(Long.parseLong(matcher.group("key1"))),
                Short.valueOf(matcher.group("value1")));
        requiredCrewMembers.put(Role.resolveRoleById(Long.parseLong(matcher.group("key2"))),
                Short.valueOf(matcher.group("value2")));
        requiredCrewMembers.put(Role.resolveRoleById(Long.parseLong(matcher.group("key3"))),
                Short.valueOf(matcher.group("value3")));
        requiredCrewMembers.put(Role.resolveRoleById(Long.parseLong(matcher.group("key4"))),
                Short.valueOf(matcher.group("value4")));

        return requiredCrewMembers;
    }

    private Spaceship assignSpaceshipRandom(){
        int spaceshipPosition = new Random().nextInt(spaceships.size());
        return spaceships.stream().collect(Collectors.toList()).get(spaceshipPosition);
    }

    private List<CrewMember> assignCrewFromSpaceship(Spaceship spaceship){
        spaceship.getCrew();
        return null;
    }
//
//    private CrewMember getCrewMemberByRole
}
