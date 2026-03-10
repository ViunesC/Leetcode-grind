package Medium;

import java.util.ArrayList;
import java.util.List;

public class q216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        return backTrack(1,k,n);
    }

    private static List<List<Integer>> backTrack(int start, int k, int target) {
        if (k == 0) {
            if (target == 0) {
                List<List<Integer>> result = new ArrayList<>();
                result.add(new ArrayList<>());
                return result;
            }
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i=start;i<=9;++i) {
            if (i > target)
                // pruning
                break;

            List<List<Integer>> current = backTrack(i+1,k-1,target-i);

            for (List<Integer> comb : current)
                comb.add(i);

            result.addAll(current);
        }

        return result;
    }

    public static void testSample() {
        System.out.println(combinationSum3(4,1));
    }
}
