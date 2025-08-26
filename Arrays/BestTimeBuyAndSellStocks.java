// package Arrays;

public class BestTimeBuyAndSellStocks {

    public static int findMaxProfit(int[] arr) {
        int ans = 0, minSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int profit = arr[i] - minSoFar;
            if (profit > ans) {
                ans = profit;
            }
            minSoFar = Math.min(arr[i], minSoFar);
        }
        return ans;
    }

    public static void main(String[] args) {
        // array of stock prices repr price of stock at ith day
        int arr[] = { 7, 1, 5, 3, 6, 4 };
        // you want to buy a stock at a given day and sell it on some different future
        // day to
        // maximise ur profilt
        System.out.println("max profit possible : " + findMaxProfit(arr));

    }

}
