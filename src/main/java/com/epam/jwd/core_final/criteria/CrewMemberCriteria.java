package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.domain.CrewMember;

/**
 * Should be a builder for {@link com.epam.jwd.core_final.domain.CrewMember} fields
 */
public class CrewMemberCriteria extends Criteria<CrewMember> {

    private String crewMemberName;
    private Long crewMemberRoleId;
    private Long crewMemberRankId;
    private Boolean isReadyForNextMissions;

//    public CrewMemberCriteria(Long crewMemberRoleId, String crewMemberName, Long crewMemberRankId) {
//        this.crewMemberRoleId = crewMemberRoleId;
//        this.crewMemberName = crewMemberName;
//        this.crewMemberRankId = crewMemberRankId;
//        //this.isReadyForNextMissions = isReadyForNextMissions;
//    }

    public CrewMemberCriteria(){

    }

    public CrewMemberCriteria setCrewMemberRoleId(Long crewMemberRoleId){
        this.crewMemberRoleId = crewMemberRoleId;
        return this;
    }

    public CrewMemberCriteria setCrewMemberName(String crewMemberName) {
        this.crewMemberName = crewMemberName;
        return this;
    }

    public CrewMemberCriteria setCrewMemberRankId(Long crewMemberRankId){
        this.crewMemberRankId = crewMemberRankId;
        return this;
    }

    public CrewMemberCriteria setReadyForNextMissions(Boolean readyForNextMissions) {
        isReadyForNextMissions = readyForNextMissions;
        return this;
    }

    public CrewMember build() {
        return new CrewMember(crewMemberRoleId, crewMemberName, crewMemberRankId);
    }

}
