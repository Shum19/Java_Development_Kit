package ru.geekbrains.third;

import java.io.DataInput;
import java.io.InputStream;

/*Создать обобщенный класс с тремя параметрами (T, V, K). Класс содержит три перемен- ные типа (T, V, K),
конструктор, принимающий на вход параметры типа (T, V, K), методы возвращающие значения трех переменных.
Создать метод, выводящий на консоль имена классов для трех переменных класса. Наложить ограничения на параметры
типа: T должен реализовать интерфейс Comparable (классы оболочки, String), V должен реализовать интерфейс
DataInput и расширять класс InputStream, K должен расширять класс Number.
 */
public class MyClass <T extends Comparable, V extends InputStream & DataInput, K extends Number>{
    private T t;
    private V v;
    private K k;
    MyClass(T t, V v, K k){
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public K getK() {
        return k;
    }
    public void printClass(){
        System.out.printf("T is %s; V is %s; K is %s", t.getClass().getSimpleName(),
                            v.getClass().getSimpleName(), k.getClass().getSimpleName());
    }
}
