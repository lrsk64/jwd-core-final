package com.epam.jwd.core_final.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RankTest {

    @Test
    public void resolveRankById_whenIdEqualsOne_thenReturnRankTrainee(){
        long rankId = 1L;
        Rank actualResult = Rank.resolveRankById(rankId);
        Rank expectedResult = Rank.TRAINEE;

        assertEquals(actualResult, expectedResult);
    }
}
