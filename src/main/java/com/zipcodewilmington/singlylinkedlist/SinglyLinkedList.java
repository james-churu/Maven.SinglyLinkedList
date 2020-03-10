package com.zipcodewilmington.singlylinkedlist;

import java.util.Iterator;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T>{

    Node<T> head;
    Node<T> tail;

    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void add(T value){

        if(head == null){
            head = new Node<T>(value);
            tail = head;
        }else{

            Node noddy = new Node(value);
            tail.setNext(noddy);
            tail = noddy;
        }

    }
    public T remove(Integer index){

        Node<T> current;
        Node<T> next;
        T removed = null;

        if(index == 0){
            current = head;
            head = current.getNext();
        }else if(index == getSize(this.head)){

            int count = 0;
            for(current = head; count < getSize(this.head) ; current = current.getNext()){

                if(count == getSize(this.head) -1){
                    this.tail = current;
                    this.tail.setNext(null);
                }
                count++;
            }

        }else{
            Node<T> valToRemove = null;
            int count = 0;
            for(current = head; count < index ; current = current.getNext()){
                if(count == index -1){
                    valToRemove = current.getNext();
                    removed = valToRemove.getValue();
                    next = valToRemove.getNext();
                    current.setNext(next);
                    return removed;
                }
                count++;

            }
        }
        return removed;
    }
    public Integer getSize(Node head){
        Integer size = 0;
        Node current = head;
        while(current != null){
            current = current.getNext();
            size++;
        }
        return size;
    }
    public Node getHead(){
        return this.head;
    }

    public T getValue(Integer index){

        Node<T> current = null;
        int count = 0;
        for(current = head; count < index; current = current.getNext()){
            count++;
        }
        return current.getValue();
    }
    // ******************************  CONTAINS  *************
    public boolean contains(T value){
        if(find(value) == -1){
            return false;
        }else{
            return true;
        }
    }
    // *****************************  FIND  ******************
    public Integer find(T value){
        Integer index = -1;
        Node<T> current = null;
        int count = 0;
        for(current = head; count < getSize(this.head); current = current.getNext()){
            if(current.getValue() == value){
                index = count;
                return index;
            }
            count++;
        }
        return index;
    }
    // *******************************     COPY    ****************
    public SinglyLinkedList<T> copy(){
        return this;
    }
    // *******************************    sort     ****************
    public SinglyLinkedList<T> sort(){
        return null;
    }


    // ********************************    NODE CLASS    ***********************
    static class Node<T>{

        T value;
        Node<T> next;

        public Node(T newValue , Node<T> nextNode){
            this.value = newValue;
            this.next = nextNode;
        }
        public Node(T val){
            this.value =  val;
            this.next = null;
        }
        public Node(){
            this.value = null;
            this.next = null;
        }
        public T getValue() {
            return value;
        }
        public void setValue(T value) {
            this.value = value;
        }
        public Node<T> getNext() {
            return next;
        }
        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}

