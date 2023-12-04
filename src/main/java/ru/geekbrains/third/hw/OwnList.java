package ru.geekbrains.third.hw;

import java.util.Iterator;
/*
1. Внедрить итератор из задания 2 в коллекцию, написанную в задании 3 таким образом,
чтобы итератор был внутренним классом и, соответственно, объектом в коллекции.
 */

public class OwnList <T> implements Iterable<T>{
    private Object[] arrObj;
    private T [] ownList;
    private int index = 0;
    public OwnList (int size){
        arrObj = new Object[size];
        ownList = (T[]) arrObj;
    }
    public int length(){
        return this.ownList.length;
    }
    public void add(T type){
        for (int i = 0; i < this.ownList.length; i++) {
            if (this.ownList[i] == null){
                this.ownList[i] = type;
                return;
            }
        }
    }
    public Object [] getArrObj(){
        return this.arrObj;
    }
    public void deleteElement(int pos){
        ownList[pos] = null;
        int t = 0;
        for (int i = 0; i < ownList.length; i++) {
            if (ownList[i]  != null){
                arrObj[t] = (Object) ownList[i];
                t++;
            }
        }
        for (int i = 0; i < ownList.length; i++) {
            if (i == ownList.length - 1){
                ownList[i] = null;
            }
            ownList[i] = (T)arrObj[i];
        }
    }
    public void print(){
        for (T t:this.ownList) {
            System.out.printf("%s ", t);
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new OwnListIterator<T>();
    }
    private class OwnListIterator<T> implements Iterator<T>{
        @Override
        public boolean hasNext() {
            return index < ownList.length;
        }

        @Override
        public T next() {
            return (T) ownList[index++];
        }
    }
}
