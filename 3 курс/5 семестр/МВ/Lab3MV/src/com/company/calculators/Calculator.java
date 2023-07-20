package com.company.calculators;

import com.company.Function;
import com.company.Interval;

import java.util.ArrayList;

public abstract class Calculator {
    protected final double PRECISION = 1E-12;

    protected ArrayList<Double> statistics;

    protected Function function;

    protected double a,b;

    public Calculator(Function function){
        this.function = function;
    }

    public double calculate(Interval interval) throws Exception {
        a = interval.a();
        b = interval.b();
        statistics = new ArrayList<>();
        double x = interval.a();
        double functionFromA = function.getFunctionResult(a);
        double functionFromB = function.getFunctionResult(b);
        if(functionFromA*functionFromB>=0)
            throw new Exception("incorrect interval");
        int iteration = 1;
        double functionFromX = function.getFunctionResult(x);
        while(Math.abs(functionFromX)>PRECISION && iteration<100){
            statistics.add(Math.abs(functionFromX));
            iteration++;
            x = getNextApproximation(x);
            functionFromX = function.getFunctionResult(x);
        }
        statistics.add(Math.abs(functionFromX));
        return x;
    }

    protected abstract double getNextApproximation(double x) throws Exception;

    public Double[] getStatistic(){
        return statistics.toArray(Double[]::new);
    }
}
