import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseSentenceKeepWords {
    public static void main(String[] args) {
        System.out.println(solve("the sky is blue"));
        System.out.println(solve("qxkpvo  f   w vdg t wqxy ln mbqmtwwbaegx   mskgtlenfnipsl bddjk znhksoewu zwh bd fqecoskmo"));
         // qxkpvo  f   w vdg t wqxy ln mbqmtwwbaegx   mskgtlenfnipsl bddjk znhksoewu zwh bd fqecoskmo
        // fqecoskmo bd zwh znhksoewu bddjk mskgtlenfnipsl mbqmtwwbaegx ln wqxy t vdg w f qxkpvo
    }

    public static String solve(String A) {
        StringBuilder sb = new StringBuilder();
        String[] op = A.split("\\s");
        for (int i = op.length - 1; i >= 0; i--) {
            if(!op[i].equals(""))
             sb.append(op[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
