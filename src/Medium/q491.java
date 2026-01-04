package Medium;

import java.util.*;

public class q491 {
    private static List<Integer> path = new ArrayList<>();
    private static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> findSubsequences(int[] nums) {
        backTrack(nums, 0);
        return result;
    }

    private static void backTrack(int[] nums, int start) {
        if (path.size() > 1)
            result.add(new ArrayList<>(path));

        Map<Integer, Integer> used = new HashMap<>();
        for (int i=start;i<nums.length;++i) {
            if (!path.isEmpty() && nums[i] < path.get(path.size()-1))
                // if current element is smaller than last element in the path
                // then skip the element
                continue;

            if (used.getOrDefault(nums[i], 0) >= 1)
                // if the element has been searched within same tree level
                // skip the element
                continue;

            path.add(nums[i]);
            used.put(nums[i], used.getOrDefault(nums[i], 0) + 1);

            backTrack(nums, i+1);

            path.remove(path.size()-1);
        }
    }

    public static void testSample() {
        System.out.println(findSubsequences(new int[]{4,6,7,7}));
    }
}
