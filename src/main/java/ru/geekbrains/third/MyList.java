package ru.geekbrains.third;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/*
Описать собственную коллекцию – список на основе массива. Коллекция должна иметь возможность
хранить любые типы данных, иметь методы добавления и удаления элементов.
 */
public class MyList <E> implements Iterable<E> {
    private E[] e;

    MyIterator myIterator;

    MyList(int size){
        this.e = (E[]) new Object[size];
        this.myIterator = new MyIterator<>(this.e);
    }
    public int length(){
        return this.e.length;
    }
    public void add(E e){
        for (int i = 0; i < this.e.length; i++) {
            if (this.e[i] == null){
                this.e[i] = e;
                return;
            }
        }
    }
    public E[] getArray(){
        return e;
    }
    public E getElement(int pos){
        return e[pos];
    }
    public void deleteElement(int pos){
        e[pos] = null;
        Object[] resizedArr = new Object[e.length];
        int t = 0;
        for (int i = 0; i < resizedArr.length ; i++) {
            if (e[i]  != null){
                resizedArr[t] = e[i];
                t++;
            }
        }
        e = (E[])resizedArr;
        for (int i = 0; i < e.length; i++) {
            e[i] = (E)resizedArr[i];
            this.myIterator.setArray(e);
        }
    }
    public void print(){
        for (E element: e) {
            System.out.printf("%s ", element);
        }
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Iterator iterator() {
        return myIterator;
    }
}
