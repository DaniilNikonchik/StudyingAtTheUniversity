package com.company;

public class MyFunction implements Function{

    @Override
    public double getFunctionResult(double x) throws Exception{
        if(x == 1)
            throw new Exception("incorrect x");
        return ((x/2)+3*Math.cos(x))/(x-1);
    }

    @Override
    public double getDerivativeResult(double x) throws Exception {
        return ((0.5-3*Math.sin(x))*(x-1)-(x/2+3*Math.cos(x)))/Math.pow((x-1),2);
    }
}
