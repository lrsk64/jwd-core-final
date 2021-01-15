package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.context.impl.NasaContext;
import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.service.CrewService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toCollection;

public class SimpleCrewService implements CrewService {

    private SimpleCrewService instance;
    private ApplicationContext applicationContext;

    private SimpleCrewService() {
    }

    public SimpleCrewService getInstance(){
        if(instance == null){
            instance = new SimpleCrewService();
        }
        return instance;
    }
    public SimpleCrewService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public List<CrewMember> findAllCrewMembers() {
        Collection crewMembersCollection = applicationContext.retrieveBaseEntityList(CrewMember.class);
        List<CrewMember> crewMembersList = new ArrayList<>(crewMembersCollection);
        return crewMembersList;
    }

    @Override
    public List<CrewMember> findAllCrewMembersByCriteria(Criteria<? extends CrewMember> criteria) {
        //List<CrewMember> crewMemberListByCriteria = findAllCrewMembers().stream().filter()
        return null;
    }

    @Override
    public Optional<CrewMember> findCrewMemberByCriteria(Criteria<? extends CrewMember> criteria) {
        return Optional.empty();
    }

    @Override
    public CrewMember updateCrewMemberDetails(CrewMember crewMember) {
        return null;
    }

    @Override
    public void assignCrewMemberOnMission(CrewMember crewMember) throws RuntimeException {

    }

    @Override
    public CrewMember createCrewMember(CrewMember spaceship) throws RuntimeException {
        return null;
    }
}
