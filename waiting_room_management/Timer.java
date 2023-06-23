package Waiting_Room_Management;

/*COSC 2P03 Assignment 1
 * @author: Priyanshu N. Vora (7087729)
 * @date: 25-Sep-2022*/

/**
 * Class to create a Timer object. It also has the increase() and compare()
 * methods. It also has getter and setter methods.
 */
public class Timer {
    int hour = 0;
    int minute = 0;
    int vxtime = 0;

    /**
     * Constructor to make a Timer object.
     * @param hour : The hour in integer form.
     * @param minute : The minute in integer form.
     */
    public Timer (int hour, int minute){

        this.hour = hour;
        this.minute = minute;
    }

    /**
     * Method to increase the time every minute and returns an integer.
     * @return : an int (1) if vaccination is done or else (-1).
     */
    public int increase(){

        minute++;

        if(minute>=60){
            hour++;
            minute = minute%60;
            setHour(hour);
            setMinute(minute);
        }
        else {
            setMinute(minute);
        }

        vxtime++;
        if(vxtime == 15){
            vxtime = 0;
            return 1;
        }

        return -1;
    }

    /**
     * This method takes in two String of time and compares them and returns
     * and integer accordingly.
     * @param time1 : 1st time to compare.
     * @param time2 : 2nd time to compare the 1st time to
     * @return : int
     */
    public int compare(String time1, String time2){

        int ans = 0;

        String[] t1 = time1.split(":");
        String[] t2 = time2.split(":");

        int hour1 = Integer.parseInt(t1[0]);
        int min1 = Integer.parseInt(t1[1]);

        int hour2 = Integer.parseInt(t2[0]);
        int min2 = Integer.parseInt(t2[1]);

        if(hour1 > hour2){
            ans = -1;
        }
        else if (hour1 < hour2){
            ans = 1;
        }
        else if (hour1 == hour2){

            if(min1 == min2){
                ans = 0;
            }
            else if(min1 > min2){
                ans = -1;
            }
            else if (min1 < min2){
                ans = 1;
            }
        }
        return ans;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    /**
     * This method converts the time from an integer to a String.
     * @return : String of time in ("hh:mm") format.
     */
    @Override
    public String toString() {

        String h;
        String m;

        if (minute>= 0 && minute<= 9){
            m = "0" + minute;
        }
        else {
            m = Integer.toString(minute);
        }

        if (hour>= 0 && hour<= 9){
            h = "0" + hour;
        }
        else {
            h = Integer.toString(hour);
        }

        return h + ":" + m;
    }
}
