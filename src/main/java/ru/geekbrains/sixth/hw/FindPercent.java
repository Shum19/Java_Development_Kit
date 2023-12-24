package ru.geekbrains.sixth.hw;

public class FindPercent {
    public static double findPercent(int total, int part){
        if (total == 0){
            System.out.println("Wrong argument");
            return -1;
        }else {
            double percent = part * 100 / total;
            return percent;
        }
    }
}
