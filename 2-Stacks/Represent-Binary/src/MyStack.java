/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ducta
 */
public class MyStack {
    private Node top;
    public MyStack() {
        this.top = null;
    }

    public void clear() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot perform pop operation.");
            return -1;
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot perform top operation.");
            return -1;
        }
        return top.data;
    }
}
