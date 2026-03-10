package Easy;

public class q941 {
    public static boolean validMountainArray(int[] arr) {
        // two edge cases to be considered:
        // 1. Entire arr is monotonic increasing
        // 2. Entire arr is monotonic decreasing
        // we will use two-pointer

        if (arr.length < 3) { // 此时，一定不是有效的山脉数组
            return false;
        }
        // 双指针
        int left = 0;
        int right = arr.length - 1;
        // 注意防止指针越界
        while (left + 1 < arr.length && arr[left] < arr[left + 1]) {
            left++;
        }
        // 注意防止指针越界
        while (right > 0 && arr[right] < arr[right - 1]) {
            right--;
        }
        // 如果left或者right都在起始位置，说明不是山峰
        if (left == right && left != 0 && right != arr.length - 1) {
            return true;
        }
        return false;
    }

    public static void testSample() {
        System.out.println(validMountainArray(new int[]{0,2,3,4,5,2,1,0}));
    }
}
