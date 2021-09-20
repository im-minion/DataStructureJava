package standard;

public class G02_EgyptianFraction {
    public static void main(String[] args) {
        int nr = 6, dr = 14;
        getEgyptianFraction(nr, dr);
    }

    private static void getEgyptianFraction(int nr, int dr) {
        if (nr == 0 || dr == 0) return;
        if (dr % nr == 0) {
            System.out.println("1/" + dr / nr);
            return;
        }

        if (nr % dr == 0) {
            System.out.println(nr / dr + " + ");
            return;
        }

        if (nr > dr) {
            System.out.println(nr / dr + " + ");
            getEgyptianFraction(nr % dr, dr);
            return;
        }

        //dr > nr
        int n = dr / nr + 1;
        System.out.println("1/" + n + " + ");
        getEgyptianFraction((nr * n) - dr, dr * n);
    }
}
