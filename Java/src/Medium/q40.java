package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q40 {
    private static List<List<Integer>> result = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // need to sort for following algorithm to work (it will compare adjacent element)
        boolean[] used = new boolean[candidates.length];
        // System.out.println(Arrays.toString(candidates));
        backTrack(candidates, used, 0, target);
        return result;
    }

    private static void backTrack(int[] candidates, boolean[] used, int start, int target) {
        if (target <= 0) {
            if (target == 0)
                result.add(new ArrayList<>(path));

            return;
        }

        for (int i=start;i<candidates.length;++i) {
            if (i > 0 && candidates[i] == candidates[i-1])
                if (!used[i-1])
                    // used[] is key to prevent duplicated search
                    // we want to avoid searching element with same value
                    // in same horizontal level (of the search tree)
                    // thus if current element = previous element, and used[previous] is false
                    // it means that we have already searched the previous element and backtracked back
                    // therefore we will just skip the current element
                    continue;

            path.add(candidates[i]);
            used[i] = true;

            backTrack(candidates, used, i+1,target-candidates[i]);

            path.remove(path.size()-1);
            used[i] = false;
        }
    }

    public static void testSample() {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }
}
