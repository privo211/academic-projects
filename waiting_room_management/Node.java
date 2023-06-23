package Waiting_Room_Management;

/*COSC 2P03 Assignment 1
* @author: Priyanshu N. Vora (7087729)
* @date: 25-Sep-2022*/

/**
 * Node class used for the implementation of Priority queue using
 * doubly-linked list
 */
public class Node {

    Patient item;
    int priority;
    Node next;
    Node prev;


    /**
     * It constructs a Node item with patient data and their priority.
     * @param item : The patient data.
     * @param priority : Priority of the patient.
     */
    public Node(Patient item, int priority){

        this.item = item;
        this.priority = priority;

    }//Constructor

}//Node
