
import java.util.Arrays;

// package Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] arr) {
        int size = arr.length;
        int[] left = new int[size];
        int[] right = new int[size];
        int[] result = new int[size];

        left[0] = 1;
        for (int i = 1; i < size; i++) {
            left[i] = left[i - 1] * arr[i - 1];
        }

        right[size - 1] = 1;
        for (int j = size - 2; j >= 0; j--) {
            right[j] = right[j + 1] * arr[j + 1];
        }

        for (int i = 0; i < size; i++) {
            result[i] = left[i] * right[i];
        }

        return result;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };

        // left product array:
        // ip: {1,2,3,4}
        // {1,1,2,6}

        // right product array
        // ip: {1,2,3,4}
        // {24,12,4,1}

        // ans
        // left : {1,1,2,6}
        // right: {24,12,4,1}
        // ans : {24, 12, 8, 6}
        System.out.println("product arr except self: " + Arrays.toString(productExceptSelf(arr)));
        int[] arr2 = { -1, 1, 0, -3, 3 };
        System.out.println("product arr except self: " + Arrays.toString(productExceptSelf(arr2)));
    }

}
