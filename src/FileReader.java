import java.io.*;
import java.util.*;

public class FileReader {

    private String fileName;
    private FileInputStream inputStream;
    private Scanner scan;

    private int totalReservations;


    public FileReader(String file) {

        fileName = file;
        try {
            inputStream = new FileInputStream("/Users/adamboucher/IntelliJ-Workspace/COMP352A1PROGRAMMING/" + file);
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
        scan = null;

    }

    public int countLines() {

        int totalReservations = 0;

        Scanner counter = new Scanner(inputStream);
        while (counter.hasNextLine()) {
            totalReservations++;
            counter.nextLine();
        }
        counter.close();
        try {
            inputStream.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }

        this.totalReservations = totalReservations;

        return totalReservations;

    }

    public Reservations returnFullArrays(){

        try {
            inputStream = new FileInputStream("/Users/adamboucher/IntelliJ-Workspace/COMP352A1PROGRAMMING/" + fileName);
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }

        scan = new Scanner(inputStream);
        Reservations reservations = new Reservations(totalReservations);


        String[] dates = new String[totalReservations];
        int[] slots = new int[totalReservations];
        String[] medicares = new String[totalReservations];


        // Filling arrays
        for (int i = 0; i < totalReservations; i++) {
            dates[i] = scan.next();
            try {
                slots[i] = scan.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println(e);
            }
            medicares[i] = scan.next();

            //System.out.println(dates[i] + " " + slots[i] + " " + medicares[i]);

        }
        scan.close();

        reservations.initArrays(dates, slots, medicares);

        return reservations;
    }
}
