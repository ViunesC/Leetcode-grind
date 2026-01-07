package Medium;

public class q45 {
    public static int jump(int[] nums) {
        // we keep two pointers, currDist which is the distance already covered in previous searches
        // and nextDist which is the distance to be covered by current search
        // if we reach the furtherest point covered by currDist, and we did not touch on the last point
        // we will add a jump (which is mandatory if we want to proceed)
        // this style of preservative jump will ensure we have minimal jumps

        if (nums.length == 1) return 0;
        int jumps = 0;
        int currDist = 0, nextDist = 0;

        for (int i=0;i<nums.length;++i) {
            nextDist = Math.max(nextDist, nums[i] + i);

            if (i == currDist) {
                jumps++;
                currDist = nextDist;

                if (nextDist >= nums.length - 1) break;
            }
        }

        return jumps;
    }

    public static void testSample() {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
}
