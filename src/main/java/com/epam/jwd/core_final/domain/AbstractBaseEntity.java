package com.epam.jwd.core_final.domain;

/**
 * Expected fields:
 * <p>
 * id {@link Long} - entity id
 * name {@link String} - entity name
 */
public abstract class AbstractBaseEntity implements BaseEntity {

    private Long entityId;
    private String entityName;

    public AbstractBaseEntity(Long entityId, String entityName) {
        this.entityId = entityId;
        this.entityName = entityName;
    }

    @Override
    public Long getId() {
        return entityId;
    }

    @Override
    public String getName() {
        return entityName;
    }
}
