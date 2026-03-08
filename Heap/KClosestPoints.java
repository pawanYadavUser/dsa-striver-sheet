// package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

// 🧩 Problem

// You are given an array of points points[i] = [x, y], and an integer k.
// Return the k closest points to the origin (0, 0).
// The distance from origin is calculated as:
// distance = x² + y²
// ⚙️ Heap-Based Approach(Max-Heap)
// Idea:
// Maintain a max-heap of size k.
// For each point:
// Compute its distance from the origin.
// Push it into the heap.
// If heap size exceeds k,remove the point with the largest distance.
// Finally,return the points remaining in the heap.
// Why max-heap?
// So we can efficiently remove the farthest point when the heap exceeds size k.

// 🧮 Time and Space Complexity
// Operation	Complexity
// Building heap	O(N log K)
// Space	O(K)

// why i cant use PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
// in above heap implementation based solution

// 🔹 The code you mentioned:
// PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

// At first glance, it looks fine — you’re trying to reverse the order to make a max heap.
// But the issue is:
// ➡️ Collections.reverseOrder() only works for objects that implement Comparable (like Integer, String, etc.)
// ➡️ int[] does not implement Comparable, so Java has no idea how to compare two arrays.

// 🧨 What actually happens
// When you try to insert elements (like int[]{1,2}), the JVM will throw:
// java.lang.ClassCastException: class [I cannot be cast to class java.lang.Comparable
// Because [I is the JVM name for int[], and Java can’t compare two arrays by default.
// ✅ The correct way — provide a custom comparator

// You must tell Java how to compare one point with another — typically using their distance from origin.

public class KClosestPoints {

    public static int[][] kClosestPoints(int[][] points, int k) {
        // max heap storing [distance, x, y]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> b[0] - a[0] // larger distance first
        );

        for (int[] p : points) {
            int dist = p[0] * p[0] + p[1] * p[1];
            maxHeap.offer(new int[] { dist, p[0], p[1] });

            // keep only k elements
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // prepare result
        int[][] result = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            result[i++] = new int[] { top[1], top[2] };
        }

        return result;

    }

    public static void main(String[] args) {
        int[][] points = { { 3, 3 }, { 5, -1 }, { 2, 4 } };
        int k = 2;

        int[][] result = kClosestPoints(points, k);
        System.out.println("K closest points : " + Arrays.deepToString(result));
        System.out.println("K closest points : " + Arrays.toString(result));
    }

}
