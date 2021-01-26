package com.epam.jwd.core_final.menu;

import com.epam.jwd.core_final.util.UserInputUtil;

import java.util.Scanner;

public abstract class AbstractEntityMenu {

    public abstract String getAvailableOptions();

    public void printAvailableOptions(String availableOptions){
        System.out.println(availableOptions);
    };

    public abstract void handleUserInput(Scanner scanner);

    public void init(){
        printAvailableOptions(getAvailableOptions());
        handleUserInput(UserInputUtil.getUserInput());
    };
}
