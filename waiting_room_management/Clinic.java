package Waiting_Room_Management;

/*COSC 2P03 Assignment 1
 * @author: Priyanshu N. Vora (7087729)
 * @date: 25-Sep-2022*/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class that contains readData and monitor methods. This class also contains
 * the main() method.
 */
public class Clinic {

    /**
     * Method to load all the data from the given .txt file into the Clinic
     * class and to store the data into an array of Patient objects.
     * @return : The array patients of type Patient containing all necessary
     * data.
     */
    public Patient[] readData() {

        File patientInfo = new File("patients.txt");
        Scanner sc;
        Patient[] patients = new Patient[16];

        try{
            sc = new Scanner(patientInfo);
            String patientData;
            String heading;

            int count = 0;

            heading = sc.nextLine();//to eliminate the headings from the data
            // that we read from the .txt file.

            /*Loop to read a line from a file containing patient data and
            split it and make a new Patient and add it to the array of
            Patient type.*/
            while (sc.hasNextLine()) {

                patientData = sc.nextLine();
                String[] line = patientData.split("\t");
                patients[count] = new Patient(line[0],line[1],
                        Integer.parseInt(line[2]),line[3],line[4],line[5]);

                patients[count].setPriority();

                count++;
            }
            sc.close();
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return patients;

    }//read data

    /**
     * Method to get a Patient from the array and to add and remove these
     * patients from the queue according to their priority.
     */
    public void monitor(){

        Patient[] patients = readData();
        Timer timer = new Timer(9,0);
        WaitQueue wq = new WaitQueue();

        boolean open = true;

        int i = 0;

        System.out.println(patients[i].getName()+" "+patients[i].getArrivalTime());

        /*Reads and stores time of arrival of the first patient.*/
        String[] first_vx = patients[i].getArrivalTime().split(":");
        int hour = Integer.parseInt(first_vx[0]);
        int min = Integer.parseInt(first_vx[1]);

        Timer fvx = new Timer(hour,min+15);
        min = min +15;

        /*
         * Loop to add and remove patients from queue and increase the time of
         * the timer
         */
        while (open){

            while (timer.compare(patients[i].getArrivalTime(),
                    fvx.toString())>= 0) {

                if (i == patients.length-2){
                    break;
                }

                //Inserts patient to the queue.
                if (timer.compare(patients[i].getArrivalTime(), timer.toString()) == 0) {
                    ++i;
                    wq.insert(patients[i], patients[i].getPriority());
                }
                timer.increase();

            }

            /*
             * Checks condition and removes the patient from the queue and
             * removes their name and prints their name as well as their
             * time of call.
             */
            if (fvx.compare(fvx.toString(),wq.getHead().getArrivalTime()) == -1){

                if (wq.getHeadNode().next == null){
                    open = false;
                }

                System.out.println(wq.removeMax().getName()+" "+fvx);

                min = min + 15;

                if (min >= 60){
                    hour++;
                    min = min % 60;
                }
                fvx.setMinute(min);
                fvx.setHour(hour);
            }
            else {
                fvx.increase();
            }
        }
    }


    /**
     * Makes a new Clinic object and uses the monitor() method to start the
     * clinic.
     */
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        clinic.monitor();
    }
}
