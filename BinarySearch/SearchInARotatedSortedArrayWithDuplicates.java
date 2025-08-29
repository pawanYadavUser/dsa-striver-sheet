public class SearchInARotatedSortedArrayWithDuplicates {
    public static void main(String[] args) {
        int[] arr = { 2, 2, 2, 2, 3, 4, 5, 6, 7, 1, 2, 2, 2, 2 };

        int pivot = findPivotWithDuplicates(arr);
        int result = 0, target = 2;
        if (pivot == -1) {
            System.out.println("pivot is : " + binarySearch(arr, target, 0, arr.length - 1));

        } else if (target == arr[pivot]) {
            System.out.println("pivot is : " + pivot);
        } else if (arr[0] <= target) {
            System.out.println("pivot is : " + binarySearch(arr, target, 0, pivot - 1));
        } else {
            System.out.println("pivot is : " + binarySearch(arr, target, pivot + 1, arr.length - 1));
        }

    }

    public static int findPivotWithDuplicates(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                // if the middile element is the pivot itself.
                return mid;
            } else if (start < mid && arr[mid - 1] > arr[mid]) {
                // if the middle-1 element is the pivot itself.
                return mid - 1;
            } else if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                if (arr[end - 1] > arr[end]) {
                    return end - 1;
                }
                end--;
            } else if (arr[start] > arr[mid] && mid > start) {
                // if start element is greater than middle element, that means, all elements
                // after mid till end will be less than start
                // as the array is sorted
                end = mid - 1;
            } else {
                // if start element is less than the middle element, that means there are
                // elements beyond mid, which can be greater too.
                // and pivot is always the greatest element in the array
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
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
