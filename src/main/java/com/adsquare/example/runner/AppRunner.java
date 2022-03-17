package com.adsquare.example.runner;

import com.adsquare.example.calculation.boundary.NumChecker;
import com.adsquare.example.calculation.boundary.NumCheckerImpl;
import com.adsquare.example.calculation.entity.Result;
import com.adsquare.example.reader.FileParser;
import com.adsquare.example.reader.FileParserImpl;

import java.io.IOException;

public class AppRunner {
    public static void main (String [] args){
        try {
            //Load file
            FileParser parser = new FileParserImpl();
            parser.loadFile("src/main/resources/DemoFile.txt");

            //Find the Overall Largest Two Numbers
            Result result = null;
            NumChecker numChecker = new NumCheckerImpl();
            result = numChecker.getLargestTwoNumbersAggregateGateway(parser);

            //Result ==> Display only the Second Largest Number
            System.out.println("* Second Largest Number is: " + result.getSecondMaxNum());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
