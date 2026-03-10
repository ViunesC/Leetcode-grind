package Easy;
import java.util.Arrays;
import java.util.HashSet;

public class q349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> e1 = new HashSet<>();
        HashSet<Integer> intersect = new HashSet<>();

        for (int i : nums1) {
            e1.add(i);
        }

        for (int i : nums2) {
            if (e1.contains(i))
                intersect.add(i);
        }

        int[] result = new int[intersect.size()];
        int i = 0;
        for (int e : intersect) {
            result[i++] = e;
        }

        return result;
    }

    public static void testSample() {
        System.out.println(Arrays.toString(intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }
}
