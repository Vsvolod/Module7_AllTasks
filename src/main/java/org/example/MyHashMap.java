package org.example;

public class MyHashMap <T> {
    private final int INIT_SIZE = 16;
    private final int INIT_RATE = 4;
    private Node <T> [] Map = new  Node[INIT_SIZE];
    private int pointer = 0;


    private void resize(int newLength){
        Node <T> [] newMap = new Node[newLength];
        System.arraycopy(Map, 0, newMap, 0, pointer);
        Map = newMap;
    }
    static class Node <T>{
        T key;
        T value;
        public Node(T key, T value){
            this.key = key;
            this.value = value;
        }

    }

    public void put(T key, T value){
        Node <T> newNode = new Node<>(key, value);
        Map[pointer] = newNode;
        pointer++;
    }
    public void remove(T key){
        for (int i = 0; i < pointer; i++){
            if(Map[i].key == key){
                Map[i] = null;
                pointer --;
            }
        }
    }
    public void clear(){
        for (int i = 0; i<Map.length; i++){
            Map[i] = null;
            pointer = 0;
        }
    }
    public int size(){
        int lengthOfArray = pointer;

        return lengthOfArray;
    }

    public T get(T key){
        T tempValue = null;
        for (int i = 0; i < pointer; i++){
            if(Map[i].key == key){
                tempValue = Map[i].value;
            }
        }
        return (T) tempValue;
    }
}
