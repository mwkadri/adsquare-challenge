package com.adsquare.example.calculation.boundary;

import com.adsquare.example.calculation.entity.Result;
import com.adsquare.example.reader.FileParser;

import java.io.IOException;

public interface NumChecker {
    Result getLargestTwoNumbersAggregateGateway(FileParser parser) throws IOException;
}
