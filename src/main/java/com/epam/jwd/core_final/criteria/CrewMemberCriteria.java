package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Rank;
import com.epam.jwd.core_final.domain.Role;

/**
 * Should be a builder for {@link com.epam.jwd.core_final.domain.CrewMember} fields
 */
public class CrewMemberCriteria extends Criteria<CrewMember> {

    private Long id;
    private String name;
    private Role role;
    private Rank rank;
    private Boolean isReadyForNextMissions;

//    public CrewMemberCriteria(String name, Long roleId, Long rankId) {
//        this.name = name;
//        this.roleId = roleId;
//        this.rankId = rankId;
//        this.isReadyForNextMissions = true;
//    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public Rank getRank() {
        return rank;
    }

    public Boolean isReadyForNextMissions() {
        return isReadyForNextMissions;
    }

    public CrewMemberCriteria setId(Long id){
        this.id = id;
        return this;
    }

    public CrewMemberCriteria setName(String name) {
        this.name = name;
        return this;
    }

    public CrewMemberCriteria setRole(Role role) {
        this.role = role;
        return this;
    }

    public CrewMemberCriteria setRank(Rank rank) {
        this.rank = rank;
        return this;
    }

    public CrewMemberCriteria setReadyForNextMissions(Boolean readyForNextMissions) {
        isReadyForNextMissions = readyForNextMissions;
        return this;
    }

    public CrewMember build(){
        return new CrewMember(role, name, rank);
    }
}
