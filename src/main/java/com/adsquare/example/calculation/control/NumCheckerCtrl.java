package com.adsquare.example.calculation.control;

import com.adsquare.example.calculation.entity.Result;
import com.adsquare.example.reader.FileParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class NumCheckerCtrl {
    public static Result getLargestTwoNumbersAggregate(FileParser parser) throws IOException {
        Result currentChunkResult = null;

        while(true){
            Collection<Integer> processedChunk = parser.getNextChunk();
            if(processedChunk.isEmpty()){
                break;
            }
            Result newChunkResult = findMaxTwoIntegers(processedChunk);

            if(currentChunkResult == null){
                currentChunkResult = newChunkResult;
            } else {
                currentChunkResult = getLargestNumberFromTwoChunks(currentChunkResult, newChunkResult);
            }
        }
        return currentChunkResult;
    }

    private static Result getLargestNumberFromTwoChunks(Result oldChunkResult, Result newChunkResult) {
        if(oldChunkResult == null){
            return newChunkResult;
        } else if(newChunkResult == null){
            return oldChunkResult;
        }

        Collection<Integer> resultAggregator = new ArrayList<>(
                oldChunkResult.toList());

        resultAggregator.addAll(newChunkResult.toList());

        return findMaxTwoIntegers(resultAggregator);
    }

    private static Result findMaxTwoIntegers(Collection<Integer> numInput) {
        if(numInput.isEmpty()){
            return null;
        }

        if(numInput.size() == 1){
            Result result = new Result();
            result.setMaxNum(numInput.iterator().next());
            return result;
        }

        int biggestInt = Integer.MIN_VALUE;
        int secondBiggestInt = Integer.MIN_VALUE;

        for (int number : numInput) {
            if (number > biggestInt) {
                secondBiggestInt = biggestInt;
                biggestInt = number;
            } else if (number > secondBiggestInt) {
                secondBiggestInt = number;
            }
        }

        Result result = new Result();
        result.setMaxNum(biggestInt);
        result.setSecondMaxNum(secondBiggestInt);
        return result;
    }
}
