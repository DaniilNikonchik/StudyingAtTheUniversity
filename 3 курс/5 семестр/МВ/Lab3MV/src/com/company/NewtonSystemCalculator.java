package com.company;

import com.company.calculators.MultiFunction;

import java.util.ArrayList;
import java.util.stream.DoubleStream;

public class NewtonSystemCalculator {

    protected final double PRECISION = 1E-10;
    protected ArrayList<Double> statistics;
    ArrayList<Double>functionXValuesStatistic;
    ArrayList<Double>functionYValuesStatistic;
    protected MultiFunction function;

    public NewtonSystemCalculator(MultiFunction function) {
        this.function = function;
    }

    public double[] calculate(DoubleInterval interval) {
        statistics = new ArrayList<>();
        functionXValuesStatistic = new ArrayList<>();
        functionYValuesStatistic = new ArrayList<>();
        double[] point = new double[]{interval.x1(), interval.y1()};
        double max;
        int iteration = 1;
        do {
            double[] functionValues = function.getFunctionResult(point);
            for (int i = 0; i < functionValues.length; i++)
                functionValues[i] = -functionValues[i];
            double[][] derivativeValues = function.getDerivativeFunctionResult(point);
            double[] differences = getSolvesOfSystem(derivativeValues, functionValues);
            for (int i = 0; i < differences.length; i++)
                point[i] += differences[i];
            double[] residual = function.getFunctionResult(point);
            functionXValuesStatistic.add(residual[0]);
            functionYValuesStatistic.add(residual[1]);
            max = Math.sqrt(DoubleStream.of(residual).map(a->Math.pow(a,2)).sum());
            if(max!=0)
                statistics.add(max);
            iteration++;
        } while (max > PRECISION && iteration<102);
        return point;
    }

    public ArrayList<Double> getStatistics() {
        return statistics;
    }

    public double[] getFunctionXValuesStatistic() {
        return functionXValuesStatistic.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public double[] getFunctionYValuesStatistic() {
        return functionYValuesStatistic.stream().mapToDouble(Double::doubleValue).toArray();
    }

    private double[] getSolvesOfSystem(double[][] A, double[] b) {
        double[] result = new double[b.length];
        for (int k = 0; k < A.length; k++) {
            for (int i = k + 1; i < A[0].length; i++) {
                double l = A[i][k] / A[k][k];
                for (int j = 0; j < A[0].length; j++) {
                    A[i][j] -= l * A[k][j];
                }
                b[i] -= l * b[k];
            }
        }
        for (int i = result.length - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < result.length; j++)
                sum += result[j] * A[i][j];
            result[i] = (b[i] - sum) / A[i][i];
        }
        return result;
    }
}
