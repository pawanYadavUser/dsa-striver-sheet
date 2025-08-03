public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int pivotIndex = findPivot(nums);
        if (pivotIndex == -1) {
            // if no pivot then array is not rotated and first element is the smallest
            return nums[0];
        } else {
            // if pivot is present , next element to the pivot is the smallest
            return nums[pivotIndex + 1];
        }
    }

    public static int findPivot(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if ((mid < end) && (nums[mid] > nums[mid + 1])) {
                return mid;

            } else if ((mid > start) && (nums[mid] < nums[mid - 1])) {
                return mid - 1;

            } else if (nums[mid] > nums[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return -1;
    }
}