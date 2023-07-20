package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class SecondMain {

    public static void main(String[]args) throws IOException {
        var lines = Files.readAllLines(Path.of("C:\\Users\\home\\Desktop\\Lab3MV\\newton_x0=[4.0, 2.0, 4.0]"));
        ArrayList<Double>bisectionResults = new ArrayList<>();
        for(var line:lines){
            var divided = line.split(";");
            bisectionResults.add(Double.parseDouble(divided[1]));
        }

        int max = bisectionResults.size();
        int[]iterations = IntStream.range(1,max).toArray();
        double[]bisection = bisectionResults.stream().mapToDouble(Double::doubleValue).toArray();
        Painter.drawLogarithmicGraphics(iterations,new double[][]{bisection},
                new String[]{"newtonMethod"},"Root = -1.594101307355829, 1.802478273690257, -1.7916230336655723");
    }
}

