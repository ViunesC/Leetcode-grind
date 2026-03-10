package Misc;

public class CompleteKnapSack {

    /**
     * Complete Knapsack
     * <p>
     * Given bag size and a list of item, each with its own weight and value,
     * return the maximum value obtainable given the bag size (allowable weight)
     * item can be put in bag unlimited number of times
     *
     * @param size maximum weight that bag can hold
     * @param weights list of weights
     * @param values list of values
     * @return maximum value obtainable
     */
    public static int maxValue(int size, int[] weights, int[] values) {
        // 2D matrix solution
        int[][] maxValuePerSize = new int[weights.length][size+1];

        int capacity;
        for (int i=0;i<maxValuePerSize[0].length;++i) {
            capacity = i;
            while (capacity >= weights[0]) {
                capacity -= weights[0];
                maxValuePerSize[0][i] += values[0];
            }
        }

        for (int i=1;i<weights.length;++i) {
            for (int j=0;j<=size;++j) {
                if (j < weights[i])
                    maxValuePerSize[i][j] = maxValuePerSize[i-1][j];
                else
                    maxValuePerSize[i][j] = Math.max(maxValuePerSize[i-1][j], maxValuePerSize[i][j-weights[i]] + values[i]);
            }
        }

        return maxValuePerSize[maxValuePerSize.length-1][maxValuePerSize[0].length-1];
    }

    public static void testSample() {
        System.out.println(maxValue(5, new int[]{1,2,3,4}, new int[]{2,4,4,5}));
    }
}
