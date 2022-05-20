import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;



public class ReservationGenerator {

    private int size;

    public ReservationGenerator(int size) {
        this.size = size;

        String[] dates = generateDates();
        String[] slots = generateSlots();
        String[] medicares = generateMedicares();

        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream("Reservations.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        // writing of arrays to Reservations.txt
        for (int i = 0; i < size; i++) {
            outputStream.println(dates[i] + " " + slots[i] + " " + medicares[i]);
        }
        outputStream.close();

    }

    public String[] generateDates() {
        String[] dates = new String[size];

        for (int i = 0; i < size; i++) {
            int year = ThreadLocalRandom.current().nextInt(2021, 2025);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 30);

            String monthString;
            String dayString;

            if (month < 10) {
                monthString = "0" + month;
            }
            else {
                monthString = "" + month;
            }

            if (day < 10) {
                dayString = "0" + day;
            }
            else {
                dayString = "" + day;
            }
            dates[i] = year + "-" + monthString + "-" + dayString;
        }

        return dates;
    }

    public String[] generateSlots() {
        String[] slots = new String[size];

        //Generates a random integer from 1-48
        for (int i = 0; i < size; i++) {
            int randomInt = ThreadLocalRandom.current().nextInt(1, 49);
            if ( randomInt< 10){
                slots[i] = " " + randomInt;
            }
            else{
                slots[i] = "" + randomInt;
            }

        }

        return slots;
    }


    public String[] generateMedicares() {
        String[] medicares = new String[size];
        Random random = new Random();

        // 3 Letters & 2 Digits, LLL##

        for (int i = 0; i < size; i++) {
            String temp = "" + ThreadLocalRandom.current().nextInt(1, 10);
            char tempMedicare = (char)(random.nextInt(26) + 'a');
            medicares[i] =  tempMedicare + "" + tempMedicare + "" + tempMedicare + temp + temp;
            medicares[i] = medicares[i].toUpperCase(Locale.ROOT);
        }

        return medicares;
    }
}
