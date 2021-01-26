package com.epam.jwd.core_final.factory.impl;

import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.factory.EntityFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// do the same for other entities
public class CrewMemberFactory implements EntityFactory<CrewMember> {

    private static Logger LOGGER = LoggerFactory.getLogger(CrewMemberFactory.class);

    private static CrewMemberFactory instance;

    private CrewMemberFactory() {
    }

    public static CrewMemberFactory getInstance(){
        if(instance == null){
            instance = new CrewMemberFactory();
        }
        return instance;
    }

    @Override
    public CrewMember create(Object... args) throws NullPointerException{
        Object[] checkedArgs = checkArguments(args);
        try{
            return new CrewMember((Long) checkedArgs[0], (String) checkedArgs[1], (Long) checkedArgs[2]);
        } catch (NullPointerException e){
            throw new NullPointerException("Crew member was not create.");
        }
    }


    private boolean checkArgumentsAmount(Object[] args) throws IllegalArgumentException{
        if(args.length == 3){
            return true;
        } else{
            throw new IllegalArgumentException("Wrong amount of arguments"); // todo write message, change exception type
        }
    }

    private Object[] checkArguments(Object[] args) throws IllegalArgumentException{
        String name;
        Long rankId;
        Long roleId;

        checkArgumentsAmount(args);

        name = (String) args[1];

        try{
            roleId = Long.parseLong(String.valueOf(args[0]));
            rankId = Long.parseLong(String.valueOf(args[2]));

        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Wrong arguments type"); //проверить что именно выбрасывает исключение
        }

        return new Object[]{roleId, name, rankId};
    }
}
