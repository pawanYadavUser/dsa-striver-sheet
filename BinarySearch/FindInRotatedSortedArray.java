
import java.util.Arrays;

public class FindInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 6, 7, 0, 1, 2 };
        // System.out.printf("Index for target element %d is %d", 6,
        // searchElementInRotatedArray(arr, 6));
        // System.out.println();
        // System.out.printf("No of rotations : %d", countRotationsInArray(arr));

        int[] arr2 = { 2, 2, 2, 3, 4, 2 };
        System.out.println("pivot for arr:" + Arrays.toString(arr2) + " is " + findPivotWithDuplicateElements(arr2));
        int[] arr3 = { 2, 2, 2, 3, 4, 1 };
        System.out.println("pivot for arr:" + Arrays.toString(arr3) + " is " + findPivotWithDuplicateElements(arr3));
        int[] arr4 = { 5, 6, 7, 8, 1, 2, 3, 3, 3, 3, 3 };
        System.out.println("pivot for arr:" + Arrays.toString(arr4) + " is " + findPivotWithDuplicateElements(arr4));
        int[] arr5 = { 5, 6, 7, 8, 9, 9, 9, 9, 9, 9, 9, 9, 1, 2, 3, 3, 3, 3, 3 };
        System.out.println("pivot for arr:" + Arrays.toString(arr5) + " is " + findPivotWithDuplicateElements(arr5));
    }

    // search element after finding pivot
    public static int searchElementInRotatedArray(int arr[], int target) {
        // find pivot
        // int pivot = findPivot(arr);
        int pivot = findPivotWithDuplicateElements(arr);
        // System.out.printf("pivot element found at index : %d",pivot);
        // System.out.println();
        if (pivot == -1) {
            // do normal binary search
            return binarySearch(arr, target, 0, arr.length - 1);

        } else if (arr[pivot] == target) {
            return pivot;

        } else if (target >= arr[0]) {
            // because you will get elements greater than start i.e., arr[0] till pivot
            // since the array is rotated, after pivot, elements will be smaller than start.
            return binarySearch(arr, target, 0, pivot - 1);

        } else {
            // because all elements beyond pivot will be smaller than start element
            return binarySearch(arr, target, pivot + 1, arr.length - 1);
        }
    }

    public static int countRotationsInArray(int arr[]) {
        // Pivot+1 is the no of times rotation is made to given sorted array,
        // because as array is rotated, pivot will be moving to index 0,1,2 and so
        // on.........
        int pivotPosition = findPivot(arr);
        return pivotPosition + 1;
    }

    // find the pivot in the rotated sortedarray
    public static int findPivot(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                // if the middile element is the pivot itself.
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                // if the middle-1 element is the pivot itself.
                return mid - 1;
            } else if (arr[start] >= arr[mid]) {
                // if start element is greater than middle element, that means, all elements
                // after mid
                // till end will be less than start
                // as the array is sorted and we are somewhere right side of the pivot.
                // so go left
                end = mid - 1;
            } else {
                // if start element is less than the middle element, that means there are
                // elements beyond mid, which can be greater too.
                // and pivot is always the greatest element in the array.
                start = mid + 1;
            }
        }
        return -1;
    }

    // find the pivot in the rotated sortedarray
    public static int findPivotWithDuplicateElements(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                // if the middile element is the pivot itself.
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                // if the middle-1 element is the pivot itself.
                return mid - 1;
            } else if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // if elements at mid, start & end are equal , then skip the duplicates
                if (arr[start] > arr[start + 1]) {
                    // check if start is the pivot
                    return start;
                }
                start++;
                if (arr[end] < arr[end - 1]) {
                    // check if end is the pivot
                    System.out.println("Found the pivot!");
                    return end - 1;
                }
                end--;

            } else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                // left side is sorted and i am still inside the left part,
                // so pivot should be in right!
                start = mid + 1;

            } else {
                // mid is in right section of the pivot
                // and
                // because i want to move towards the pivot , always
                end = mid - 1;
            }
        }
        return -1;
    }

    // perform binary search
    public static int binarySearch(int arr[], int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
