package org.example;

import java.util.EmptyStackException;

public class MyQueue<T> {
    private final int INIT_SIZE = 16;
    private final int INIT_RATE = 4;

    private Object [] Array = new  Object[INIT_SIZE];
    private int pointer = 0;

    private void resize(int newLength){
        Object[] newArray = new Object[newLength];
        System.arraycopy(Array, 0, newArray, 0, pointer);
        Array = newArray;
    }
    public void add(T item){
        if(pointer == Array.length-1) {
            resize(Array.length + 1);
        }
        Array[pointer++] = item;

    }
    public void remove(int index){
        for (int i = index; i<pointer; i++){
            Array[i] = Array[i+1];
            Array[pointer] = null;
            pointer --;
            if(Array.length>INIT_SIZE && pointer< Array.length / INIT_RATE){
                resize(Array.length-1);
            }
        }
    }
    public void clear(){
        for (int i = 0; i<Array.length; i++){
            Array[i] = null;
            pointer = 0;
        }
    }
    public int size(){
        int lengthOfArray = pointer;
        return lengthOfArray;
    }

    public T peek(){
        return (T) Array[0];
    }

    public T poll(){
        T temp = (T) Array[0];
        if(pointer <= 0){
            clear();
        }
        remove(0);
        pointer --;
        return temp;

    }


}
