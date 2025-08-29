// package Arrays;

public class LargestSubArrSum {

    public static int largetArrSum(int[] arr) {
        int start = 0, end = 0, tempStart = 0;

        int maxSum = arr[0], currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // check if all numbers are negative : edge case
            if (arr[i] > currentSum + arr[i]) {
                currentSum = arr[i];
                tempStart = i;
            } else {
                currentSum += arr[i];
            }

            if (maxSum < currentSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
        System.out.print("[ ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(" ]");

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] arrAllnegative = { -2, -1, -3, -4, -1, -2, -1, -5, -4 };
        System.out.println("Max sub array sum : " + largetArrSum(arr));
        System.out.println("Max sub array sum : " + largetArrSum(arrAllnegative));
    }

}
