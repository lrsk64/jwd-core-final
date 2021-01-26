package com.epam.jwd.core_final.menu.impl;

import com.epam.jwd.core_final.context.impl.MenuText;
import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.menu.AbstractEntityMenu;
import com.epam.jwd.core_final.service.impl.SimpleCrewService;

import java.util.Scanner;

public class CrewMemberMenu extends AbstractEntityMenu {

    private static CrewMemberMenu instance;

    private CrewMemberMenu() {
    }

    public static CrewMemberMenu getInstance(){
        if (instance == null){
            instance = new CrewMemberMenu();
        }

        return instance;
    }

    private final String AVAILABLE_OPTIONS = MenuText.getAvailableEntityOptionsText();

    @Override
    public String getAvailableOptions() {
        return AVAILABLE_OPTIONS;
    }

    @Override
    public void handleUserInput(Scanner scanner) {
        if (scanner.hasNextInt()){
            SimpleCrewService service = SimpleCrewService.getInstance();
            switch (scanner.nextInt()){
                case 0:
                    System.out.println(MenuText.getEndOfProgramText());
                    System.exit(0);
                case 1:
                    service.findAllCrewMembers().stream().forEach(System.out::println);
                    break;
                case 2:
                    //System.out.println(MenuText.getCrewMembersAvailableCriteriaToSearchText());
                    //createCriteriaToFind;
                    //service.findAllCrewMembersByCriteria();
                    break;
                case 3:
                    //createCriteriaToFind;
                    //service.findCrewMemberByCriteria();
                    break;
                case 4:
                    //choose role, rank, input name
                    //service.createCrewMember();
                    break;
                case 5:
                    //find creMember to update
                    //choose role, rank, input name
                    //service.updateCrewMemberDetails();
                    break;
                default:
                    System.out.println(MenuText.getWrongInputText());
                    printAvailableOptions(AVAILABLE_OPTIONS);
            }
        } else{
            System.out.println(MenuText.getWrongInputText());
            System.out.println(MenuText.getInputSuggestionText());
        }
    }

    private CrewMemberCriteria createCriteriaToSearch(int criteriaId){

        return new CrewMemberCriteria();
    }

    private int getCriteriaToSearchId(Scanner scanner){
        if (scanner.hasNextInt()){
            switch (scanner.nextInt()){
                case 1:
                    //choose rank
                case 2:
                    //choose role
                case 3:
                    //input name
                default:
            }
        }
        return 0;
    }
}
