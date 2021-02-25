public class TowerOfHanoi {
    public static void main(String[] args) {
        towersOfHanoiSolution(3, 'A', 'B', 'C');
    }

    public static void towersOfHanoiSolution(int n, char fromPeg, char toPeg, char auxPeg) {
        if(n == 1) {
            System.out.println("MOVE disk 1 from: " + fromPeg + " to: "+ toPeg);
            return;
        }
        towersOfHanoiSolution(n-1, fromPeg, auxPeg, toPeg);

        System.out.println("MOVE disk from: " + fromPeg + " to: "+ toPeg);

        towersOfHanoiSolution(n-1, auxPeg, toPeg, fromPeg);
    }

}
