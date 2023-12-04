package ru.geekbrains.third;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator <T> implements Iterator {
    private int index = 0;
    private T [] array;
    public MyIterator(T [] array){
        this.array = array;
    }
    public void setArray(T[] array){
        this.array = array;
    }
    @Override
    public boolean hasNext() {
        return index < this.array.length;
    }

    @Override
    public T next() {
        return this.array[index++];
    }
}
