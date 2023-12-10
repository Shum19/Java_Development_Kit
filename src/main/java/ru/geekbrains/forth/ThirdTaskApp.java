package ru.geekbrains.forth;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
В рамках выполнения задачи необходимо:
● Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
● Найдите человека с самым маленьким номером телефона
● Найдите номер телефона человека чье имя самое большое в алфавитном порядке
 */
public class ThirdTaskApp {
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();
        String [] names = { "Alexander", "Michele", "Maria", "Nikolas", "Michele", "Alexandria"};
        String [] phoneNumbers = {"89234561122", "12349562211", "32345673311", "45643454433", "11110001122",
                                    "11101001122"};
        for (int i = 0; i < names.length; i++) {
            phoneBook.put(phoneNumbers[i], names[i]);
        }
        System.out.println(phoneBook);
//      Sorted Map by key and first element is taken; as String is sorted as Iinteger because they have the same
//      encoding table and the first element is the least number.
        String minKey = phoneBook.keySet().stream().sorted().findFirst().get();
        System.out.println(minKey);
//
        String maxName = phoneBook.values().stream().sorted().max((s1, s2)-> s1.length()-s2.length()).get();
        System.out.println(phoneBook.entrySet().stream().filter((e)->e.getValue().equals(maxName)).findAny().get());

    }
}
