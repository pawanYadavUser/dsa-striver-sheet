public class SearchElementInInfiniteArray {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 5, 6, 6, 6, 7, 7, 8, 9, 9, 10, 11, 12 };
        System.out.println(searchWindowProcess(arr, 7));
        System.out.println(searchWindowProcess(arr, 6));
        System.out.println(searchWindowProcess(arr, 5));
    }

    public static int searchWindowProcess(int[] arr, int target) {
        int start = 0, end = 1;
        while (arr[end] < target) {
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        int ans = binarySearch(arr, start, end - 1, target, true);
        return ans;
    }

    public static int binarySearch(int[] arr, int start, int end, int target, boolean searchFromBegining) {
        // int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                if (searchFromBegining) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
