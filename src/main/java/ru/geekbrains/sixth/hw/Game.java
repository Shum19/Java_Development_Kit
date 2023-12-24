package ru.geekbrains.sixth.hw;

import java.util.*;
import org.apache.commons.math3.*;
public class Game {
    private Door winDoor, lossDoor;
    private List <Door> doorList;
    private int playerChoice, quizmasterChoice,
                changeCount, noChangeCount,
                gameCount;
     public Game(Door winDoor, Door lossDoor){
         this.winDoor = winDoor;
         this.lossDoor = lossDoor;
         doorList = new ArrayList<>();
         doorList.add(this.winDoor);
         doorList.add(this.lossDoor);
         doorList.add(this.lossDoor);
         changeCount = 0;
         noChangeCount = 0;
         gameCount = 0;

     }
     private void shuffleDoors(){
         Collections.shuffle(this.doorList);
     }
     private void choosePlayerDoor(){
         playerChoice = new Random().nextInt(0, 3);
         System.out.println("Player's DOOR is number " + (playerChoice+1));
     }
     private void chooseQuizmasterDoor(){
         quizmasterChoice = new Random().nextInt(0, 3);
         if (quizmasterChoice == playerChoice ||
                 doorList.get(quizmasterChoice).getItemBehindDoor().equals(winDoor.getItemBehindDoor())){
             chooseQuizmasterDoor();
         } else {
             System.out.println("Quizmaster's  DOOR is number " + (quizmasterChoice + 1));

         }

     }
     public String getDoor(){
         return doorList.get(playerChoice).getItemBehindDoor();
     }
     private void secondPlayerChoice(){
         int leftDoor = 0;
         for (int i = 0; i < 3; i++) {
             if (i != playerChoice && i != quizmasterChoice){
                 leftDoor = i;
             }
         }
         System.out.println("Would you like to change your door " + (playerChoice + 1) + " into " + (leftDoor + 1));
         System.out.println("Type yes or no!");
         Scanner input = new Scanner(System.in);
         String secondChoice = input.nextLine();
         if (secondChoice.equalsIgnoreCase("yes")){
             playerChoice = leftDoor;
             System.out.println("You have changed your door into " + (leftDoor + 1));
             if(checkWin()){
                 System.out.println("You win");
                 changeCount++;
             }else {
                 System.out.println("You loose");
             }
         }else if (secondChoice.equalsIgnoreCase("no")){
             System.out.println("Your DOOR " + (playerChoice+1) + " hasn't been changed");
             if (checkWin()){
                 System.out.println("You win");
                 noChangeCount++;
             }else {
                 System.out.println("You loose");
             }
         }else {
             System.out.printf("You have mistyped %s\n", secondChoice);
             secondPlayerChoice();
         }
     }
    private void doorChoice(){
         shuffleDoors();
         choosePlayerDoor();
         chooseQuizmasterDoor();
         secondPlayerChoice();
         gameCount++;
    }
    private boolean checkWin(){
         if (doorList.get(playerChoice).getItemBehindDoor().equalsIgnoreCase(winDoor.getItemBehindDoor())){
             return true;
         }
         return false;
    }
    private void checkStatistic(){
         char percent  = '%';
        double percentageOfChangeWin = FindPercent.findPercent(gameCount, changeCount);
        double percentageOfNoChangeWin = FindPercent.findPercent(gameCount, noChangeCount);
        System.out.printf("Percent of wins without changing of door %s %s\n", percentageOfNoChangeWin, percent);
        System.out.printf("Percent of wins with changing of door %s %s\n", percentageOfChangeWin, percent);
    }
    public void playGame(){
         boolean flag = true;
         while (flag){
             System.out.print("------------------\n" +
                                "1. Play Game.\n" +
                                "2. Check Statistic\n" +
                                "3. Exit Game\n" +
                                "Type your choice here -> ");
             Scanner input = new Scanner(System.in);
             String play = input.nextLine();
             switch (play){
                 case "1":
                     doorChoice();
                     break;
                 case "2":
                     checkStatistic();
                     break;
                 case "3":
                     System.out.println();
                     flag = false;
             }
             System.out.println();
         }
    }

}
