package ru.geekbrains.second.hw;

public class DevelopersMainApp {
    public static void main(String[] args) {
        FullStackDeveloper fullStackDeveloper = new FullStackDeveloper();
        fullStackDeveloper.developBackend();
        fullStackDeveloper.developGUI();
        Developer fullDep = new FullStackDeveloper();
        if (fullDep instanceof FullStackDeveloper){
            ((FullStackDeveloper) fullDep).developBackend();
        }

        Developer frontDep = new Frontend();
        if (frontDep instanceof Frontend){
            ((Frontend)frontDep).developGUI();
        }

    }
}
