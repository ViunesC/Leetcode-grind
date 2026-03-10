package Misc;

public class ClassicKnapsack {

    /**
     * 0-1 Knapsack
     * <p>
     * Given bag size and a list of item, each with its own weight and value,
     * return the maximum value obtainable given the bag size (allowable weight)
     *
     * @param size maximum weight that bag can hold
     * @param weights list of weights
     * @param values list of values
     * @return maximum value obtainable
     */
    public static int maxValue(int size, int[] weights, int[] values) {
        int[][] maxValuePerSize = new int[weights.length][size+1];

        for (int i=0;i<maxValuePerSize[0].length;++i) {
            if (i == 0)
                maxValuePerSize[0][i] = 0;
            else if (i >= weights[0])
                maxValuePerSize[0][i] = values[0];
        }

        for (int i=1;i<maxValuePerSize.length;++i) {
            for (int s=0;s<maxValuePerSize[0].length;++s) {
                if (s == 0)
                    maxValuePerSize[i][s] = 0;
                else if (s < weights[i])
                    maxValuePerSize[i][s] = maxValuePerSize[i-1][s];
                else
                    maxValuePerSize[i][s] = Math.max(maxValuePerSize[i-1][s], maxValuePerSize[i-1][s-weights[i]] + values[i]);
            }
        }

        return maxValuePerSize[maxValuePerSize.length-1][maxValuePerSize[0].length-1];
    }

    public static void testSample() {
        System.out.println(maxValue(4, new int[]{1,3,4}, new int[]{15,20,30}));
    }
}
