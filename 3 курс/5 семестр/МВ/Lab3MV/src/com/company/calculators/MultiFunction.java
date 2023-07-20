package com.company.calculators;

public class MultiFunction {
    double c;

    public MultiFunction(double parameter){
        this.c = parameter;
    }

    public double[]getFunctionResult(double[]points){
        double[]result = new double[points.length];
        result[0] = Math.pow(points[0]-c,2)+Math.pow(points[1],2)-1;
        result[1] = Math.pow(points[0],2)+Math.pow(points[1]-c,2)-100;
        return result;
    }

    public double[][]getDerivativeFunctionResult(double[]points){
        double[][]result = new double[points.length][points.length];
        result[0][0] = 2*(points[0]-c);
        result[0][1] = 2*points[1];
        result[1][0] = 2*points[0];
        result[1][1] = 2*(points[1]-c);
        return result;
    }
}
