package misc;

/**
 * There are N dominoes in a line, and we place each domino vertically upright.
 * 
 * In the beginning, we simultaneously push some of the dominoes either to the
 * left or to the right.
 * 
 * After each second, each domino that is falling to the left pushes the
 * adjacent domino on the left.
 * 
 * Similarly, the dominoes falling to the right push their adjacent dominoes
 * standing on the right.
 * 
 * When a vertical domino has dominoes falling on it from both sides, it stays
 * still due to the balance of the forces.
 * 
 * For the purposes of this question, we will consider that a falling domino
 * expends no additional force to a falling or already fallen domino.
 * 
 * Given a string "S" representing the initial state. S[i] = 'L', if the i-th
 * domino has been pushed to the left; S[i] = 'R', if the i-th domino has been
 * pushed to the right; S[i] = '.', if the i-th domino has not been pushed.
 * 
 * Return a string representing the final state.
 * 
 * Example 1: Input: ".L.R...LR..L.." Output: "LL.RR.LLRRLL.."
 * 
 * 
 * Example 2: Input: "RR.L" Output: "RR.L" Explanation: The first domino expends
 * no additional force on the second domino.
 * 
 * 
 */
public class PushDominoes {
    public static void main(String[] args) {
        System.out.println(getResult(".L.R...LR..L.."));
    }

    private static String getResult(String input) {
        StringBuilder result = new StringBuilder();
        char dominoes[] = input.toCharArray();
        int N = dominoes.length;
        int forces[] = new int[N];

        int force = 0;
        // traverse from right to left and if right is present force wil be N;
        for (int i = 0; i < N; i++) {
            if (dominoes[i] == 'R') {
                force = N;

            } else if (dominoes[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] += force;
        }

        force = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (dominoes[i] == 'L') {
                force = N;

            } else if (dominoes[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }

        for(Integer f: forces) {
            if(f > 0) {
                result.append('R');
            } else if(f < 0) {
                result.append('L');
            } else {
                result.append('.');
            }
        }
        return result.toString();
    }
}