package Medium;

import java.util.*;

public class q15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp;

        int left, right;
        for (int i=0;i<nums.length;++i) {
            if (nums[0] > 0)
                return result;

            if (i > 0 && nums[i] == nums[i-1])
                continue;

            left = i+1;
            right = nums.length-1;

            while (left < right) {
                if (nums[i]+nums[left]+nums[right] > 0)
                    right--;
                else if (nums[i]+nums[left]+nums[right] < 0)
                    left++;
                else {
                    temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);

                    result.add(temp);

                    // Remove duplicated b,c
                    while (left < right && nums[left] == nums[left+1])
                        left++;

                    while (left < right && nums[right] == nums[right-1])
                        right--;

                    right--;
                    left++;
                }
            }
        }

        return result;
    }

    public static void testSample() {
        List<List<Integer>> result = threeSum(new int[]{-1,0,1,2,-1,-4});

        System.out.println(result);
    }
}
