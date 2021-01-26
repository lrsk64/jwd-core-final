package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.context.impl.NasaContext;
import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.exception.DuplicateEntityException;
import com.epam.jwd.core_final.exception.NotAbleToAssignException;
import com.epam.jwd.core_final.exception.UnknownEntityException;
import com.epam.jwd.core_final.factory.impl.CrewMemberFactory;
import com.epam.jwd.core_final.service.CrewService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class SimpleCrewService implements CrewService {

    private static SimpleCrewService instance;
    private ApplicationContext applicationContext = NasaContext.getInstance();

    private SimpleCrewService() {
    }

    public static SimpleCrewService getInstance(){
        if (instance == null){
            instance = new SimpleCrewService();
        }
        return instance;
    }

    @Override
    public List<CrewMember> findAllCrewMembers() {
        return new ArrayList<>(applicationContext.retrieveBaseEntityList(CrewMember.class));
    }

    @Override
    public List<CrewMember> findAllCrewMembersByCriteria(Criteria<? extends CrewMember> criteria) {
        CrewMemberCriteria crewMemberCriteria = (CrewMemberCriteria) criteria;
        return findAllCrewMembers().stream()
                .filter(crewMember -> Objects.nonNull(crewMember))
                .filter(crewMember -> crewMemberCriteria.getId() == null
                        || crewMember.getId().equals(crewMemberCriteria.getId()))
                .filter(crewMember -> crewMemberCriteria.getName() == null
                        || crewMember.getName().equals(crewMemberCriteria.getName()))
                .filter(crewMember -> crewMemberCriteria.getRole() == null
                        || crewMember.getRole().equals(crewMemberCriteria.getRole()))
                .filter(crewMember -> crewMemberCriteria.getRank() == null
                        || crewMember.getRank().equals(crewMemberCriteria.getRank()))
                .filter(crewMember -> crewMemberCriteria.isReadyForNextMissions() == null
                        || crewMember.isReadyForNextMissions().equals(crewMemberCriteria.isReadyForNextMissions()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CrewMember> findCrewMemberByCriteria(Criteria<? extends CrewMember> criteria) {
        if (criteria == null) {
            return Optional.empty();
        } else {
            CrewMemberCriteria crewMemberCriteria = (CrewMemberCriteria) criteria;
            return findAllCrewMembersByCriteria(crewMemberCriteria).stream()
                    .findFirst();
        }
    }

    @Override
    public CrewMember updateCrewMemberDetails(CrewMember crewMember) {
        if (isCrewMemberExist(crewMember)){
            throw new UnknownEntityException(crewMember.getName());
        } else{
            findEqualsCrewMember(crewMember);
            findAllCrewMembers().remove(crewMember);
            createCrewMember(crewMember);
            return CrewMemberFactory.getInstance().create(crewMember.getName(), crewMember.getRole(), crewMember.getRank());
        }
    }

    @Override
    public void assignCrewMemberOnMission(CrewMember crewMember) throws NotAbleToAssignException {
        if(crewMember.isReadyForNextMissions()){
            crewMember.setNotReadyForNextMissions();
        } else{
            throw new NotAbleToAssignException(crewMember.getName());
        }
    }

    @Override
    public CrewMember createCrewMember(CrewMember crewMember) throws DuplicateEntityException {
        if (isCrewMemberExist(crewMember)){
            throw new DuplicateEntityException(crewMember.getName());
        } else{
            //return CrewMemberFactory.getInstance().create(crewMember.getRank().getId(), crewMember.getName(), crewMember.getRole().getId());
            return crewMember;
        }
    }

    private boolean isCrewMemberExist(CrewMember crewMember){
        return !(findAllCrewMembers().stream()
                .noneMatch(existedCrewMember -> existedCrewMember.getName().equals(crewMember.getName()) &&
                        existedCrewMember.getRank().equals(crewMember.getRank()) &&
                        existedCrewMember.getRole().equals(crewMember.getRole())));
    }

    private CrewMember findEqualsCrewMember(CrewMember crewMember){
        return findAllCrewMembers().stream()
                .filter(existedCrewMember -> existedCrewMember.getName().equals(crewMember.getName()) &&
                        existedCrewMember.getRank().equals(crewMember.getRank()) &&
                        existedCrewMember.getRole().equals(crewMember.getRole()))
                .findFirst()
                .get();
    }
}
