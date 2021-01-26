package com.epam.jwd.core_final.menu.impl;

import com.epam.jwd.core_final.context.impl.MenuText;
import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.domain.Rank;
import com.epam.jwd.core_final.menu.AbstractEntityMenu;
import com.epam.jwd.core_final.util.UserInputUtil;

import java.util.Scanner;

public class CriteriaToFindMenu extends AbstractEntityMenu {

    private final String AVAILABLE_CRITERIA_TO_SEARCH_TEXT =
            "Choose criteria to search: \n" +
            "1 - Rank\n" +
            "2 - Role\n" +
            "3 - Name\n" +
            "0 - To quit program\n";

    private final String AVAILABLE_RANKS_TEXT =
            "Available ranks:\n" +
            MenuText.getInputSuggestionText() +
            "1 - Trainee\n" +
            "2 - Second officer\n" +
            "3 - First officer\n" +
            "4 - Captain\n";

    private final String AVAILABLE_ROLES_TEXT =
            "Available roles:\n" +
            MenuText.getInputSuggestionText() +
            "1 - Mission specialist\n" +
            "2 - Flight engineer\n" +
            "3 - Pilot\n" +
            "4 - Commander\n";

    private final String INPUT_NAME_TEXT = "Input crew member name\n";

    @Override
    public String getAvailableOptions() {
        return AVAILABLE_CRITERIA_TO_SEARCH_TEXT;
    }

    @Override
    public void handleUserInput(Scanner scanner) {
        if (scanner.hasNextInt()){
            switch (scanner.nextInt()){
                case 0:
                    System.out.println(MenuText.getEndOfProgramText());
                    System.exit(0);
                case 1:
                    System.out.println(AVAILABLE_RANKS_TEXT);
                    createCrewMemberCriteria(chooseRank(UserInputUtil.getUserInput()));
                case 2:
                    System.out.println(AVAILABLE_ROLES_TEXT);
                case 3:
                    System.out.println();
                default:
            }
        }
    }

    private Rank chooseRank(Scanner scanner){
        if (scanner.hasNextInt()){
            switch (scanner.nextInt()){
                case 1:
                    return Rank.resolveRankById(1L);
                case 2:
                    return Rank.resolveRankById(2L);
                case 3:
                    return Rank.resolveRankById(3L);
                case 4:
                    return Rank.resolveRankById(4L);
                default:
                    System.out.println(MenuText.getWrongInputText());
                    return null;
            }
        } else {
            System.out.println(MenuText.getWrongInputText());
        }
        return null;
    }

    private CrewMemberCriteria createCrewMemberCriteria(Rank rank){
        CrewMemberCriteria crewMemberCriteria = new CrewMemberCriteria();
        return crewMemberCriteria.setRank(rank);
    }
}
