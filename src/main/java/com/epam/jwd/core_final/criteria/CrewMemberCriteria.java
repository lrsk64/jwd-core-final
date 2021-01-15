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

    private CrewMemberCriteria(){

    }

    public String getCrewMemberName() {
        return crewMemberName;
    }

    public Long getCrewMemberRoleId() {
        return crewMemberRoleId;
    }

    public Long getCrewMemberRankId() {
        return crewMemberRankId;
    }

    public Boolean getReadyForNextMissions() {
        return isReadyForNextMissions;
    }

    public static Builder newBuilder(){
        return new CrewMemberCriteria().new Builder();
    }

    public class Builder{

        private Builder(){

        }

        public Builder setCrewMemberRoleId(Long crewMemberRoleId){
            CrewMemberCriteria.this.crewMemberRoleId = crewMemberRoleId;
            return this;
        }

        public Builder setCrewMemberName(String crewMemberName) {
            CrewMemberCriteria.this.crewMemberName = crewMemberName;
            return this;
        }

        public Builder setCrewMemberRankId(Long crewMemberRankId){
            CrewMemberCriteria.this.crewMemberRankId = crewMemberRankId;
            return this;
        }

        public Builder setReadyForNextMissions(Boolean readyForNextMissions) {
            CrewMemberCriteria.this.isReadyForNextMissions = readyForNextMissions;
            return this;
        }

        public CrewMemberCriteria build() {
            return CrewMemberCriteria.this;
        }
    }
}
