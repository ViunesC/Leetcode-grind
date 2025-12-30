package Medium;


import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 77: Combination
 * @author Viunec
 */
public class q77 {
    private static List<Integer> path = new ArrayList<>();
    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        combineUtil(n, k, 1);
        return res;
    }

    private static void combineUtil(int n, int k, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=start;i<=n;++i) {
            path.add(i); // process node
            combineUtil(n,k,i+1); // recursively process greater nodes
            path.remove(path.size()-1); // backtrack
        }
    }

    public static void testSample() {
        System.out.println(combine(4,2));
    }
}
