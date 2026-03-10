package Easy;


public class q1207 {
    public static boolean uniqueOccurrences(int[] arr) {
        // count frequency of each number in arr in count[]
        // and check if frequency occurred in count with freq[]
        int[] count = new int[2001];
        boolean[] freq = new boolean[1002];

        for (int i=0;i<arr.length;++i) {
            count[arr[i] + 1000]++;
        }

        for (int i = 0;i<count.length; ++i) {
            if (count[i] != 0) {
                if (!freq[count[i]])
                    freq[count[i]] = true;
                else
                    return false;
            }
        }

        return true;
    }

    public static void testSample() {
        System.out.println(uniqueOccurrences(new int[]{1,2,2,1,1,3}));
    }
}
