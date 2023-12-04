package ru.geekbrains.third.hw;

public class ArraysMainApp {
    public static void main(String[] args) {
        Character [] firstArr = {'q', 'w', 'e', 'r'};
        Character [] secondArr = {'q', 'w', 'e', 'r'};
        Character [] thirdArr = {'Q', 'w', 'e', 'R'};
        Character [] fifthArr = {'q', 'w', 'e'};

        Integer [] sixArr = {1, 2, 3, 4};
        System.out.println(ArraysUtils.compereArrays(firstArr, secondArr));
        System.out.println(ArraysUtils.compereArrays(firstArr, thirdArr));
        System.out.println(ArraysUtils.compereArrays(firstArr, fifthArr));
        System.out.println(ArraysUtils.compereArrays(firstArr, sixArr));
    }
}
