package com.adsquare.example.calculation.control;

import com.adsquare.example.calculation.entity.Result;
import com.adsquare.example.reader.FileParser;
import com.adsquare.example.reader.FileParserMock;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class NumCheckerCtrlTest {
    Result result;
    FileParser fileParser;

    Collection<Integer> firstChunk;
    Collection<Integer> secondChunk;
    Collection<Integer> thirdChunk;
    ArrayList<Collection<Integer>> chunks;

    @BeforeEach
    public void setUp() {
        result = new Result();

        firstChunk = new ArrayList<>();
        secondChunk = new ArrayList<>();
        thirdChunk = new ArrayList<>();
        chunks = new ArrayList<>();

        fileParser = new FileParserMock(chunks);
    }

    @Nested
    @DisplayName("Passing Scenarios ")
    class CalculateLargestTwoNumbersAggregatePassing {
        @Test
        public void shouldReturnLargestTwoNumbersPositiveAggregate() throws IOException {
            firstChunk.add(10);
            firstChunk.add(100);
            firstChunk.add(1000);

            secondChunk.add(20);
            secondChunk.add(20);
            secondChunk.add(200);

            thirdChunk.add(3);
            thirdChunk.add(30);
            thirdChunk.add(300);

            chunks.add(firstChunk);
            chunks.add(secondChunk);
            chunks.add(thirdChunk);

            result = NumCheckerCtrl.getLargestTwoNumbersAggregate(fileParser);
            Assertions.assertEquals(1000, result.getMaxNum());
            Assertions.assertEquals(300, result.getSecondMaxNum());
        }

        @Test
        public void shouldReturnLargestTwoNumbersNegativeAggregate() throws IOException {
            firstChunk.add(-10);
            firstChunk.add(-100);
            firstChunk.add(-1000);

            secondChunk.add(-20);
            secondChunk.add(-20);
            secondChunk.add(-200);

            thirdChunk.add(-3);
            thirdChunk.add(-30);
            thirdChunk.add(-300);

            chunks.add(firstChunk);
            chunks.add(secondChunk);
            chunks.add(thirdChunk);

            result = NumCheckerCtrl.getLargestTwoNumbersAggregate(fileParser);
            Assertions.assertEquals(-3, result.getMaxNum());
            Assertions.assertEquals(-10, result.getSecondMaxNum());
        }

        @Test
        public void shouldReturnLargestTwoNegativeAndPositiveNumbersAggregate() throws IOException {
            firstChunk.add(-10);
            firstChunk.add(100);
            firstChunk.add(-1000);

            secondChunk.add(-20);
            secondChunk.add(0);
            secondChunk.add(-200);

            thirdChunk.add(-3);
            thirdChunk.add(-30);
            thirdChunk.add(-300);

            chunks.add(firstChunk);
            chunks.add(secondChunk);
            chunks.add(thirdChunk);

            result = NumCheckerCtrl.getLargestTwoNumbersAggregate(fileParser);
            Assertions.assertEquals(100, result.getMaxNum());
            Assertions.assertEquals(0, result.getSecondMaxNum());
        }

        @Test
        public void shouldReturnLargestTwoNumbersZerosAggregate() throws IOException {
            firstChunk.add(0);
            firstChunk.add(0);
            firstChunk.add(0);

            secondChunk.add(0);
            secondChunk.add(0);
            secondChunk.add(0);

            thirdChunk.add(0);
            thirdChunk.add(0);
            thirdChunk.add(0);

            chunks.add(firstChunk);
            chunks.add(secondChunk);
            chunks.add(thirdChunk);

            result = NumCheckerCtrl.getLargestTwoNumbersAggregate(fileParser);
            Assertions.assertEquals(0, result.getMaxNum());
            Assertions.assertEquals(0, result.getSecondMaxNum());
        }

        @Test
        public void shouldHandleEmptyChunk() throws IOException {
            firstChunk.add(10);
            firstChunk.add(20);
            firstChunk.add(100);

            secondChunk.add(3);
            secondChunk.add(30);
            secondChunk.add(300);

            chunks.add(firstChunk);
            chunks.add(secondChunk);
            chunks.add(thirdChunk);

            result = NumCheckerCtrl.getLargestTwoNumbersAggregate(fileParser);
            Assertions.assertEquals(300, result.getMaxNum());
            Assertions.assertEquals(100, result.getSecondMaxNum());
        }
    }

}
