package misc;

public class Staircase {
    public static int countPaths(int steps){

        //Base cases here.
        //1. If steps are negative then there are no paths from bottom of stairs.
        if(steps < 0){
            return 0;
        }

        //2. If steps are 0 or 1 then there is exactly 1 path. 
        //1 path for 0 steps because if we are the top then there is one path staying right where we are.
        //1 path for 1 step because we can only take 1 step not more than that, so only 1 path.
        if(steps <= 1){

            return 1;
        } 

        return countPaths(steps-1) + countPaths(steps - 2) + countPaths(steps - 3);
    }

    public static void main(String[] args) {
        System.out.println(countPaths(4));

    }
}