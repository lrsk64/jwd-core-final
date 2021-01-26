package com.epam.jwd.core_final.util.EntityListCreateUtil.impl;

import com.epam.jwd.core_final.domain.Role;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.factory.impl.SpaceshipFactory;
import com.epam.jwd.core_final.util.EntityListCreateUtil.EntityListGetFromFileStrategy;
import com.epam.jwd.core_final.util.ReadFromFileUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class SpaceshipsListGetFromFileStrategy implements EntityListGetFromFileStrategy {

    private final static String pattern = "(?<name>[^,.\n\r][\\w\\s]+);(?<distance>\\d+);" +
            "\\{(?<key1>\\d+):(?<value1>\\d+),(?<key2>\\d+):(?<value2>\\d+)," +
            "(?<key3>\\d+):(?<value3>\\d+),(?<key4>\\d+):(?<value4>\\d+)}\r?\n?";


    private static SpaceshipsListGetFromFileStrategy instance;

    private SpaceshipsListGetFromFileStrategy() {
    }

    public static SpaceshipsListGetFromFileStrategy getInstance(){
        if (instance == null){
            instance = new SpaceshipsListGetFromFileStrategy();
        }
        return instance;
    }

    @Override
    public ArrayList<Spaceship> populateList(String fileName, String fileDir) {
        ArrayList<Spaceship> spaceshipsFromFile = new ArrayList<>();

        String text = ReadFromFileUtil.getFromFile(fileName, fileDir);
        Matcher matcher = ReadFromFileUtil.getMatchByPattern(text, pattern);

        Map<Role, Short> requiredCrewMembers;

        while (matcher.find()){
            requiredCrewMembers = setRequiredCrewMembersOnSpaceship(matcher);

            spaceshipsFromFile.add(SpaceshipFactory.getInstance().create(matcher.group("name"),
                    Long.parseLong(matcher.group("distance")), requiredCrewMembers));
        }

        return spaceshipsFromFile;
    }

    private Map<Role, Short> setRequiredCrewMembersOnSpaceship(Matcher matcher){
        Map<Role, Short> requiredCrewMembers = new HashMap<>();
        requiredCrewMembers.put(Role.resolveRoleById(Long.parseLong(matcher.group("key1"))),
                Short.valueOf(matcher.group("value1")));
        requiredCrewMembers.put(Role.resolveRoleById(Long.parseLong(matcher.group("key2"))),
                Short.valueOf(matcher.group("value2")));
        requiredCrewMembers.put(Role.resolveRoleById(Long.parseLong(matcher.group("key3"))),
                Short.valueOf(matcher.group("value3")));
        requiredCrewMembers.put(Role.resolveRoleById(Long.parseLong(matcher.group("key4"))),
                Short.valueOf(matcher.group("value4")));

        return requiredCrewMembers;
    }

}
