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

    private static Long id = 0L;

    private final Role role;
    private Rank rank;
    private Boolean isReadyForNextMissions = true;

    public CrewMember(Long crewMemberRoleId, String crewMemberName, Long crewMemberRankId) {
        super(++id, crewMemberName);
        this.role = Role.resolveRoleById(crewMemberRoleId);
        this.rank = Rank.resolveRankById(crewMemberRankId);
    }

    public CrewMember(Role crewMemberRole, String crewMemberName, Rank crewMemberRank) {
        super(++id, crewMemberName);
        this.role = crewMemberRole;
        this.rank = crewMemberRank;
    }

    public static Long getCrewMemberId() {
        return id;
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

    public void setNotReadyForNextMissions(){
        isReadyForNextMissions = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrewMember that = (CrewMember) o;
        return role == that.role &&
                rank == that.rank &&
                id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, rank, id);
    }

    @Override
    public String toString() {
        return "CrewMember{" +
                "name=" + getName() +
                ", role=" + role +
                ", rank=" + rank +
                ", id=" + id +
                ", isReadyForNextMissions=" + isReadyForNextMissions +
                '}';
    }
}
