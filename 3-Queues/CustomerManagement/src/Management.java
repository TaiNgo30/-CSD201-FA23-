
import java.util.LinkedList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ducta
 */
public class Management {

    private MyQueue myQueue;
    private LinkedList<Customer> servingList;
    private LinkedList<Customer> completedList;

    public Management() {
        myQueue = new MyQueue();
        servingList = new LinkedList<>();
        completedList = new LinkedList<>();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        char choice;
        do {
            displayMenu();
            System.out.print("Select an option: ");
            choice = scanner.nextLine().charAt(0);

            switch (choice) {
                case 'a':
                    addCustomer();
                    break;
                case 'b':
                    serveNextCustomer();
                    break;
                case 'c':
                    completeService();
                    break;
                case 'd':
                    generateReport();
                    break;
                case 'e':
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 'e');
    }

    private void displayMenu() {
        System.out.println("Menu:");
        System.out.println("a) Accept a customer");
        System.out.println("b) Move the next customer to the serving list");
        System.out.println("c) Complete service");
        System.out.println("d) Generate report");
        System.out.println("e) Exit");
    }

    private void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer number: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // Discard the new line after reading the customer number
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter job: ");
        String job = scanner.nextLine();

        Customer customer = new Customer(number, name, job);
        myQueue.enqueue(customer);
        System.out.println("Customer has been added to the queue.");
    }

    private void serveNextCustomer() {
        if (!myQueue.isEmpty()) {
            Customer customer = myQueue.dequeue();
            servingList.add(customer);
            System.out.println("Customer " + customer.getName() + " has been moved to the serving list.");
        } else {
            System.out.println("There are no customers in the queue.");
        }
    }

    private void completeService() {
        if (!servingList.isEmpty()) {
            Customer customer = servingList.removeFirst();
            completedList.add(customer);
            System.out.println("Service for customer " + customer.getName() + " has been completed.");
        } else {
            System.out.println("The serving list is empty.");
        }
    }

    private void generateReport() {
        System.out.println("Report:");
        System.out.println("Customers in the queue:");
        for (Customer customer : myQueue.getQueueItems()) {
            System.out.println("Customer " + customer.getName());
        }

        System.out.println("\nCustomers being served:");
        for (Customer customer : servingList) {
            System.out.println("Customer " + customer.getName());
        }

        System.out.println("\nCompleted services:");
        for (Customer customer : completedList) {
            System.out.println("Customer " + customer.getName());
        }
    }
}
