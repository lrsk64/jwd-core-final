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
    public CrewMember create(Object... args){
        CrewMember newCrewMember = null;
        try{
            newCrewMember = new CrewMemberCriteria().setCrewMemberRoleId((Long) args[0]).setCrewMemberName((String) args[1]).setCrewMemberRankId((Long) args[2]).build();
        } catch (ClassCastException e){
            LOGGER.info("Cannot create new crew member. Wrong argument type");
        }
        return newCrewMember;
    }

}
