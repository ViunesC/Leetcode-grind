package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q47 {
    private static List<Integer> path = new ArrayList<>();
    private static List<List<Integer>> result = new ArrayList<>();
    private static boolean[] used;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backTrack(nums);
        return result;
    }

    private static void backTrack(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i=0;i<nums.length;++i) {
            if (used[i] || (i != 0 && nums[i] == nums[i-1] && !used[i-1]))
                continue;

            path.add(nums[i]);
            used[i] = true;

            backTrack(nums);

            used[i] = false;
            path.remove(path.size()-1);
        }
    }

    public static void testSample() {
        System.out.println(permuteUnique(new int[]{3,3,0,3}));
    }
}
