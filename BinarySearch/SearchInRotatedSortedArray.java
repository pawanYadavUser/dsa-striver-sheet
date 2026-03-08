public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int arr1[] = { 11, 22, 33, 44, 55, 67, 1, 2, 3, 4, 5, 6, 7 };
        int target = 67;
        int pivot = findPivot(arr1, arr1.length);
        if (pivot == -1) {
            System.out.println("Target present at index: " + binarySearch(arr1, 0, arr1.length - 1, target));
        } else if (arr1[pivot] == target) {
            System.out.println("Target present at index : " + pivot);
        } else if (arr1[0] < arr1[pivot]) {
            System.out.println("Target present at index: " + binarySearch(arr1, 0, pivot - 1, target));
        } else {
            System.out.println("Target present at index: " + binarySearch(arr1, pivot + 1, arr1.length - 1, target));
        }
    }

    public static int findPivot(int arr[], int length) {
        // define start n end limits
        int start = 0, end = length - 1;
        // do the binary search part!
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // condition1
            if (arr[mid - 1] > arr[mid] && start < mid) {
                return mid - 1;

            } else if (arr[mid + 1] < arr[mid] && mid < end) {
                // condition2
                return mid;
            } else if (arr[start] >= arr[mid]) {
                // condition3
                end = mid - 1;
            } else {
                // condition4
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int arr[], int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}