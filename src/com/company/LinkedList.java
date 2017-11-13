package com.company;

public class LinkedList {
    static Node head;
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    public void swapNodeData(Node node1, Node node2) {
//        temp = a;
//        a = b;
//        b = temp;
        int tempData = node1.data;
        node1.data = node2.data;
        node2.data = tempData;
    }
    //Remove a node from list.  This will only work if the target node is in the list
    public void deleteNode(Node target) {
        //         target
        //1 -> 2 -> 3-> 4-> 5 -> nullptr
        target.data = target.next.data;
        target.next = target.next.next;
    }
    public void deleteKey(int target) {
        //Create a previous node, set to null and a current node, set to head
        Node prev = null, curr = head;
        //if the target value is in the head node, set the new head node
        if(curr != null && curr.data == target) {
            head = curr.next;
            return;
        }
        //Traversing through the list until target is found, while keeping track of prev node
        while(curr != null && curr.data != target) {
            prev = curr;
            curr= curr.next;
        }
        //if target is not in the list, dispaly message and return
        if(curr == null) {
            System.out.println("the key " + target + " was not found!");
            return;
        }
        //relink nodes to skip over target node
        prev.next = curr.next;
        return;
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
    public void printLlist(Node node) {
        while(node != null) {
            System.out.println(node.data + " ");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        LinkedList llist1 = new LinkedList();
        llist.addToTail(5);
        llist.addToTail(10);
        llist.addToTail(15);
        llist.pushFront(100);
        llist.deleteKey(20);
        llist.printList();

        System.out.println("\n================");

        llist1.pushFront(30);
        llist1.pushFront(50);
        llist1.pushFront(70);
        llist1.addToTail(80);
        llist1.printList();

        System.out.println("\n================");

        LinkedList llist2 = new LinkedList();
        llist2.head = new Node(55);
        llist2.head.next = new Node(85);
        llist2.head.next.next = new Node(75);
        llist.head.next.next.next = new Node(100);
        llist2.swapNodeData(llist2.head, llist2.head.next.next.next);

        llist2.printLlist(llist2.head);
        return;
    }
}