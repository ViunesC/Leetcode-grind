package Medium;

import java.util.Arrays;

public class q189 {
    public static void rotate(int[] nums, int k) {
        // brute-force O(n^k)
//        int next, temp;
//
//        for (int i=0;i<k;++i) {
//            next = nums[0];
//            for (int j=0;j<nums.length;++j) {
//                temp = nums[(j+1) % nums.length];
//                nums[(j+1) % nums.length] = next;
//                next = temp;
//            }
//        }

        // triple-reversing method
        // suppose we have N (length of nums) and k
        // right-rotating array is basically move all elements between [N-k, N) to the front,
        // and move all elements between [0,N-k) to back of [N-k,N) subarray
        // we can achieve that by reversing the entire array, then reverse [0,N-k) and [N-k,N) individually

        if (k > nums.length)
            k = k % nums.length;

        reverse(nums,0,nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private static void reverse(int[] arr, int start, int end) {

        int i=start, j=end;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void testSample() {
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
