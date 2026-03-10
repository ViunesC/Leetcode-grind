package Easy;
import java.util.ArrayList;
import java.util.List;

public class q77 {
    public static List<List<Integer>> combine(int n, int k) {
        return backTrack(1, n, k);
    }

    private static List<List<Integer>> backTrack(int start, int end, int k) {
        if (k == 0) {
            // if our backtrack tree reaches leaf node
            // return new arraylist (as vessel holding parent node's number)
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i=start;i<=end-k+1;++i) {
            // pruning here, for every starting point, if the # of element can be choosed
            // is smaller than # of element still needed to form a combination
            // then it can be pruned
            // e.g. n=4 k=2, 1-2,3,4 (3 > 1, not pruned)
            // 2-3,4 (2 > 1)
            // 3-4 (1 = 1)
            // 4 - ? (0 < 1), pruned
            List<List<Integer>> current = backTrack(i+1, end, k-1);
            for (List<Integer> comb : current)
                comb.add(0,i);

            result.addAll(current);
        }

        return result;
    }

    public static void testSample() {
        List<List<Integer>> res = combine(4,2);

        System.out.println(res);
    }
}
