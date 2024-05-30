public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public CircularQueue(int capacity) {
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element.");
            return;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % queue.length;
        }

        queue[rear] = element;
        size++;
        System.out.println("Enqueued element: " + element);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        }

        int element = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % queue.length;
        }

        

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek element.");
            return -1;
        }

        return queue[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        int i = front;
        while (i != rear) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % queue.length;
        }
        System.out.println(queue[rear]);
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();  // Output: Queue elements: 10 20 30

        queue.dequeue();
        queue.display();  // Output: Queue elements: 20 30

        System.out.println("Front element: " + queue.peek());  // Output: Front element: 20
    }
}
