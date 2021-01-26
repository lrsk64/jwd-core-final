package com.epam.jwd.core_final.context.impl;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.context.ApplicationMenu;
import com.epam.jwd.core_final.menu.impl.CrewMemberMenu;
import com.epam.jwd.core_final.util.UserInputUtil;

import java.util.Scanner;


public class NasaMenu implements ApplicationMenu {

    private static NasaMenu instance;

    private static final String AVAILABLE_GENERAL_OPTIONS_TEXT = MenuText.getAvailableGeneralOptionsText();


    private NasaMenu() {
    }

    public static NasaMenu getInstance(){
        if (instance == null){
            instance = new NasaMenu();
        }

        return instance;
    }


    @Override
    public ApplicationContext getApplicationContext() {
        return NasaContext.getInstance();
    }


    @Override
    public void printAvailableOptions() {
        System.out.println(AVAILABLE_GENERAL_OPTIONS_TEXT);
    }

    @Override
    public void handleUserInput(Scanner scanner) {
        if (scanner.hasNextInt()){
            switch (scanner.nextInt()){
                case 0:
                    System.out.println(MenuText.getEndOfProgramText());
                    System.exit(0);
                case 1:
                    CrewMemberMenu.getInstance().init();
                    break;
                case 2:
                    //return SpaceshipsMenu;уже
                case 3:
                    //return FlightMissionsMenu;
                default:
                    System.out.println(MenuText.getWrongInputText());
                    printAvailableOptions();
            }
        } else{
            System.out.println(MenuText.getWrongInputText());
            System.out.println(MenuText.getInputSuggestionText());
        }

    }

    public void init(){
        printAvailableOptions();
        handleUserInput(UserInputUtil.getUserInput());
    }

//    private void generalOptionsInput(int chosenOption){
//        switch (chosenOption){
//            case 0:
//                System.out.println(MenuText.getEndOfProgramText());
//                break;
//            case 1:
//                System.out.println("Chosen entity: Crew member\n" +
//                        MenuText.getAvailableEntityOptionsText());
//                //scan user input
//                //handle user input - entityOptionsInputHandle
//                break;
//            case 2:
//                System.out.println("Chosen entity: Spaceship\n" +
//                        MenuText.getAvailableEntityOptionsText());
//                break;
//            case 3:
//                System.out.println("Chosen entity: Flight mission\n" +
//                        MenuText.getAvailableEntityOptionsText());
//                break;
//        }
//    }
//
//    private void crewMemberOptionsInputHandle(int chosenOptions){
//        switch (chosenOptions){
//            case 0:
//                System.out.println(MenuText.getEndOfProgramText());
//                break;
//            case 1:
//                System.out.println(SimpleCrewService.getInstance().findAllCrewMembers());
//            case 2:
//            case 3:
//            case 4:
//            case 5:
//            case 6:
//                printAvailableOptions();
//                break;
//        }
//    }
//
//    private CrewMemberCriteria createCrewMemberCriteriaByUserInput(){
//        Scanner scanner = new Scanner(System.in);
//        CrewMemberCriteria crewMemberCriteria = new CrewMemberCriteria();
//
//        while(true){
//            System.out.println("Input crew member name to find (format - Name Surname): ");
//            if (scanner.nextLine().matches("[a-zA-Z]+\\s[a-zA-Z]+")){
//                crewMemberCriteria.setName(scanner.nextLine());
//                break;
//            } else{
//                System.out.println("Wrong input");
//            }
//        }
//
//        return null;
//
//    }
//
//
//    private void userInputRank(CrewMemberCriteria crewMemberCriteria){ //todo rename method
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Choose crew member rank:\n");
//
//        for (Rank rank : Rank.values()){
//            System.out.println(rank.getId().toString() + " - " + rank);
//        }
//
//        try{
//            Long rankId = scanner.nextLong();
//            if (rankId <= Rank.values().length){
//                crewMemberCriteria.setRankId(rankId);
//            }
//        } catch (InputMismatchException e){
//            System.out.println(MenuText.getWrongInputText());
//            if (confirmChoice()){
//                userInputRank(crewMemberCriteria);
//            }
//        }
//    }
//
//
//
//    private void userInputRole(CrewMemberCriteria crewMemberCriteria){ //todo rename method
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Choose crew member role:\n");
//
//        for (Role role : Role.values()){
//            System.out.println(role.getId().toString() + " - " + role);
//        }
//
//        try{
//            Long roleId = scanner.nextLong();
//            if (roleId <= Role.values().length){
//                crewMemberCriteria.setRoleId(roleId);
//            }
//        } catch (InputMismatchException e){
//            System.out.println(MenuText.getWrongInputText());
//            if (confirmChoice()){
//                userInputRole(crewMemberCriteria);
//            }
//        }
//    }
//
//    private boolean confirmChoice(){ //todo rename method
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println(MenuText.getSuggestionToReenter());
//        switch (scanner.nextLine().toLowerCase()){
//            case "y":
//                return true;
//            default:
//                return false;
//        }
//    }
}