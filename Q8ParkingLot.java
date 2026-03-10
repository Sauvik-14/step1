public class Q8ParkingLot {

    String[] spots = new String[10];

    int hash(String plate) {
        return Math.abs(plate.hashCode()) % spots.length;
    }

    public void park(String plate) {

        int i = hash(plate);

        while (spots[i] != null) {
            i = (i + 1) % spots.length;
        }

        spots[i] = plate;

        System.out.println("Parked at spot " + i);
    }

    public static void main(String[] args) {

        Q8ParkingLot p = new Q8ParkingLot();

        p.park("ABC123");
        p.park("XYZ999");
    }
}