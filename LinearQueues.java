class linearQueue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int currentSize;

    public linearQueue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    public boolean isFull() {
        return (currentSize == maxSize);
    }

    public int size() {
        return currentSize;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue more elements.");
            return;
        }

        rear = (rear + 1) % maxSize;
        queueArray[rear] = data;
        currentSize++;
        System.out.println("Enqueued element: " + data);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        }

        int dequeuedElement = queueArray[front];
        front = (front + 1) % maxSize;
        currentSize--;
        System.out.println("Dequeued element: " + dequeuedElement);
        return dequeuedElement;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek element.");
            return -1;
        }

        return queueArray[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        int count = 0;
        int index = front;
        while (count < currentSize) {
            System.out.print(queueArray[index] + " ");
            index = (index + 1) % maxSize;
            count++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        linearQueue queue = new linearQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        queue.dequeue();
        queue.display();
        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
    }
}

