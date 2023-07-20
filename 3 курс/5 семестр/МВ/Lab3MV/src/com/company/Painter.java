package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.File;
import java.io.IOException;

import static org.jfree.chart.ChartUtilities.saveChartAsJPEG;

class Painter {

    static int index = 34;

    public static void drawLogarithmicGraphics(int[] numbers, double[][]differences, String[] graphicNames,String title){
        XYSeriesCollection dataSet = new XYSeriesCollection();
        for(int i =0;i< differences.length;i++){
            final XYSeries series = new XYSeries(graphicNames[i], false, true);
            for(int j = 0;j<numbers.length;j++){
                if(differences[i].length == j)
                    break;
                series.add(numbers[j], differences[i][j]);
            }
            dataSet.addSeries(series);
        }

        JFreeChart lineChart = ChartFactory.createXYLineChart(title, "Number of iteration",
                "Norm of difference",
                dataSet, PlotOrientation.VERTICAL, true, true, false);
        var plot = lineChart.getXYPlot();
        XYSplineRenderer r1 = new XYSplineRenderer();
        r1.setPrecision(8);
        r1.setSeriesShapesVisible(0, false);
        final NumberAxis rangeAxis = new LogarithmicAxis("Norm of difference (Log)");
        plot.setRangeAxis(rangeAxis);
        plot.setRenderer(r1);
        int width = 1920;    /* Width of the image */
        int height = 1080;   /* Height of the image */
        File jFreeChart = new File(String.format("LineChart%s.jpeg", index));
        index++;
        try {
            saveChartAsJPEG(jFreeChart, lineChart, width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void drawSimpleGraphics(int[] numbers, double[][]differences, String[] graphicNames,String title){
        XYSeriesCollection dataSet = new XYSeriesCollection();
        for(int i =0;i< differences.length;i++){
            final XYSeries series = new XYSeries(graphicNames[i], false, true);
            for(int j = 0;j<numbers.length;j++){
                if(differences[i].length == j)
                    break;
                series.add(numbers[j], differences[i][j]);
            }
            dataSet.addSeries(series);
        }

        JFreeChart lineChart = ChartFactory.createXYLineChart(title, "Number of iteration",
                "Value of functions",
                dataSet, PlotOrientation.VERTICAL, true, true, false);
        XYSplineRenderer r1 = new XYSplineRenderer();
        r1.setPrecision(8);
        r1.setSeriesShapesVisible(0, false);
        int width = 1920;
        int height = 1080;
        File jFreeChart = new File(String.format("LineChart%s.jpeg", index));
        index++;
        try {
            saveChartAsJPEG(jFreeChart, lineChart, width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
