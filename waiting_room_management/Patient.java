package Waiting_Room_Management;

/*COSC 2P03 Assignment 1
 * @author: Priyanshu N. Vora (7087729)
 * @date: 25-Sep-2022*/

/**
 * Class to define the Patients object with their attributes and has getter
 * and setter methods.
 */
public class Patient {

    String name;
    String gender;
    int age;
    String occupation;
    String condition;
    String arrivalTime;
    int priority;

    /**
     * Constructor to make a Patient object.
     * @param name : patient's name
     * @param gender : patient's gender
     * @param age: patient's age
     * @param occupation: patient's occupation
     * @param condition: patient's health condition
     * @param arrivalTime: patient's time of arrival
     */
    public Patient(String name, String gender, int age, String occupation,
            String condition, String arrivalTime){

        this.name = name;
        this.gender = gender;
        this.age = age;
        this.condition = condition;
        this.occupation = occupation;
        this.arrivalTime = arrivalTime;
        this.priority = 0;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getCondition() {
        return condition;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getPriority() {
        return priority;
    }

    /**
     * Method to calculate and set the priority of a patient with the given
     * conditions.
     * @return : integer, the priority of the patient, ranging from least(0)
     * to most (3).
     */
    public int calcPriority() {

        if(getAge()>=60){
            priority++;
        }
        if(getOccupation().equals("Teacher") | getOccupation().equals("Nurse")
                || getOccupation().equals("Care Giver")) {

            priority++;
        }

        if(getCondition().equals("Pregnant") || getCondition().equals("Cancer")
                || getCondition().equals("Diabetes")
                || getCondition().equals("Asthma")
                || getCondition().equals("Primary Immune Deficiency")
                || getCondition().equals("Cardiovascular Disease")) {

            priority++;
        }
        return priority;

    }

    /**
     * Method to set(update) this.priority to the new calculated priority
     */
    public void setPriority() {
        this.priority = calcPriority();
    }

}
