
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(1);
        minHeap.add(4);
        minHeap.add(3);
        minHeap.add(2);
        minHeap.add(7);
        minHeap.add(6);
        minHeap.add(5);
        minHeap.add(8);

        System.out.println(minHeap);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(1);
        maxHeap.add(4);
        maxHeap.add(3);
        maxHeap.add(2);
        maxHeap.add(7);
        maxHeap.add(6);
        maxHeap.add(5);
        maxHeap.add(8);

        System.out.println(maxHeap);

        // get root node of maxHeap
        System.out.println(maxHeap.poll());
        // remove the element from maxheap
        maxHeap.remove(5);
        System.out.println(maxHeap);

        // access the elements
        System.out.println(maxHeap.peek());

        Iterator<Integer> itr = maxHeap.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // removing all elements from the queue
        maxHeap.clear();

        // checking if the queue is empty
        System.out.println(maxHeap.isEmpty());

    }

}
