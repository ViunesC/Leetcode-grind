package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        int left, right;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp;
        for (int a=0;a<nums.length;++a) {
            // for every a
            if (nums[a] > target && (nums[a] > 0 || target > 0))
                return result;

            if (a > 0 && nums[a] == nums[a-1])
                continue;

            for (int b=a+1;b<nums.length;++b) {
                // for every b

                if (nums[a] + nums[b] > target && nums[a] + nums[b] >= 0) {
                    break;
                }

                if (b > a+1 && nums[b] == nums[b-1])
                    continue;

                left = b+1;
                right = nums.length-1;
                while (left < right) {
                    // System.out.println("a="+a+",b="+b+",c="+left+",d="+right);

                    if (nums[a] + nums[b] + nums[left] + nums[right] > target)
                        right--;
                    else if (nums[a] + nums[b] + nums[left] + nums[right] < target)
                        left++;
                    else {
                        temp = new ArrayList<>();
                        temp.add(nums[a]);
                        temp.add(nums[b]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        result.add(temp);

                        while (left < right && nums[left] == nums[left+1])
                            left++;
                        while(left < right && nums[right] == nums[right-1])
                            right--;

                        left++;
                        right--;
                    }
                }

            }

        }

        return result;
    }

    public static void testSample() {
        // [-2,-1,0,0,1,2]
        // [-2,0,0,2]
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
    }
}
