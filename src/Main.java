import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main (String[] args) {

        Scanner myKeyboard = new Scanner(System.in);
        FileInputStream inputStream = null;
        FileInputStream inputStream2 = null;
        Scanner reader = null;
        int count = 0;

        System.out.print("Enter the name of the file you would like to read: ");
        String fileName = myKeyboard.nextLine();

        try {
            inputStream = new FileInputStream("/Users/adamboucher/Intellij-Workspace/COMP352A1PROGRAMMING/src/" + fileName + ".txt");
            inputStream2 = new FileInputStream("/Users/adamboucher/Intellij-Workspace/COMP352A1PROGRAMMING/src/" + fileName + ".txt");
        } catch (FileNotFoundException e) {
            System.out.println("This file cannot be found, and therefore will not be opened.");
        }


        Scanner counter = new Scanner(inputStream);


        //count number of lines in the text file to determine how long the arrays should be
        while (counter.hasNextLine()) {
            count++;
            counter.nextLine();
        }
        counter.close();

        //instantiate arrays and scanners to read lines
        reader = new Scanner(inputStream2);
        String[] rDate = new String[count];
        int[] rSlot = new int[count];
        String[] rMedicare = new String[count];
        int i = 0;

        while (reader.hasNextLine()) {

            rDate[i] = reader.next();
            try {
                rSlot[i] = reader.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("The slot cannot be converted to an integer, check the text file once this program ends." +
                        " The program will terminate now.");
                System.exit(0);
            }
            rMedicare[i] = reader.next();
            i++;
        }
        reader.close();

        //prints arrays in an unordered fashion (how they are in the text file)
        for (i = 0; i < rDate.length; i++) {
            System.out.println(rDate[i] + "\t" + rSlot[i] + "\t" + rMedicare[i]);
        }

    }

}
