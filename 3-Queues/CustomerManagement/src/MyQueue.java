
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ducta
 */
public class MyQueue {
//    private Queue<Customer> queue = new LinkedList<>();
//    public boolean isEmpty() {
//        return queue.isEmpty();
//    }
//    public void enqueue(Customer customer) {
//        queue.add(customer);
//    }
//    public Customer dequeue() {
//        return queue.poll();
//    }
//    public void clear() {
//        queue.clear();
//    }
//    public LinkedList<Customer> getQueueItems() {
//        return new LinkedList<>(queue);
//    }
    private LinkedList<Customer> queue;

    public MyQueue() {
        queue = new LinkedList<>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void enqueue(Customer customer) {
        queue.addLast(customer);
    }

    public Customer dequeue() {
        if (isEmpty()) {
            return null;
        }
        return queue.removeFirst();
    }

    public void clear() {
        queue.clear();
    }

    public LinkedList<Customer> getQueueItems() {
        return new LinkedList<>(queue);
    }
}
