package com.adsquare.example.calculation.boundary;

import com.adsquare.example.calculation.control.NumCheckerCtrl;
import com.adsquare.example.calculation.entity.Result;
import com.adsquare.example.reader.FileParser;

import java.io.IOException;

public class NumCheckerImpl implements NumChecker{
    @Override
    public Result getLargestTwoNumbersAggregateGateway(FileParser parser) throws IOException {
        return NumCheckerCtrl.getLargestTwoNumbersAggregate(parser);
    }
}
