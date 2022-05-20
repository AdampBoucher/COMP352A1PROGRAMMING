import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ReservationGenerator generator = new ReservationGenerator(5000);

        FileReader reader = new FileReader("Reservations.txt");

        int totalReservations = reader.countLines();

        Reservations reservations;
        reservations = reader.returnFullArrays();

        // Create arrays of length totalReservation
        String[] rDate = reservations.getDates();
        int[] rSlot = reservations.getSlots();
        String[] rMedicare = reservations.getMedicares();



        // Print arrays in an unordered fashion (how they are in the text file)
        for (int i = 0; i < totalReservations; i++) {
            //System.out.println(rDate[i] + "\t" + rSlot[i] + "\t" + rMedicare[i]);
        }

        System.out.println();

        int activeReservations = rearrangeReservations(rDate, rSlot, rMedicare, "2022-01-01", totalReservations);
        int pastReservations = totalReservations - activeReservations;

        Profiler profiler = new Profiler("displayReservations");
        profiler.start();
        displayReservations(rDate, rSlot, rMedicare, activeReservations);
        profiler.stop();



        System.out.println();
        System.out.println();



        System.out.println("Total Reservations: " + totalReservations);
        System.out.println("Active Reservations: " + activeReservations);
        System.out.println("Past Reservations: " + pastReservations);

        //displayPastReservationsDecreasingOrder(rDate, rSlot, rMedicare, pastReservations);
        //displayPastReservationsIncreasingOrder(rDate, rSlot, rMedicare, pastReservations);
    }

    public static int rearrangeReservations(String[] rDate, int[] rSlot, String[] rMedicare, String currentDate, int numOfReservations) {


        boolean sorted = true;


        for (int j = 0; j < rDate.length - 1; j++) {
            if (rDate[j].compareTo(rDate[j + 1]) > 0) {
                String date = rDate[j];
                int slot = rSlot[j];
                String medicare = rMedicare[j];

                //swap rDate, rSlot, rMedicare
                rDate[j] = rDate[j + 1];
                rSlot[j] = rSlot[j + 1];
                rMedicare[j] = rMedicare[j + 1];

                rDate[j + 1] = date;
                rSlot[j + 1] = slot;
                rMedicare[j + 1] = medicare;

                sorted = false;
            }
        }
        if (sorted) {
            int activeReservations = 0;
            // Count Active Reservations and return TODO: Add this step to previous loop
            for (int i = 0; i < rDate.length; i++) {
                if (rDate[i].compareTo(currentDate) > 0) {
                    activeReservations++;
                }
            }

            // Initialize new arrays
            String[] date = new String[rDate.length];
            int[] slot = new int[rSlot.length];
            String[] medicare = new String[rMedicare.length];

            //Splice arrays
            int counter = activeReservations;
            int counter2 = activeReservations + 1;
            // TODO: Make this use two for loops for clarity and only use one counter
            for (int i = 0; i < rDate.length; i++) {
                if (counter > 0) {
                    date[i] = rDate[rDate.length - counter];
                    slot[i] = rSlot[rSlot.length - counter];
                    medicare[i] = rMedicare[rMedicare.length - counter];
                    counter--;
                } else {
                    date[i] = rDate[rDate.length - counter2];
                    slot[i] = rSlot[rSlot.length - counter2];
                    medicare[i] = rMedicare[rMedicare.length - counter2];
                    counter2++;
                }
            }


            // Sorts active reservations by slot
            for (int i = 0; i < activeReservations; i++) {
                sorted = true;
                for (int j = 0; j < activeReservations - 1; j++) {
                    if (date[j].equals(date[j + 1])) {
                        if (slot[j] > slot[j + 1]) {
                            int tempSlot = slot[j];
                            String tempMedicare = medicare[j];

                            //swap rDate, rSlot, rMedicare
                            slot[j] = slot[j + 1];
                            medicare[j] = medicare[j + 1];

                            slot[j + 1] = tempSlot;
                            medicare[j + 1] = tempMedicare;
                            sorted = false;
                        }
                    }
                }
                if (sorted) {
                    break;
                }
            }

            // Sorts past reservations by slot
            for (int i = activeReservations; i < date.length; i++) {
                sorted = true;
                for (int j = activeReservations; j < date.length - 1; j++) {
                    if (date[j].equals(date[j + 1])) {
                        if (slot[j] < slot[j + 1]) {
                            int tempSlot = slot[j];
                            String tempMedicare = medicare[j];

                            //swap rDate, rSlot, rMedicare
                            slot[j] = slot[j + 1];
                            medicare[j] = medicare[j + 1];

                            slot[j + 1] = tempSlot;
                            medicare[j + 1] = tempMedicare;
                            sorted = false;
                        }
                    }
                }
                if (sorted) {
                    break;
                }
            }

            PrintWriter outputStream = null;
            try {
                outputStream = new PrintWriter(new FileOutputStream("out.txt"));
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }

            // writing of arrays to out.txt
            for (int i = 0; i < date.length; i++) {
                outputStream.println(date[i] + " " + slot[i] + " " + medicare[i]);
            }
            outputStream.close();

            return activeReservations;
        } else {
            return rearrangeReservations(rDate, rSlot, rMedicare, currentDate, numOfReservations);
        }


        //determines how many reservations there are left and returns that number, and rearranges the reservations based on what is provided in the assignment

    }

    public static void displayReservations(String[] rDate, int[] rSlot, String[] rMedicare, int activeReservations) {

        //displays all active Reservations in increasing order based on the date and slot

        int pastReservations = rDate.length - activeReservations;
        boolean sorted;

        //bubble sort algorithm O(n^(2))
        for (int i = 0; i < rDate.length; i++) {
            sorted = true;
            for (int j = 0; j < rDate.length - 1; j++) {

                if (rDate[j].compareTo(rDate[j + 1]) > 0) {
                    String date = rDate[j];
                    int slot = rSlot[j];
                    String medicare = rMedicare[j];

                    //swap rDate, rSlot, rMedicare
                    rDate[j] = rDate[j + 1];
                    rSlot[j] = rSlot[j + 1];
                    rMedicare[j] = rMedicare[j + 1];

                    rDate[j + 1] = date;
                    rSlot[j + 1] = slot;
                    rMedicare[j + 1] = medicare;

                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }

        //for loop prints all active reservations
        for (int i = pastReservations; i < rSlot.length; i++) {
            //System.out.println(rDate[i] + " " + rSlot[i] + " " + rMedicare[i]);
        }


    }

    // OLD TO NEW
    public static void displayPastReservationsIncreasingOrder(String[] rDate, int[] rSlot, String[] rMedicare, int pastReservations) {

        System.out.println("\nPast reservations in increasing order: ");

        // display the date, slot and medicare of previous reservations in increasing order by date and slot
        boolean sorted = true;


        for (int j = 0; j < rDate.length - 1; j++) {
            if (rDate[j].compareTo(rDate[j + 1]) > 0) {
                String date = rDate[j];
                int slot = rSlot[j];
                String medicare = rMedicare[j];

                //swap rDate, rSlot, rMedicare
                rDate[j] = rDate[j + 1];
                rSlot[j] = rSlot[j + 1];
                rMedicare[j] = rMedicare[j + 1];

                rDate[j + 1] = date;
                rSlot[j + 1] = slot;
                rMedicare[j + 1] = medicare;

                sorted = false;
            }
        }

        if (sorted) {

            // Sorts past reservations by slot
            for (int i = 0; i < pastReservations; i++) {
                sorted = true;
                for (int j = 0; j < pastReservations - 1; j++) {
                    if (rDate[j].equals(rDate[j + 1])) {
                        if (rSlot[j] > rSlot[j + 1]) {
                            int tempSlot = rSlot[j];
                            String tempMedicare = rMedicare[j];

                            //swap rDate, rSlot, rMedicare
                            rSlot[j] = rSlot[j + 1];
                            rMedicare[j] = rMedicare[j + 1];

                            rSlot[j + 1] = tempSlot;
                            rMedicare[j + 1] = tempMedicare;
                            sorted = false;
                        }
                    }
                }
                if (sorted) {
                    break;
                }
            }

            // Print arrays
            for (int i = 0; i < pastReservations; i++) {
                System.out.println(rDate[i] + " " + rSlot[i] + " " + rMedicare[i]);
            }

        } else {
            displayPastReservationsIncreasingOrder(rDate, rSlot, rMedicare, pastReservations);
        }

    }

    // NEW TO OLD
    public static void displayPastReservationsDecreasingOrder(String[] rDate, int[] rSlot, String[] rMedicare, int pastReservations) {
        System.out.println("\nPast reservations in decreasing order: ");
        // display the date, slot and medicare of previous reservations in decreasing order by date and slot
        boolean sorted = true;

        for (int j = 0; j < rDate.length - 1; j++) {
            if (rDate[j].compareTo(rDate[j + 1]) > 0) {
                String date = rDate[j];
                int slot = rSlot[j];
                String medicare = rMedicare[j];

                //wap rDate, rSlot, rMedicare
                rDate[j] = rDate[j + 1];
                rSlot[j] = rSlot[j + 1];
                rMedicare[j] = rMedicare[j + 1];

                rDate[j + 1] = date;
                rSlot[j + 1] = slot;
                rMedicare[j + 1] = medicare;

                sorted = false;
            }
        }

        if (sorted) {

            // Sorts past reservations by slot
            for (int i = 0; i < pastReservations; i++) {
                sorted = true;
                for (int j = 0; j < pastReservations - 1; j++) {
                    if (rDate[j].equals(rDate[j + 1])) {
                        if (rSlot[j] > rSlot[j + 1]) {
                            int tempSlot = rSlot[j];
                            String tempMedicare = rMedicare[j];

                            //swap rDate, rSlot, rMedicare
                            rSlot[j] = rSlot[j + 1];
                            rMedicare[j] = rMedicare[j + 1];

                            rSlot[j + 1] = tempSlot;
                            rMedicare[j + 1] = tempMedicare;
                            sorted = false;
                        }
                    }
                }
                if (sorted) {
                    break;
                }
            }

            for (int i = pastReservations - 1; i >= 0; i--) {
                System.out.println(rDate[i] + " " + rSlot[i] + " " + rMedicare[i]);
            }
        } else {
            displayPastReservationsDecreasingOrder(rDate, rSlot, rMedicare, pastReservations);
        }

    }

}