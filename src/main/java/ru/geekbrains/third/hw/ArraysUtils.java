package ru.geekbrains.third.hw;

public class ArraysUtils <T>{
    public static <T> boolean compereArrays(T [] firstArr, T [] secondArr){
        if(firstArr.length != secondArr.length){
            return false;
        }
        if(firstArr.getClass().getSimpleName() != secondArr.getClass().getSimpleName()){
            return false;
        }
        for (int i = 0; i < firstArr.length; i++) {
            if(!firstArr[i].equals(secondArr[i])){
                return false;
            }
        }
        return true;}
}
