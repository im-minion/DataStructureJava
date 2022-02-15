package greedy.standard;

import java.util.ArrayList;

public class G03_JobSequencing {

    static class Job {
        // Each job has a unique-id,
        // profit and deadline
        char id;
        int deadline, profit;

        // Constructors
        public Job() {
        }

        public Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

        public char[] getJobScheduling(ArrayList<Job> arr, int n) {
            arr.sort((a, b) -> b.profit - a.profit);

            boolean[] slots = new boolean[n];

            char[] op = new char[n];

            for (int i = 0; i < n; i++) {
                int currDeadline = arr.get(i).deadline;
                char currJob = arr.get(i).id;
                // find if timeslot avail for cureDeadline - 1 to 0;
                for (int j = Math.min(n - 1, currDeadline - 1); j >= 0; j--) {
                    if (!slots[j]) {
                        slots[j] = true;
                        op[j] = currJob;
                        break;
                    }
                }
            }
            return op;
        }
    }

    public static void main(String[] args) {
        ArrayList<Job> arr = new ArrayList<Job>();

        arr.add(new Job('a', 2, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));

        // Function call
        System.out.println("Following is maximum "
                + "profit sequence of jobs");

        Job job = new Job();

        // Calling function
        char[] op = job.getJobScheduling(arr, arr.size());
        for (char c : op) {
            System.out.print(c + "  ");
        }
    }
}
