public class MaxPriorityQueue {
    private static final int MAX_SIZE = 100;  // Assuming a fixed size for the array
    private final int[][] queue;  // Each element is represented as an array [item, priority]
    private int front;
    private int rear;

    public MaxPriorityQueue() {
        this.queue = new int[MAX_SIZE][2];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % MAX_SIZE == front;
    }

    public void enqueueWithPriority(int item, int priority) {
        if (isFull()) {
            System.out.println("Priority queue is full. Cannot enqueue.");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            int i = rear;
            // Find the correct position based on priority
            while (i >= front && priority > queue[i][1]) {
                queue[(i + 1) % MAX_SIZE] = queue[i];
                i--;
            }
            rear = (rear + 1) % MAX_SIZE;
        }
        queue[rear][0] = item;
        queue[rear][1] = priority;
    }

    public int dequeueHighestPriority() {
        if (isEmpty()) {
            System.out.println("Priority queue is empty. Cannot dequeue.");
            return -1; // Assuming -1 is an invalid value for the queue
        }
        int removedItem = queue[front][0];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % MAX_SIZE;
        }
        return removedItem;
    }

    public static void main(String[] args) {
        // Example usage
        MaxPriorityQueue maxPriorityQueue = new MaxPriorityQueue();
        maxPriorityQueue.enqueueWithPriority(1, 3);
        maxPriorityQueue.enqueueWithPriority(2, 1);
        maxPriorityQueue.enqueueWithPriority(3, 5);

        System.out.println("Dequeued item with highest priority: " + maxPriorityQueue.dequeueHighestPriority());
    }
}
