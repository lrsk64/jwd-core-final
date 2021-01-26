package com.epam.jwd.core_final.context.impl;

public class MenuText {

    public static final String DIVIDE_LINE = "--------------------------------\n";

    private static final String INPUT_SUGGESTION_TEXT = "Enter the number appropriate to the available option\n";

    private static final String AVAILABLE_GENERAL_OPTIONS_TEXT =
            "\nWhat entity do you want work with?: \n" +
            INPUT_SUGGESTION_TEXT +
            DIVIDE_LINE +
            "1 - crew members\n" +
            "2 - spaceships\n" +
            "3 - flight missions\n" +
            "0 - to quit program\n" +
            DIVIDE_LINE;

    private static final String AVAILABLE_ENTITY_OPTIONS_TEXT =
            "Available options:\n" +
            INPUT_SUGGESTION_TEXT +
            DIVIDE_LINE +
            "1 - view all\n" +
            "2 - find all by criteria\n" +
            "3 - find one by criteria" +
            "4 - create\n" +
            "5 - update\n" +
            //"6 - return to previous menu\n" +
            "0 - to quit program\n";


    private static final String END_OF_PROGRAM_TEXT = "Goodbye!";

    private static final String WRONG_INPUT_TEXT = "Wrong input.";


    public static String getAvailableGeneralOptionsText() {
        return AVAILABLE_GENERAL_OPTIONS_TEXT;
    }

    public static String getAvailableEntityOptionsText() {
        return AVAILABLE_ENTITY_OPTIONS_TEXT;
    }

    public static String getEndOfProgramText() {
        return END_OF_PROGRAM_TEXT;
    }

    public static String getWrongInputText() {
        return WRONG_INPUT_TEXT;
    }


    public static String getDivideLine() {
        return DIVIDE_LINE;
    }

    public static String getInputSuggestionText() {
        return INPUT_SUGGESTION_TEXT;
    }

}
