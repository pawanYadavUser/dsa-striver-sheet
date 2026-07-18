import java.util.Collections;
import java.util.PriorityQueue;

class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        // create max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // insert elements into it
        for (int element : nums) {
            maxHeap.offer(element);
        }

        // remove k-1 elements from the priority queue top position
        int i = 0;
        while (i < k - 1) {
            maxHeap.poll();
            i++;
        }

        // now fetch the kth largest element from the maxHeap
        return maxHeap.peek();
    }
}