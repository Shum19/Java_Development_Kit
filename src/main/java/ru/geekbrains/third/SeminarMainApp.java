package ru.geekbrains.third;

import java.io.DataInputStream;

public class SeminarMainApp {
    public static void main(String[] args) {
//      Task 1
        String str = "String";
        DataInputStream dataInput = new DataInputStream(System.in);
        Integer num = 5;
        MyClass myClass = new MyClass(str,dataInput, num);
        myClass.printClass();

//      Task 2
        MyList <String> myList = new MyList<>(5);
        System.out.println();
        myList.add("Hello");
        myList.add("Word");
        myList.add("My_List");
        myList.print();
        myList.deleteElement(0);
        System.out.println();
        myList.print();
        System.out.println( );
//      Task 3
        String [] arr = {"Hello", "Word", "My List"};
        MyIterator <String> myIterator = new MyIterator<>(arr);
        for (String el: arr) {
            System.out.println(el);
        }

    }
}
