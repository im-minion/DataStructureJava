import java.util.ArrayList;
import java.util.Collections;

public class HotelBooking {
    public static void main(String[] args) {
        ArrayList<Integer> arrive = new ArrayList<>();
        ArrayList<Integer> depart = new ArrayList<>();
        arrive.add(1);
        arrive.add(3);
        arrive.add(5);
        depart.add(2);
        depart.add(6);
        depart.add(8);
        int K = 3;
        boolean r = hotel(arrive,depart, K);
        System.out.println(r);
    }

    public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        for(int i = 0 ; i < arrive.size() ; i++) {
            if (i + K < arrive.size() && arrive.get(i + K) < depart.get(i))
                return false;
        }
        return true;
    }
}
