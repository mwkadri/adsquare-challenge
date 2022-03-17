package com.adsquare.example.calculation.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;


public class ResultTest {
    @Test
    public void shouldReturnEmptyCollection() {
        Result result = new Result();
        Collection<Integer> resultCollection = result.toList();
        Assertions.assertTrue(resultCollection.isEmpty());
    }

    @Test
    public void shouldReturnCollectionWithMaxAndSecondMaxInteger() {
        Result result = new Result();
        result.setMaxNum(100);
        result.setSecondMaxNum(10);

        Collection<Integer> resultCollection = result.toList();
        Assertions.assertTrue(resultCollection.contains(100));
        Assertions.assertTrue(resultCollection.contains(10));
    }
}
