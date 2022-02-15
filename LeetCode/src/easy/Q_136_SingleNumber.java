public class Q_136_SingleNumber {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
//         Map<Integer, Integer> map = new HashMap<>();
//         for(int n : nums) {
//             map.put(n, map.getOrDefault(n,0) + 1);
//         }

//         for(Map.Entry<Integer, Integer> e : map.entrySet()) {
//             if(e.getValue() == 1) {
//                 return e.getKey();
//             }
//         }
//         return -1;

        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }

        return res;
    }
}
