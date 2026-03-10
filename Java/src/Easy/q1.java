package Easy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> my_map = new HashMap<>();

        for (int i=0;i<nums.length;++i)
            my_map.put(nums[i],i);

        Object k;
        for (int j=0;j<nums.length;++j) {
            k = my_map.get(target-nums[j]);

            if (k != null && ((int)k != j)) {
                return new int[] {j, (int) k};
            }
        }

        return null;
    }

    public static void testSample() {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
    }
}
