package com.company.calculators;

import com.company.Function;

public class BisectionCalculator extends Calculator {

    public BisectionCalculator(Function function){
        super(function);
    }

    @Override
    protected double getNextApproximation(double x) throws Exception {
        if(function.getFunctionResult(a)*function.getFunctionResult(x)<0)
            b = x;
        else
            a = x;
        return (a+b)/2;
    }

}
