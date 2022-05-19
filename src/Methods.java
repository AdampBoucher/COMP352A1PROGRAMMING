public class Methods {

    public int rearrangeReservations(String[] rDate, int[] rSlot, String[] rMedicare, String currentDate, int numOfReservations) { //this is also a recursive function

        int activeReservations;

        for (int i = 0; i < numOfReservations; i++) { //bubble sort algorithm O(n^(2))
            for (int j = 0; j < numOfReservations -1; j++) {
                //if rDate[j] > rDate[j+1] then
                //swap rDate, rSlot, rMedicare
            }
        }



        int pastReservations = 0;
        for (int i = 0; i < numOfReservations; i++) {
            //if rDate[i] < current date then pastReservations++
        }

        activeReservations = numOfReservations - pastReservations;

        //determines how many reservations there are left and returns that number, and rearranges the reservations based on what is provided in the assignment

        return activeReservations;
    }

    public void displayReservations (String[] rDate, int[] rSlot, String[] rMedicare, int activeReservations) {

        //displays all active Reservations in increasing order based on the date and slot

        int pastReservations = rSlot.length - activeReservations;
        for (int i = 0; i < rSlot.length; i++) { //bubble sort algorithm O(n^(2))
            for (int j = 0; j < rSlot.length - 1; j++) {
                //if rDate[j] > rDate[j+1] then
                //swap rDate, rSlot, rMedicare
            }
        }

        for (int i = pastReservations; i < rSlot.length; i++) { //for loop prints all active reservations
            System.out.println(rDate[i] + " " + rSlot[i] + " " + rMedicare[i]);
        }

    }

    public void displayPastReservationsIncreasingOrder (String[] rDate, int[] rSlot, String[] rMedicare, int pastReservations) { //recursive function

        //display the date, slot and medicare of previous reservations in increasing order by date and slot
        int activeReservations = rSlot.length - pastReservations;
        for (int i = 0; i < rSlot.length; i++) { //bubble sort algorithm O(n^(2))
            for (int j = 0; j < rSlot.length - 1; j++) {
                //if rDate[j] > rDate[j+1] then
                //swap rDate, rSlot, rMedicare
            }
        }

        for (int i = 0; i < activeReservations; i++) { //for loop prints all past reservations
            System.out.println(rDate[i] + " " + rSlot[i] + " " + rMedicare[i]);
        }

    }

    public void displayPastReservationsDecreasingOrder (String[] rDate, int[] rSlot, String[] rMedicare, int pastReservations) { //recursive function

        //display the date, slot and medicare of previous reservations in decreasing order by date and slot
        int activeReservations = rSlot.length - pastReservations;
        for (int i = 0; i < rSlot.length; i++) { //bubble sort algorithm O(n^(2))
            for (int j = 0; j < rSlot.length - 1; j++) {
                //if rDate[j] < rDate[j+1] then
                //swap rDate, rSlot, rMedicare
            }
        }

        for (int i = 0; i < activeReservations; i++) { //for loop prints all past reservations in
            System.out.println(rDate[i] + " " + rSlot[i] + " " + rMedicare[i]);
        }

    }

}
