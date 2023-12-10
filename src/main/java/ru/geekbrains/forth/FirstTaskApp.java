package ru.geekbrains.forth;

import ru.geekbrains.third.hw.ArraysUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
В рамках выполнения задачи необходимо:
● Создайте коллекцию мужских и женских имен с помощью интерфейса List
● Отсортируйте коллекцию в алфавитном порядке
● Отсортируйте коллекцию по количеству букв в слове
● Разверните коллекцию
 */
public class FirstTaskApp {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Alexander");
        names.add("Michele");
        names.add("Maria");
        names.add("Nikolas");
        names.add("Helena");
        names.add("Oleg");
        names.add("Micheal");
//        Alphabetic Sort
        System.out.println("Alphabetic Sort:");
        System.out.println(names);
        Collections.sort(names);
        System.out.println(names);
//        Length Sort
        System.out.println("Length Sort:");
        System.out.println(names);
        names.sort((s1, s2) -> s1.length() - s2.length());
        System.out.println(names);
        names.sort(Comparator.comparing(String::length));
        System.out.println(names);
//        Reverse Order
        System.out.println("Reversed Order:  ");
        Collections.sort(names);
        System.out.println(names);
        Collections.reverse(names);
        System.out.println(names);

    }
}