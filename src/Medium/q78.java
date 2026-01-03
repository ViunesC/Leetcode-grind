package Medium;

import java.util.ArrayList;
import java.util.List;

public class q78 {
    private static List<Integer> path = new ArrayList<>();
    private static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        backTrack(nums,0);
        return result;
    }

    private static void backTrack(int[] nums, int start) {
        // Add the path to result set when entering every recursive step
        // basically it is (for [1,2,3]):
        // [] (added) -> 1 (added) -> 1,2 (added) -> 1,2,3 (added) -> 2 (added) -> 2,3 (added) -> 3 (added)
        result.add(new ArrayList<>(path));

        if (start >= nums.length)
           return;

        for (int i=start;i<nums.length;++i) {
            path.add(nums[i]);
            backTrack(nums, i+1);
            path.remove(path.size()-1);
        }
    }

    public static void testSample() {
        System.out.println(subsets(new int[]{1,2,3}));
    }
}
