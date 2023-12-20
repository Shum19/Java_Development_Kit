package ru.geekbrains.fifth;
/*
В рамках выполнения задачи необходимо:
● Создайте два потока A и B.
● Поток A меняет значение Boolean переменной switcher с задержкой 1000 миллисекунд
  (true в состояние false и наоборот).
● Поток B ожидает состояния true переменной switcher и выводит на консоль обратный отсчет
  от 100 с задержкой 100 миллисекунд и приостанавливает свое действие, как только поток A
  переключит switcher в состояние false.
● Условием завершения работы потоков является достижение отсчета нулевой отметки.
● Можно воспользоваться синхронизацией для управления значения переменной или volatile
 */
public class MainAppTaskFirst {
    static boolean switcher = false;
    static int count = 100;
    public static void main(String[] args) throws InterruptedException {
        Thread switcherTread = new Thread(() -> {

            while (count > 0) {
                System.out.println();
                System.out.println(count);
                System.out.println(switcher + " first");
                switcher = !switcher;
                System.out.println(switcher + " second");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("Switcher Interrupted");
                }
            }
        });

        Thread countDown = new Thread(() -> {
            while (count > 0) {
//              цикл проверяет switcher каждую миллисекунду и если false то поток засыпает
                while (!switcher) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException("CountDown Interrupted");
                    }
                }
                if (switcher) {
                    System.out.printf("%s..", count);
                    count--;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException("CountDown Interrupted");
                    }
                }
                if (!switcher){
                    System.out.println("I am waiting for 5 sec");
                    for (int i = 1; i < 6  ; i++) {
                        System.out.printf("%s sec ", i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException("Happened");
                        }
                    }
                }
            }
        });
        switcherTread.start();
        countDown.start();
        switcherTread.join();
        countDown.join();



    }
}
