public class NumberOfOccurences {

    public static int countFreq(int[] arr, int target) {

        int[] result = { -1, -1 };
        // code here

        result[0] = binarySearch(arr, target, true);

        if (result[0] != -1) {

            result[1] = binarySearch(arr, target, false);
        }

        // System.out.printf("start : %d | end : %d \n", result[0], result[1]);

        return (result[0] != -1) ? (result[1] - result[0]) + 1 : 0;

    }

    public static int binarySearch(int arr[], int target, boolean searchStartIndex) {
        int low = 0, high = arr.length - 1, ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] < target) {
                low = mid + 1;

            } else if (arr[mid] > target) {
                high = mid - 1;

            } else {
                ans = mid;
                if (searchStartIndex) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 2, 2, 3 };
        int target = 4;
        System.out.println("frequency of target: " + target + " is " + countFreq(arr, target));

    }

}
