package Medium;

public class q134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int currSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i=0;i<gas.length;++i) {
            currSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (currSum < 0) {
                // if currSum < 0, it means that we have to start at i + 1 instead of [0,i]
                // because start at any station within 0 and i will lead to insufficient fuel
                start = i + 1;
                currSum = 0;
            }
        }

        if (totalSum < 0) return -1;

        return start;
    }

    public static void testSample() {
        System.out.println(canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
    }
}
