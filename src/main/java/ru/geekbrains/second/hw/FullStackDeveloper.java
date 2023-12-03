package ru.geekbrains.second.hw;

public class FullStackDeveloper extends Developer implements IFullStackDeveloper{
    @Override
    public void developBackend() {
        System.out.println("Now My position is Backend");
    }

    @Override
    public void developGUI() {
        System.out.println("Now My position is Frontend");

    }
}
