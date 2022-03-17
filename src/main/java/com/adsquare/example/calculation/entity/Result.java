package com.adsquare.example.calculation.entity;

import java.util.ArrayList;
import java.util.Collection;

public class Result {
    private Integer maxNum;
    private Integer secondMaxNum;

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public Integer getSecondMaxNum() {
        return secondMaxNum;
    }

    public void setSecondMaxNum(Integer secondMaxNum) {
        this.secondMaxNum = secondMaxNum;
    }

    public Collection<Integer> toList() {
        Collection<Integer> largestNumbers= new ArrayList<>();
        if(getMaxNum()!= null){
            largestNumbers.add(getMaxNum());
        }
        if(getSecondMaxNum()!= null){
            largestNumbers.add(getSecondMaxNum());
        }

        return largestNumbers;
    }
}
