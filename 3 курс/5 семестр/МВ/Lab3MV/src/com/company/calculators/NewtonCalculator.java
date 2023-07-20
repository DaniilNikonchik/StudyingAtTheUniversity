package com.company.calculators;

import com.company.Function;

public class NewtonCalculator extends Calculator {
    public NewtonCalculator(Function function) {
        super(function);
    }

    @Override
    protected double getNextApproximation(double x) throws Exception {
        return x-function.getFunctionResult(x)/function.getDerivativeResult(x);
    }
}
