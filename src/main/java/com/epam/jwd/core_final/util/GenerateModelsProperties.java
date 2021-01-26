package com.epam.jwd.core_final.util;

import com.epam.jwd.core_final.domain.MissionResult;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateModelsProperties {

    public static LocalDate generateRandomLocalDate(){ //todo pass minday
        long minDay = LocalDate.of(2000, 1, 1).toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate;
    }

    public static LocalDate generateRandomLocalDate(long minDay, long maxDay){
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate;
    }

    public static Long generateRandomDistance(){
        long minDistance = 20000;
        long maxDistance = 500000;
        long randomDistance = ThreadLocalRandom.current().nextLong(minDistance, maxDistance);
        return randomDistance;
    }

    public static Long generateRandomDistance(long minDistance, long maxDistance){
        long randomDistance = ThreadLocalRandom.current().nextLong(minDistance, maxDistance);
        return randomDistance;
    }

    public static MissionResult chooseRandomMissionResult(){
        int missionPosition = new Random().nextInt(MissionResult.values().length);
        return MissionResult.values()[missionPosition];
    }

}
