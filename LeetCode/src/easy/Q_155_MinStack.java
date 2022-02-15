import java.util.ArrayList;
import java.util.List;

public class Q_155_MinStack {
    public static void main(String[] args) {

    }

    int top = -1;
    List<Integer> list;

    int min = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public void MinStack() {
        this.list = new ArrayList<>();
    }

    public void push(int val) {
        if (top != Integer.MAX_VALUE) {
            top++;
            this.list.add(val);
            min = Math.min(min, val);
        }
    }

    public void pop() {
        if (top != -1) {
            int c = list.get(top);
            this.list.remove(top);
            if (min == c) {
                if (list.stream().min(Integer::compare).isPresent()) {
                    min = list.stream().min(Integer::compare).get();
                } else {
                    min = Integer.MAX_VALUE;
                }
            }
            top--;
        }
    }

    public int top() {
        if (top != -1)
            return this.list.get(top);
        return -1;
    }

    public int getMin() {
        if (top != -1)
            return min;
        return min;
    }
}
