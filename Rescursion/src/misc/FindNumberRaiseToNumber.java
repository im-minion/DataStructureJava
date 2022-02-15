package misc;

public class FindNumberRaiseToNumber {
    public static void main(String[] args) {
        System.out.println(solve(5));
    }

    private static int solve(int a) {
        MyKlass myKlass = new MyKlass();
        myKlass.counter = a;
        myKlass.res = 1;
        myKlass.val = a;
        solveByRec(myKlass);

        return myKlass.res;
    }

    private static void solveByRec(MyKlass myKlass) {
        // base cond
        if (myKlass.counter == 0) {
            return;
        } else {
            //solution
            myKlass.res = myKlass.res * myKlass.val;
            myKlass.counter--;
            solveByRec(myKlass);
        }
    }

    private static class MyKlass {
        int counter = 0;
        int res;
        int val;
    }

}
