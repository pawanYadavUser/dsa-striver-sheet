import java.util.Arrays;
import java.util.Scanner;

public class FindFirstAndLastOcuurenceOfElementInSortedArray {

    public static int[] searchElementStartAndEndIndex(int[] arr, int target) {
        int[] result = null;
        int end = -1;
        int start = binarySearch(arr, target, true);
        if (start != -1) {
            end = binarySearch(arr, target, false);
        }
        result = new int[] { start, end };
        return result;
    }

    public static int binarySearch(int[] arr, int target, boolean searchFromBegining) {
        int start = 0, end = arr.length - 1;
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

    public static void main(String[] args) {
        int arr[] = { 5, 7, 7, 8, 8, 10 };

        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();

        System.out.println(Arrays.toString(searchElementStartAndEndIndex(arr, target)));

        scanner.close();

    }

}
