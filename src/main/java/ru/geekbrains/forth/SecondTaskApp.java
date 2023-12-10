package ru.geekbrains.forth;

import java.util.*;

/*
В рамках выполнения задачи необходимо:
● Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения
● Получите уникальный список Set на основании List
● Определите наименьший элемент (алфавитный порядок)
● Определите наибольший элемент (по количеству букв в слове но в обратном порядке)
● Удалите все элементы содержащие букву ‘A’
 */
public class SecondTaskApp {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Michele");
        names.add("Alexander");
        names.add("Michele");
        names.add("Maria");
        names.add("Nikolas");
        names.add("Michele");
        names.add("Nikolas");
        names.add("Helena");
        names.add("Oleg");
        names.add("Oleg");
        names.add("Helena");
        names.add("Oleg");
        names.add("Micheal");
        for (String name:names) {
            String str = "\"" + name + "\"";
            System.out.printf("%s, ", str);
        }

        System.out.println();
//      Unique Set
        Set<String> setNames = new HashSet<>(names);
        System.out.println("Unique Set:");
        System.out.println(names);
        System.out.println(setNames);
//      The least Alphabetic element Of List
        Collections.sort(names);
        System.out.println(names.get(0));
//      The Maximum reversed element of Set
        System.out.println("The Maximum reversed element of Set:");
        String maxReverseElement = setNames.stream().max(Comparator.comparingInt(String::length)).get().toString();
        System.out.println(new StringBuilder(maxReverseElement).reverse());
//      Delete all Names with "A"
        System.out.println("Delete all Names with \"A\": ");
        System.out.println(names  );
        names.removeIf(name -> name.contains("a"));
//      Second Way
        Iterator<String> iter = names.iterator();
        while (iter.hasNext()){
            String currentName = iter.next();
            if(currentName.contains("A") || currentName.contains("a")){
                iter.remove();
            }
        }
        System.out.println(names);






    }
}
