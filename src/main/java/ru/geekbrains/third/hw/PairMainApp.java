package ru.geekbrains.third.hw;

public class PairMainApp {
    public static void main(String[] args) {
        Pair <String, Integer> pair = new Pair<>("Pair is ", 2);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
        System.out.println(pair.toString());

    }

}
