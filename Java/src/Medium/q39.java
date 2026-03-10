package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q39 {

    private static List<List<Integer>> result = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, 0, target);
        return result;
    }

    private static void backTrack(int[] candidates, int start, int target) {
        if (target <= 0) {
            if (target == 0) {
                // System.out.println("FLAG");
                // Compare path to all in result, if not exist added into it.
                // Collections.sort(path);
                List<Integer> temp = new ArrayList<>(path);
                Collections.sort(temp);
                if (!isExisted(temp)) {
                    result.add(temp);
                    // System.out.println("RESULT:" + result);
                }
            }

            return;
        }

        for (int i=start;i<candidates.length;++i) {
            // System.out.println("Checking" + candidates[i] + ", current PATH: " + path);
            path.add(candidates[i]);
            backTrack(candidates,i,target-candidates[i]);
            path.remove(path.size()-1);
        }

    }

    private static boolean isExisted(List<Integer> current) {
        for (List<Integer> list : result) {
            // System.out.println("COMPARED RESULT: " + list);
            if (list.equals(current)) {
                // System.out.println("ITS EXISTED" + result);
                return true;
            }
        }

        return false;
    }

    public static void testSample() {
        System.out.println(combinationSum(new int[]{2,3,6,7},7));
    }
}
