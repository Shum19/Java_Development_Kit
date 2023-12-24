package ru.geekbrains.sixth;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import java.util.Random;

public class MainApp {
    public static void main (String [] args){

        double [] arr = new double[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new Random().nextInt(0, 100);
        }
        for (double num: arr) {
            System.out.print(num + "  ");
        }
        double myMeanCount = 0;
        for (int i = 0; i < arr.length; i++) {
            myMeanCount += arr[i];
        }
        myMeanCount = myMeanCount / arr.length;
        System.out.println();
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(arr);
        System.out.println("Max value: " + descriptiveStatistics.getMax());
        System.out.println("Min value: " + descriptiveStatistics.getMin());
        System.out.println("My Mean value: " + myMeanCount);
        System.out.println("Average value: " + descriptiveStatistics.getMean());
        System.out.println("Sum value: " + descriptiveStatistics.getSum());
        System.out.println("Factorial: " + ArithmeticUtils.factorial(5));
        System.out.println(ArithmeticUtils.lcm(2, 4));
        System.out.println(ArithmeticUtils.gcd(2, 4));
        System.out.println(ArithmeticUtils.isPowerOfTwo(8));

    }
}
