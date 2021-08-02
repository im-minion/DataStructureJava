public class Q_228_SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> op = new ArrayList<>();

        if (nums.length == 0) return op;
        if (nums.length == 1) {
            op.add("" + nums[0]);
            return op;
        }

        for (int i = 0; i < nums.length; i++) {
            int f = nums[i];
            while ((i < nums.length - 1) && (nums[i] == nums[i + 1] - 1)) {
                i++;
            }
            if (f == nums[i]) {
                op.add("" + f);
            } else {
                op.add(f + "->" + nums[i]);
            }
        }
        return op;
    }
}
