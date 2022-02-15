import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Q_219_ContainsDuplicate2 {
    public static void main(String[] args) {
        HashSet<Integer> h = new LinkedHashSet<>();

        h.add(5);
        h.add(6);
        h.add(7);
        System.out.println(h);
        h.remove(h.toArray()[0]);
        System.out.println(h);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k >= nums.length) { k = nums.length -1;}
        int i = 0;
        int j = 0;
        Set<Integer> set = new LinkedHashSet<>();
        while(j < nums.length) {
            while((j-i) <= k) {
                if(!set.add(nums[j])) {
                    return true;
                }
                j++;
            }
            set.remove(nums[i]);
            i++;
        }
        return false;
        // or
//        Set<Integer> set = new HashSet<Integer>();
//        for(int i = 0; i < nums.length; i++){
//            if(i > k) set.remove(nums[i-k-1]);
//            if(!set.add(nums[i])) return true;
//        }
//        return false;
    }
}
