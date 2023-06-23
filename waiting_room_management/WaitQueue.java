package Waiting_Room_Management;

/*COSC 2P03 Assignment 1
 * @author: Priyanshu N. Vora (7087729)
 * @date: 25-Sep-2022*/

/**
 * Class to make a priority queue and has insert(), removeMax(), and getHead() methods.
 */
public class WaitQueue {

    public static Node head = null;


    /**
     * This method removes and returns the Node(patient) with the highest
     * priority from the doubly-linked list.
     * @return : The object Patient that is removed from the queue.
     */
    public Patient removeMax(){

        Patient p;

        if(head!=null){

            p = head.item;
            head = head.next;

            if(head!=null){
                head.prev = null;
            }
            return p;
        }
        return null;
    }

    /**
     * The method to insert a patient into the priority queue using
     * doubly-linked list according to their priority.
     * @param item : The data of the patient
     * @param priority: The priority of the patient.
     */
    public void insert(Patient item, int priority){

        if(head == null){
            Node p = new Node(item,priority);
            head = p;
            return;
        }//list is empty

        Node q = new Node(item,priority);
        Node temp = head;
        Node less_pr = null;

        while(temp!=null && temp.priority>= priority){
            less_pr = temp;
            temp = temp.next;
        }

        if (temp==null){
            less_pr.next = q;
            q.prev = less_pr;
        }

        else if (less_pr==null){
            q.next = head;
            head.prev = q;
            head = q;
        }
        else {
            less_pr.next = q;
            q.prev = less_pr;
            q.next = temp;
            temp.prev = q;
        }
    }

    /**
     * Method to print all the elements of the priority queue.
     */
    public void print(){
        while(head!=null){
            System.out.println(head.item);
            head = head.next;
        }
    }

    /**
     * Method to get the data of the head(Node/patient with the highest
     * priority ) of the
     * priority queue.
     * @return : The patient data of the head node.
     */
    public Patient getHead(){

        Patient p;

        if (head!=null){
           p = head.item;
           return p;
        }
        return null;
    }

    /**
     * Method to get the head node of the queue/doubly-linked list.
     * @return : Node, the head node.
     */
    public Node getHeadNode(){
        Node q;

        q = head;
        return q;
    }

}
