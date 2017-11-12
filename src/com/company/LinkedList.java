package com.company;

public class LinkedList {
    Node head;
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    public void deleteKey(int target) {
        Node prev = null, curr = head;
        if(curr != null && curr.data == target) {
            head = curr.next;
            return;
        }
        while(curr != null && curr.data != target) {
            prev = curr;
            curr= curr.next;
        }
        if(curr == null) {
            System.out.println("the key was not found!");
            return;
        }
        prev.next = curr.next;
    }
    public void pushFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public void addToTail(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = new Node(data);
            return;
        }

        Node last = head;
        while(last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        newNode.next = null;
        return;
    }
    public void printList() {
        Node tNode = head;
        while(tNode != null) {
            System.out.print(tNode.data + " " );
            tNode = tNode.next;
        }
        return;
    }
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        LinkedList llist1 = new LinkedList();
        llist.addToTail(5);
        llist.addToTail(10);
        llist.addToTail(15);
        llist.pushFront(100);
        llist.printList();
        System.out.println("\n================");
        llist1.pushFront(30);
        llist1.pushFront(50);
        llist1.pushFront(70);
        llist1.addToTail(80);
        llist1.deleteKey(30);
        llist1.deleteKey(50);
        llist1.printList();
    }
}