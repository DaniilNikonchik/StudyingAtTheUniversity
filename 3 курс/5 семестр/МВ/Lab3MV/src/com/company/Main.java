package com.company;

//import com.company.calculators.BisectionCalculator;
//import com.company.calculators.Calculator;
import com.company.calculators.MultiFunction;
//import com.company.calculators.NewtonCalculator;

import java.util.Arrays;
import java.util.stream.IntStream;

/*class CalculationsProcessor{
    double[]results;

    Double[][]statistics;

    Calculator calculator;

    public CalculationsProcessor(Calculator calculator){
        this.calculator = calculator;
    }

    public void calculate(Interval[]intervals) throws Exception {
        results = new double[intervals.length];
        statistics = new Double[results.length][0];
        for(int i = 0;i< results.length;i++){
            results[i] = calculator.calculate(intervals[i]);
            var localStatistic = calculator.getStatistic();
            statistics[i] = Arrays.copyOf(localStatistic,localStatistic.length);
        }
    }

    public double[] getPrecisionsWithIndex(int i){
        double[]result = new double[statistics[i].length];
        for(int j = 0;j<statistics[i].length;j++)
            result[j] = statistics[i][j];
        return result;
    }

    public int getIterationsNumberWithIndex(int i){
        return statistics[i].length;
    }
}*/

public class Main {

    static double[] parameters = new double[]{
            6.36396105,
            6.5,
    };

    static DoubleInterval[] systemIntervals = new DoubleInterval[]{
        new DoubleInterval(7,8,-0.5,-1),
        new DoubleInterval(7.4,7.6,0,-0.2),
        new DoubleInterval(6.6,6.8,-0.8,-1),
    };

    public static void calculateSystem(double parameter,DoubleInterval interval){
        NewtonSystemCalculator calculator = new NewtonSystemCalculator(new MultiFunction(parameter));
        var result = calculator.calculate(interval);
        var functionXValues = calculator.getFunctionXValuesStatistic();
        var functionYValues = calculator.getFunctionYValuesStatistic();
        var statistic = calculator.getStatistics();
        int[]iterations = IntStream.range(1,functionXValues.length).toArray();
        Painter.drawSimpleGraphics(iterations, new double[][]{functionXValues,functionYValues},
                new String[]{"X","Y"},
                "Root: (x,y) = ("+result[0]+","+result[1]+")");
        double[]curStatistic = statistic.stream().mapToDouble(Double::doubleValue).toArray();
        Painter.drawLogarithmicGraphics(iterations, new double[][]{curStatistic},new String[]{"Norm"},
                "Root: (x,y) = ("+result[0]+","+result[1]+")");
    }


    public static void main(String[] args) {
       /* CalculationsProcessor bisectionProcessor = new CalculationsProcessor(new BisectionCalculator(new MyFunction()));
        bisectionProcessor.calculate(bisectionIntervals);

        CalculationsProcessor newtonProcessor = new CalculationsProcessor(new NewtonCalculator(new MyFunction()));
        newtonProcessor.calculate(bisectionIntervals);

        for(int i = 0;i< bisectionIntervals.length;i++){
            double[][]precisions = new double[2][0];
            precisions[0] = bisectionProcessor.getPrecisionsWithIndex(i);
            precisions[1] = newtonProcessor.getPrecisionsWithIndex(i);
            int bisectionIterationsNumber = bisectionProcessor.getIterationsNumberWithIndex(i);
            int newtonIterationNumber = newtonProcessor.getIterationsNumberWithIndex(i);
            int max = Integer.max(bisectionIterationsNumber,newtonIterationNumber);
            int[]iterations = IntStream.range(1,max).toArray();
            Painter.drawLogarithmicGraphics(iterations,precisions,new String[]{"Bisection","Newton"},
                    "Root: "+bisectionProcessor.results[i]);
        }*/

        for(int i = 0;i< parameters.length;i++)
            calculateSystem(parameters[i],systemIntervals[i]);
        calculateSystem(parameters[parameters.length-1],systemIntervals[systemIntervals.length-1]);

    }
}
