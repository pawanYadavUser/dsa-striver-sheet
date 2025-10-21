import java.util.Arrays;

class RotateTheArray {
    static int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

    public static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void leftRotateWithReverseAlgo(int[] arr, int k) {
        if (k == 0) {
            return;
        }

        int size = arr.length - 1;
        k = k % size;

        reverse(arr, 0, k - 1);
        reverse(arr, k, size);
        reverse(arr, 0, size);
    }

    public static void rightRotateWithReverseAlgo(int[] arr, int k) {
        if (k == 0)
            return;

        int size = arr.length - 1;
        k = k % size;

        reverse(arr, 0, size - k);
        reverse(arr, size - k + 1, size);
        reverse(arr, 0, size);
    }

    public static void main(String[] args) {
        System.out.printf("left rotate the array by %d elements : ", 2);
        leftRotateWithReverseAlgo(arr, 2);
        System.out.println(Arrays.toString(arr));
        // right rotate the array now!
        System.out.printf("right rotate the array by %d elements : ", 2);
        rightRotateWithReverseAlgo(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}