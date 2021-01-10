package com.epam.jwd.core_final.domain;

import java.util.Objects;

/**
 * Expected fields:
 * <p>
 * role {@link Role} - member role
 * rank {@link Rank} - member rank
 * isReadyForNextMissions {@link Boolean} - true by default. Set to false, after first failed mission
 */
public class CrewMember extends AbstractBaseEntity {

    private static Long crewMemberId = 0L;

    private Role crewMemberRole;
    private Rank crewMemberRank;
    private Boolean isReadyForNextMissions = true;

    public CrewMember(Long crewMemberRoleId, String crewMemberName, Long crewMemberRankId) {
        super(++crewMemberId, crewMemberName);
        this.crewMemberRole = Role.resolveRoleById(crewMemberRoleId);
        this.crewMemberRank = Rank.resolveRankById(crewMemberRankId);
    }

    public static Long getCrewMemberId() {
        return crewMemberId;
    }

    public Role getCrewMemberRole() {
        return crewMemberRole;
    }

    public Rank getCrewMemberRank() {
        return crewMemberRank;
    }

    public Boolean isReadyForNextMissions() {
        return isReadyForNextMissions;
    }

    public void setNotReadyForNextMissions(){
        isReadyForNextMissions = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrewMember that = (CrewMember) o;
        return crewMemberRole == that.crewMemberRole &&
                crewMemberRank == that.crewMemberRank &&
                crewMemberId.equals(that.crewMemberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crewMemberRole, crewMemberRank, crewMemberId);
    }

    @Override
    public String toString() {
        return "CrewMember{" +
                "crewMemberName=" + getName() +
                ", crewMemberRole=" + crewMemberRole +
                ", crewMemberRank=" + crewMemberRank +
                ", crewMemberId=" + crewMemberId +
                '}';
    }
}
