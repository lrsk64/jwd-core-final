package com.epam.jwd.core_final.util.EntityListCreateUtil;

import com.epam.jwd.core_final.domain.AbstractBaseEntity;
import com.epam.jwd.core_final.exception.InvalidStateException;

import java.util.ArrayList;

public interface EntityListGetFromFileStrategy {
    String fileName = null;
    String fileDir = null;

    <T extends AbstractBaseEntity> ArrayList<T> populateList(String fileName, String fileDir) throws InvalidStateException;
}
