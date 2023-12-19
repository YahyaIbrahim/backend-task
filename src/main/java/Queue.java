public class Queue {
    private static final int MAX_SIZE = 100;  // Assuming a fixed size for the array
    private final int[] queue;
    private int front;
    private int rear;

    public Queue() {
        this.queue = new int[MAX_SIZE];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % MAX_SIZE == front;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % MAX_SIZE;
        queue[rear] = item;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Assuming -1 is an invalid value for the queue
        }
        int removedItem = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % MAX_SIZE;
        }
        return removedItem;
    }

    public static void main(String[] args) {
        // Example usage
        Queue myQueue = new Queue();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);

        System.out.println("Dequeued item: " + myQueue.dequeue());
        System.out.println("Dequeued item: " + myQueue.dequeue());
    }
}
