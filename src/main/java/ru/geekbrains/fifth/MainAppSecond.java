package ru.geekbrains.fifth;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/*
В рамках выполнения задачи необходимо:
● 3 бегуна должны прийти к старту гонки
● Программа должна гарантировать, что гонка начнется только когда все три участника будут на старте
● Программа должна отсчитать “На старт”, “Внимание”, “Марш”
● Программа должна завершиться когда все участники закончат гонку.
● Подумайте об использовании примитива синхронизации
 */
public class MainAppSecond {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch allStart = new CountDownLatch(3);
        CountDownLatch startRace = new CountDownLatch(1);
        Thread runnerFirst = new Thread(new Runner(allStart, startRace));
        Thread runnerSecond = new Thread(new Runner(allStart, startRace));
        Thread runnerThird = new Thread(new Runner(allStart, startRace));
        runnerFirst.start();
        runnerSecond.start();
        runnerThird.start();
        System.out.println("Waiting for runners..");
        allStart.await();
        System.out.println("Ready, Steady, Go.....! ");
        startRace.countDown();
        runnerFirst.join();
        runnerSecond.join();
        runnerThird.join();
        System.out.println("Race is Finished");
    }
    public static class Runner implements Runnable{
        CountDownLatch readyToStart;
        CountDownLatch raceStart;
        public Runner (CountDownLatch readyToStart, CountDownLatch raceStart){
            this.raceStart = raceStart;
            this.readyToStart = readyToStart;

        }
        @Override
        public void run() {
            System.out.println("Coming to start..." + Thread.currentThread().getName());
            try {
                Thread.sleep(new Random().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                throw new RuntimeException("Wrong");
            }
            readyToStart.countDown();
            try {
                raceStart.await();
            } catch (InterruptedException e) {
                throw new RuntimeException("Await wrong");
            }
            System.out.println("Running " + Thread.currentThread().getName());
            try {
                Thread.sleep(new Random().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("I am on finish " + Thread.currentThread().getName());
        }
    }
}
