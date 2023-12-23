package ru.geekbrains.fifth.hw;

public class Philosopher extends Thread{
    String name;
    int quantityOfMeal;
    private final Object monitor;
    private final int maxMeals = 3;
    private boolean isHungry;

    public Philosopher (String name){
        this.name = name;
        quantityOfMeal = 0;
        this.monitor = Philosopher.class;
        isHungry = true;
    }
    private void havingMeal(int time){
        if (quantityOfMeal < maxMeals) {
            System.out.printf("I am %s and I am going to eat! Wait for me %s sek", this.name, time);
            System.out.println();
            for (int i = 1; i < time + 1; i++) {
                System.out.printf("%ss ", i);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Meal Error");
                }
            }
            System.out.println();
            quantityOfMeal++;
            int leftQuant = maxMeals - quantityOfMeal;
            System.out.printf("%s has done! %s can have %s meal(s) more\n", name, name, leftQuant);
        }else if (quantityOfMeal >= maxMeals){
            System.out.println(name + " can't eat any more!");
            isHungry = false;
        }
    }
    private void think(){
//        synchronized (monitor){
            if (isHungry) {
                System.out.println(name + " is thinking. Don't disturb!");
//                monitor.notify();
//                try {
//                    monitor.wait();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }else {
//                monitor.notify();
            }
//        }
    }
    @Override
    public void run(){
        while (isHungry){
//            synchronized (monitor){
                this.havingMeal(1);
//            }
            this.think();
        }
    }
}
