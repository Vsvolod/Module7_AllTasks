package org.example;

public class MyArrayList<T> {
    private final int INIT_SIZE = 16;
    private final int INIT_RATE = 4;
    private Object [] Array = new  Object[INIT_SIZE];
    private int pointer = 0;

    public void add(T item){
        if(pointer == Array.length-1) {
            resize(Array.length * 2);
        }
            Array[pointer++] = item;

    }

    public T get(int index){
        return (T) Array[index];
    }

    public void remove(int index){
        for (int i = index; i<pointer; i++){
            Array[i] = Array[i+1];
            Array[pointer] = null;
            pointer --;
            if(Array.length>INIT_SIZE && pointer< Array.length / INIT_RATE){
                resize(Array.length/2);
            }
        }
    }

    private void resize(int newLength){
        Object[] newArray = new Object[newLength];
        System.arraycopy(Array, 0, newArray, 0, pointer);
        Array = newArray;
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
}
