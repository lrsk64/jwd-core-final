package com.epam.jwd.core_final.context.impl;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.domain.*;
import com.epam.jwd.core_final.exception.InvalidStateException;
import com.epam.jwd.core_final.exception.UnknownEntityException;
import com.epam.jwd.core_final.util.EntityListCreateUtil.EntityListGetFromFileStrategy;
import com.epam.jwd.core_final.util.EntityListCreateUtil.impl.CrewMembersListGetFromFileStrategy;
import com.epam.jwd.core_final.util.EntityListCreateUtil.impl.FlightMissionsGenerateUtil;
import com.epam.jwd.core_final.util.EntityListCreateUtil.impl.SpaceshipsListGetFromFileStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;

// todo
public class NasaContext implements ApplicationContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(NasaContext.class);

    private static NasaContext instance;

    private final String rootProjectDir = "src/main/resources/";
    private final ApplicationProperties APP_PROPERTIES = ApplicationProperties.getInstance();

    // no getters/setters for them
    private Collection<CrewMember> crewMembers = new ArrayList<>();
    private Collection<Spaceship> spaceships = new ArrayList<>();
    private Collection<FlightMission> flightMissions = new ArrayList<>();

    private EntityListGetFromFileStrategy entityListGetFromFileStrategy; //todo implement strategy pattern

    private NasaContext() {
    }

    public static NasaContext getInstance(){
        if (instance == null){
            instance = new NasaContext();
        }
        return instance;
    }

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
        crewMembers = populateEntityList(CrewMember.class);
        spaceships = populateEntityList(Spaceship.class);
        flightMissions = populateEntityList(FlightMission.class);
        //throw new InvalidStateException();
    }

    private void setEntityListFromFileStrategy(EntityListGetFromFileStrategy strategy){
        this.entityListGetFromFileStrategy = strategy;
    }

    private <T extends AbstractBaseEntity> ArrayList<T> getEntityListFromFile(String fileName, String fileDir) throws InvalidStateException{
        return entityListGetFromFileStrategy.populateList(fileName, fileDir);
    }

    private <T extends AbstractBaseEntity> ArrayList<T> populateEntityList(Class<T> tClass) throws InvalidStateException{
        String fileName = "";
        String fileDir = APP_PROPERTIES.getRootProjectDir() + APP_PROPERTIES.getInputRootDir();

        if (tClass == CrewMember.class) {
            fileName = APP_PROPERTIES.getCrewFileName();
            setEntityListFromFileStrategy(CrewMembersListGetFromFileStrategy.getInstance());
        }

        else if (tClass == Spaceship.class) {
            fileName = APP_PROPERTIES.getSpaceshipsFileName();
            setEntityListFromFileStrategy(SpaceshipsListGetFromFileStrategy.getInstance());
        }

        else if (tClass == FlightMission.class) {
            fileName = APP_PROPERTIES.getMissionsFileName();
            fileDir = APP_PROPERTIES.getRootProjectDir() + APP_PROPERTIES.getOutputRootDir();
            //setEntityListFromFileStrategy(FlightMissionsGenerateUtil.getInstance());
            FlightMissionsGenerateUtil.getInstance().populateList(new ArrayList<Spaceship> (spaceships), new ArrayList<CrewMember>(crewMembers));
        }

        return getEntityListFromFile(fileName, fileDir);
    }
}
