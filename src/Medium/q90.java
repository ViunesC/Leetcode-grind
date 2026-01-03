package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q90 {
    private static List<Integer> path = new ArrayList<>();
    private static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, 0, new boolean[nums.length]);
        return result;
    }

    private static void backTrack(int[] nums, int start, boolean[] used) {
        result.add(new ArrayList<>(path));

        for (int i=start;i<nums.length;++i) {
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1])
                continue;
            path.add(nums[i]);
            used[i] = true;
            backTrack(nums, i+1, used);
            path.remove(path.size()-1);
            used[i] = false;
        }

    }

    public static void testSample() {
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }
}
