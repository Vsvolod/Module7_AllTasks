package org.example;

import java.util.*;

public class MyLinkedList<T>  {

    static class Node <T>{
        T element;
        Node<T> next;
        public Node(T element){
            this.element = element;
        }
    }
    private Node<T> first;
    private Node<T> last;
    private int size;

    public static <T> List<T> of(T... elements){
        LinkedList<T> linkedList = new LinkedList<>();
        for(T e : elements){
            linkedList.add(e);
        }
        return linkedList;
    }


    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);
        if (first == null){
            first = last = new Node<>(element);
        } else {
            last.next = newNode;
            last = newNode;
        }
        last.next = new Node<>(element);
        size ++;
        return true;
    }


    public void add(int index, T element) {
        Objects.checkIndex(index, size + 1);
        Node<T> newNode = new Node<>(element);
        if(first == null){
            first = last = newNode;
        }else if (index == 0){
            newNode.next = first;
            first = newNode;
        }else if(index == size){
            last.next = newNode;
            last = newNode;
        }else{
            Node<T> prev = getNodeByIndex(index - 1);
            for (int i=0; i<index; i++){
                prev = prev.next;
            }
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }
    private Node<T> getNodeByIndex(int index){
        Node<T> current = first;
        for (int i=0; i<index; i++){
            current = current.next;
        }
        return current;
    }


    public T set(int index, T element) {
        Objects.checkIndex(index, size);
        Node<T> node = getNodeByIndex(index);
        node.element = element;
        return null;
    }


    public T get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).element;
    }

    public T getFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return get(0);
    }

    public T getLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return get(size - 1);
    }

    public T remove(int index){
        Objects.checkIndex(index, size);
        T removedElement = null;
        if(index==0){
            removedElement = first.element;
            first = first.next;
            if (first == null){
                last = null;
            }
        }else {
        Node<T> prev = getNodeByIndex(index-1);
        T element = prev.next.element;
        prev.next = prev.next.next;
        if (index == size - 1){
            last = prev;
            }
        }
        size --;
        return removedElement;
    }


    public boolean contains(Object element) {
        Node<T> current = first;
        for (int i = 0; i<size; i++){
            if(current.element.equals(element)){
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public boolean isEmpty() {
        if (first == null){
            return true;
        }else {
            return false;
        }
    }

    public int size() {
        return size;
    }


    public void clear() {
        first = last = null;
        size = 0;
    }
}
