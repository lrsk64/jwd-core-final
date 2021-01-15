package com.epam.jwd.core_final.factory.impl;

import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.factory.EntityFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// do the same for other entities
public class CrewMemberFactory implements EntityFactory<CrewMember> {

    private static Logger LOGGER = LoggerFactory.getLogger(CrewMemberFactory.class);

    private static CrewMemberFactory instance;

    private CrewMemberFactory() {
    }

    public static CrewMemberFactory getInstance(){
        if(instance == null){
            instance = new CrewMemberFactory();
        }
        return instance;
    }

    @Override
    public CrewMember create(Object... args) throws NullPointerException{
        CrewMember newCrewMember = null;
        try{
            newCrewMember = new CrewMember((Long) args[0], (String) args[1], (Long) args[2]);

        } catch (ClassCastException e){
            LOGGER.info("Cannot create new crew member. Wrong argument type");
            throw new NullPointerException("Crew Member was not created");
        }
        return newCrewMember;
    }

}
