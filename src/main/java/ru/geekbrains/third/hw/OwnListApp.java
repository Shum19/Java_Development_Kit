package ru.geekbrains.third.hw;

public class OwnListApp {
    public static void main(String[] args) {
        OwnList <String> ownList = new OwnList<>(5);
        ownList.add("First");
        ownList.add("Second");
        ownList.add("Third");
        ownList.add("Forth");
        ownList.add("Fifth");
        ownList.print();
        ownList.deleteElement(0);
        ownList.print();

        for (String el : ownList) {
            if (el != null){
                System.out.println(el);
            }
        }
    }
}
