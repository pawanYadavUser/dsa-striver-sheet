import java.util.Arrays;

public class ceilTheFloor {
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        int[] result = new int[2];
        // Wriute your code here.
        int low = 0, high = a.length - 1;

        if (a[0] > x) {
            // floor
            result[0] = -1;

        } else {
            // floor
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (a[mid] <= x) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            // for floor
            result[0] = a[high];

        }

        if (a[n - 1] < x) {
            // ceiling
            result[1] = -1;

        } else {
            // calculating ceiling now
            low = 0;
            high = a.length - 1;
            // ceiling
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (a[mid] >= x) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // for floor
            result[1] = a[low];
        }

        return result;
    }

    public static int[] getFloorAndCeil2(int[] arr, int length, int target) {
        int[] result = { -1, -1 };
        // find the floor
        int start = 0, end = length - 1;
        if (arr[0] > target) {
            result[0] = -1;
        } else {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            result[0] = arr[end];
        }

        // find the floor
        start = 0;
        end = length - 1;
        if (arr[end] < target) {
            result[1] = -1;
        } else {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            result[1] = arr[start];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 4, 7, 8, 10 };
        System.out.println("Ceil and floor" + Arrays.toString(getFloorAndCeil2(arr, 6, 8)));
        System.out.println("Ceil and floor" + Arrays.toString(getFloorAndCeil(arr, 6, 8)));

    }

}