package ru.geekbrains.sixth.hw;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class GameMainApp {
    public static void main(String [] args){
        Door car = new Door("Car");
        Door goat = new Door("Goat");
        Game game = new Game(car, goat);
        game.playGame();
    }
}
