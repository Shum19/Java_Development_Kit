package ru.geekbrains.third.hw;
/*
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(), multiply(),
divide(), subtract(). Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
 */
public class Calculator {
    public static <T extends Number > double sum(T num1, T num2){
        return num1.doubleValue() + num2.doubleValue();
    }
    public static <T extends Number> double multiply(T num1, T num2){
        return num1.doubleValue() * num2.doubleValue();}
    public static <T extends Number> double subtract(T num1, T num2){
        return num1.doubleValue() - num2.doubleValue();}
    public static <T extends Number> double divide(T num1, T num2){
        if(num2.doubleValue() == 0 ){
            throw new RuntimeException("Deviding by ZERO is not allowed");
        }
        return num1.doubleValue() / num2.doubleValue();}
}
