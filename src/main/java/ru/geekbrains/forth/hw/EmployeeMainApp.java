package ru.geekbrains.forth.hw;

public class EmployeeMainApp {
    public static void main(String[] args) {
        Employee first = new Employee(101, "89991112233", 3, "Maria");
        Employee second = new Employee(33, "89992222233", 5, "Jack");
        Employee third = new Employee(99, "89990002233", 3, "Jack");
        Employee forth = new Employee(150, "89993332233", 1, "Alexander");
        Employee fifth = new Employee(33, "89994442255", 1, "Alexanderia");
        EmployeeList employeeList = new EmployeeList();
        employeeList.addEmployee(first);
        employeeList.addEmployee(second);
        employeeList.addEmployee(third);
        employeeList.addEmployee(forth);
        System.out.println(employeeList.searchEmployeeByExperienc(3));
        System.out.println(employeeList.searchEmployeeByPhoneNumber("Jack"));
        System.out.println(employeeList.searchEmployeeByTableNum(33));
        employeeList.addEmployee(fifth);

    }

}
