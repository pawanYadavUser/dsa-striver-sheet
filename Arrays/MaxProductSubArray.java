// package Arrays;

public class MaxProductSubArray {

    public static int maxSubArrayProduct(int[] arr) {
        int ans = 0;

        if (arr.length == 1) {
            return arr[0];
        }

        int currentProduct = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                currentProduct *= arr[i];
                ans = Math.max(ans, currentProduct);

            } else {
                currentProduct = 1;
            }

            // dont dare to put the condition of ans = Math.max(ans, currentProduct);
            // outside
            // else you will misse the zero value edge case.
            //the 2nd array 

        }

        return ans;

    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, -2, 4 };
        System.out.println("Max product subArray : " + maxSubArrayProduct(arr));
        int[] arr2 = { -2, 0, -1 };
        System.out.println("Max product subArray : " + maxSubArrayProduct(arr2));

    }

}
