package com.epam.jwd.core_final.util.EntityListCreateUtil.impl;

import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.factory.impl.CrewMemberFactory;
import com.epam.jwd.core_final.service.impl.SimpleCrewService;
import com.epam.jwd.core_final.util.EntityListCreateUtil.EntityListGetFromFileStrategy;
import com.epam.jwd.core_final.util.ReadFromFileUtil;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class CrewMembersListGetFromFileStrategy implements EntityListGetFromFileStrategy {

    private static CrewMembersListGetFromFileStrategy instance;

    private final static String regexp = "(?<roleId>\\d+),(?<name>[a-zA-Z]+\\s[a-zA-Z]+),(?<rankId>\\d+)";

    private CrewMembersListGetFromFileStrategy() {

    }

    public static CrewMembersListGetFromFileStrategy getInstance(){
        if (instance == null){
            instance = new CrewMembersListGetFromFileStrategy();
        }

        return instance;
    }

    @Override
    public ArrayList<CrewMember> populateList(String fileName, String fileDir) {
        ArrayList<CrewMember> crewMembersFromFile = new ArrayList<>();

        String text = ReadFromFileUtil.getFromFile(fileName, fileDir);
        Matcher matcher = ReadFromFileUtil.getMatchByPattern(text, regexp);

        while(matcher.find()){
            crewMembersFromFile.add(SimpleCrewService.getInstance().createCrewMember(CrewMemberFactory.getInstance().create(matcher.group("roleId"),
                    matcher.group("name"), matcher.group("rankId"))));
        }

        return crewMembersFromFile;
    }
}
