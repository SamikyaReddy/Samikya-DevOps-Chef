
import java.util.Random;
import java.io.*;

public class ProgrammingTaskCode3 {

    public void printDates() throws Exception{
        int i = 0;

        int[] numDaysNonLeap = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] numDaysLeap = {31,29,31,30,31,30,31,31,30,31,30,31};

        int year = 2000;
        int month = 1;
        int day = 1;

        int dayOfWeek = 6;
        int dayOfYear = 1;

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("abc.csv")));

        while(year != 2005 || month != 1 || day != 1) {

            System.out.println(year + " " + month + " " + day + " " + dayOfWeek + " " + dayOfYear);

            //Printing date
            pw.print(year + "-");

            if(month < 10)
                pw.print("0" + month + "-");
            else
                pw.print(month + "-");

            if(day < 10)
                pw.print("0" + day);
            else
                pw.print(day);

            pw.print(",");

            //Printing month name
            pw.print(getMonthName(month));

            pw.print(",");

            //Printing Day of Year
            pw.print(dayOfYear);

            pw.print(",");

            //Priting Day of Week
            pw.print(getDayName(dayOfWeek));

            pw.print(',');
            pw.println(getQuarter(month));

            if(year%4 == 0) {
                day++;
                System.out.println(day + " " + numDaysLeap[month-1]);
                if(day == numDaysLeap[month-1] + 1) {
                    day = 1;
                    if(month == 12) {
                        month = 1;
                        year += 1;

                        dayOfYear = 1;
                    }
                    else {
                        month += 1;
                        dayOfYear++;
                    }
                }
                else {
                    dayOfYear++;
                }
            }
            else if(year%4 != 0) {
                day++;
                if(day == numDaysNonLeap[month-1] + 1) {
                    day = 1;
                    if(month == 12) {
                        month = 1;
                        year += 1;
                        dayOfYear = 1;
                    }
                    else {
                        month += 1;
                        dayOfYear++;
                    }
                }
                else {
                    dayOfYear++;
                }
            }

            dayOfWeek = dayOfWeek + 1;
            if(dayOfWeek == 8)
                dayOfWeek = 1;

        }
        pw.close();

    }

    public String getQuarter(int month) {
        if(month <= 3) {
            return "Q1";
        }
        else if(month <= 6) {
            return "Q2";
        }
        else if(month <= 9) {
            return "Q3";
        }
        else
            return "Q4";
    }

    public String getMonthName(int month) {
        if(month == 1)
            return "January";
        else if(month == 2)
            return "February";
        else if(month == 3)
            return "March";
        else if(month == 4)
            return "April";
        else if(month == 5)
            return "May";
        else if(month == 6)
            return "June";
        else if(month == 7)
            return "July";
        else if(month == 8)
            return "August";
        else if(month == 9)
            return "September";
        else if(month == 10)
            return "October";
        else if(month == 11)
            return "November";
        else
            return "December";
    }


    public String getDayName(int dayOfWeek) {
        if(dayOfWeek == 1)
            return "Monday";
        else if(dayOfWeek == 2)
            return "Tuesday";
        else if(dayOfWeek == 3)
            return "Wednesday";
        else if(dayOfWeek == 4)
            return "Thursday";
        else if(dayOfWeek == 5)
            return "Friday";
        else if(dayOfWeek == 6)
            return "Saturday";
        else
            return "Sunday";
    }

    public static void main(String args[]) {
        ProgrammingTaskCode3 se = new ProgrammingTaskCode3();

        try {
            se.printDates();
        }
        catch(Exception e) {

        }
    }

}