import java.util.*;

// Quickselect(O(n)average)
// If you want the most optimal(but trickier)one—use Quickselect(like quicksort partition).
// ⚡ Quickselect Approach — O(n) Average

// The idea is just like QuickSort, but we only “partially” sort to find the k smallest elements based on their distance from the origin.
// 🧩 Steps
// Pick a random pivot point
// Partition all points into two groups:
// Points closer than the pivot.
// Points farther than the pivot.
// Recurse only into the side that contains the k-th closest point.
// Once partition index == k → first k points are the answer.

// 🧮 Complexity
// Type	Complexity
// Time (avg)	O(n)
// Time (worst)	O(n²) (rare, if bad pivot every time)
// Space	O(1) (in-place)

// what is the purpose of using storeIndex here
// the storeIndex(also sometimes called partitionIndex or left pointer)is the heart of the Quickselect/Quicksort partition logic.
// 🧠 Conceptually
// When we pick a pivot, we want to rearrange elements so that:
// Everything smaller than or equal to pivot goes to the left
// Everything greater than pivot goes to the right
// But to do that in place (without extra arrays), we need a pointer that marks where the “smaller” section ends.
// That’s the storeIndex.

// 🔍 Step-by-step example
// Say you have distances:
// [18, 26, 20]   // pivot = 20
// and storeIndex = 0
// Now, loop through each element except the pivot:
// |  i  | value | ≤ pivot? | action               | array after swap | storeIndex |
// | :-: | :---- | :------- | :------------------- | :--------------- | :--------- |
// |  0  | 18    | ✅ yes    | swap arr[0] ↔ arr[0] | [18, 26, 20]     | 1          |
// |  1  | 26    | ❌ no     | do nothing           | [18, 26, 20]     | 1          |
// After loop ends, we put the pivot at the storeIndex position:
// swap arr[storeIndex] ↔ arr[end]
// [18, 20, 26]
// ✅ Now all elements left of index 1 are ≤ pivot.
// storeIndex = 1 → pivot’s final sorted position.
// | Term         | Meaning                                                             |
// | :----------- | :------------------------------------------------------------------ |
// | `storeIndex` | Keeps track of the boundary where smaller elements should be placed |
// | Purpose      | Allows partitioning **in place** without creating new arrays        |
// | After loop   | It points to pivot’s final sorted position                          |
// | Used in      | Both **Quicksort** and **Quickselect**                              |

// Q: but whats the need of swap action?
// 🧠 The main goal of partitioning
// We want to rearrange elements in such a way that:
// All elements ≤ pivot appear on the left side.
// All elements > pivot appear on the right side.
// But we want to do it in-place (i.e., without creating extra arrays).
// That’s where swapping comes in.

// 🧩Why do we need to swap?
// Because when we find a value smaller than the pivot later in the array,
// we need to move it toward the left section—just behind the last“smaller”element we’ve found so far.
// storeIndex tells us where that next smaller element should go.

// ⚙️ Example in action
// Let’s say our array is:
// [7, 2, 9, 4, 6]    pivot = 6
// storeIndex = 0
// pivot = arr[end] = 6
// |  i  | arr[i] | Compare with pivot | Action                 | Array after step | storeIndex |
// | :-: | :----- | :----------------- | :--------------------- | :--------------- | :--------- |
// |  0  | 7      | 7 > 6              | ❌ do nothing           | [7, 2, 9, 4, 6]  | 0          |
// |  1  | 2      | 2 ≤ 6              | ✅ swap arr[1] ↔ arr[0] | [2, 7, 9, 4, 6]  | 1          |
// |  2  | 9      | 9 > 6              | ❌ do nothing           | [2, 7, 9, 4, 6]  | 1          |
// |  3  | 4      | 4 ≤ 6              | ✅ swap arr[3] ↔ arr[1] | [2, 4, 9, 7, 6]  | 2          |
// After the loop, we swap the pivot into its place:
// swap(arr[2], arr[4]) → [2, 4, 6, 7, 9]
// ✅ Now all elements left of index 2 are ≤ pivot (6).

// 🧩 Without swapping?
// If you didn’t swap, you’d just know there’s a smaller element — but you wouldn’t move it into position.
// That means your “≤ pivot” section would be scattered throughout the array, and the partition would fail.
// So the algorithm couldn’t correctly isolate the k smallest elements or sort the array.

public class KClosestQuickSelect {

    public static int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    private static void quickSelect(int[][] points, int left, int right, int k) {
        if (left >= right)
            return;

        int pivotIndex = partition(points, left, right);
        int leftLength = pivotIndex - left + 1;

        if (k < leftLength) {
            quickSelect(points, left, pivotIndex - 1, k);
        } else if (k > leftLength) {
            quickSelect(points, pivotIndex + 1, right, k - leftLength);
        }
    }

    private static int partition(int[][] points, int left, int right) {
        int[] pivot = points[right];
        int pivotDist = distance(pivot);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (distance(points[i]) <= pivotDist) {
                swap(points, i, storeIndex);
                storeIndex++;
            }
        }
        swap(points, storeIndex, right);
        return storeIndex;
    }

    private static int distance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

    private static void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    public static void main(String[] args) {
        // int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 }, { 0, 1 }, { -1, -1 } };
        int[][] points = { { 1, 5 }, { 1, 4 }, { 1, 3 }, { 1, 2 } };
        int k = 3;

        int[][] result = kClosest(points, k);
        System.out.println("K Closest Points:");
        for (int[] p : result)
            System.out.println(Arrays.toString(p));
    }
}
