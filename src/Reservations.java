public class Reservations {
    private String[] dates;
    private int[] slots;
    private String[] medicares;

    public Reservations(int totalReservations){
        this.dates = new String[totalReservations];
        this.slots = new int[totalReservations];
        this.medicares = new String[totalReservations];
    }

    public void initArrays(String[] dates, int[] slots, String[] medicares) {
        this.dates = dates;
        this.slots = slots;
        this.medicares = medicares;
    }

    public String[] getDates() {
        return dates;
    }

    public int[] getSlots() {
        return slots;
    }

    public String[] getMedicares() {
        return medicares;
    }
}
