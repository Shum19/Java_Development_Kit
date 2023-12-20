package ru.geekbrains.fifth.hw;
/*
Задание 1. В качестве задачи предлагается решить классическую задачу про обедающих философов
Условие:
● Есть пять философов (потоки), которые могут либо обедать (выполнение кода) либо размышлять (ожидание).
● Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
● После каждого приема пищи философ должен размышлять
● Не должно возникнуть общей блокировки
● Философы не должны есть больше одного раза подряд

 */
public class MainHomeTaskApp {
    public static void main(String[] args) throws InterruptedException {
        Philosopher philosopherFirst = new Philosopher("Michael".toUpperCase());
        Philosopher philosopherSecond = new Philosopher("Nic".toUpperCase());
        Philosopher philosopherThird = new Philosopher("Leo".toUpperCase());
        Philosopher philosopherForth = new Philosopher("Grag".toUpperCase());
        Philosopher philosopherFifth = new Philosopher("Alex".toUpperCase());
        philosopherFirst.start();
        philosopherSecond.start();
        philosopherThird.start();
        philosopherForth.start();
        philosopherFifth.start();

    }
}
