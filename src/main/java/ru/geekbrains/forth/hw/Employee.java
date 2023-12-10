package ru.geekbrains.forth.hw;

public class Employee {
    private int tableNumber, experience;

    private String name, phoneNumber;


    public Employee(int tableNumber, String phoneNumber, int experience, String name) {
        this.tableNumber = tableNumber;
        this.experience = experience;
        this.name = name;
        this.phoneNumber = phoneNumber;

    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString(){
        return "Table Number: " + tableNumber +
                "; Name: " + name +
                "; Phone №: " + phoneNumber +
                "; Experience: " + experience + " year.";
    }
}
