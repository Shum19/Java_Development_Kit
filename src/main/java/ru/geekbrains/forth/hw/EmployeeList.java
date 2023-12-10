package ru.geekbrains.forth.hw;

import java.util.ArrayList;

public class EmployeeList {
    private ArrayList<Employee> employees;
    public EmployeeList(){
        this.employees = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        int tableNumber = employee.getTableNumber();
        if(!isContainTableNumber(tableNumber)){
            employees.add(employee);
        }else {
            String name = searchEmployeeByTableNum(tableNumber).getName();
            throw new RuntimeException("Table number is unique. This Table Number is occupied by " + name);
        }

    }
//  Добавить метод, который ищет сотрудника по стажу (может быть список)
    public ArrayList<Employee> searchEmployeeByExperienc(int experience){
        ArrayList foundList = new ArrayList<>();
        for (Employee employee: this.employees) {
            if (employee.getExperience() == experience){
                foundList.add(employee);
            }
        }
        return foundList;
    }
//  Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
    public ArrayList<String> searchEmployeeByPhoneNumber(String name){
        ArrayList<String> phoneNumberNames = new ArrayList<>();
        String nameStr = "Name: ";
        String phoneNum = ", Phone: ";
        for (Employee employee: this.employees) {
            if (name.equals(employee.getName())){
                phoneNumberNames.add(nameStr + employee.getName() + phoneNum + employee.getPhoneNumber());
            }
        }
        return phoneNumberNames;
    }
//  Добавить метод, который ищет сотрудника по табельному номеру
    public Employee searchEmployeeByTableNum(int tableNumber){
        int index = 0;
        for (int i = 0; i < this.employees.size(); i++) {
            if (employees.get(i).getTableNumber() == tableNumber){index = i;}
        }
        return this.employees.get(index);
    }
    private boolean isContainTableNumber(int tableNumber){
        for (Employee em:this.employees) {
            if (em.getTableNumber() == tableNumber){
                return true;
            }
        }
        return false;
    }




}
