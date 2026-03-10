package Medium;

import java.util.ArrayList;
import java.util.List;

public class q46 {
    private static List<Integer> path = new ArrayList<>();
    private static List<List<Integer>> result = new ArrayList<>();
    private static boolean[] used;

    public static List<List<Integer>> permute(int[] nums) {
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
            if (used[i])
                continue;

            path.add(nums[i]);
            used[i] = true;

            backTrack(nums);

            used[i] = false;
            path.remove(path.size()-1);
        }
    }

    public static void testSample() {
        System.out.println(permute(new int[]{1,2,3}));
    }
}
