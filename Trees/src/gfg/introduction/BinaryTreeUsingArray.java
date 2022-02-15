package gfg.introduction;

public class BinaryTreeUsingArray {
    public static void main(String[] args) {
        ArrayImp obj = new ArrayImp();
        obj.root("A");
        // obj.set_Left("B", 0);
        obj.setRight("C", 0);
        obj.setLeft("D", 1);
        obj.setRight("E", 1);
        obj.setLeft("F", 2);
        obj.printTree();
    }
}

class ArrayImp {
    //    static int root = 0;
    static String[] str = new String[10];

    public void root(String a) {
        str[0] = a;
    }

    public void setRight(String data, int rootIndex) {
        //check if at rootIndex do we have any element or not
        //if not throw error
        int t = (rootIndex * 2) + 2;
        if (str[rootIndex] == null) {
            System.out.printf("Can't set right child at %d, no parent found\n", t);
        } else {
            str[t] = data;
        }

    }

    public void setLeft(String data, int rootIndex) {
        //check if at rootIndex do we have any element or not
        //if not throw error
        int t = (rootIndex * 2) + 1;
        if (str[rootIndex] == null) {
            System.out.printf("Can't set left child at %d, no parent found\n", t);
        } else {
            str[t] = data;
        }
    }

    public void printTree() {
        for (int i = 0; i < 10; i++) {
            if (str[i] != null)
                System.out.print(str[i]);
            else
                System.out.print("-");
        }
    }
}
