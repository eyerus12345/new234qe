import java.util.Stack;

public class QueueUsingStacks<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void enqueue(T element) {
        stack1.push(element);
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return null;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek element.");
            return null;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public static void main(String[] args) {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Front element: " + queue.peek());  // Output: Front element: 10

        System.out.println("Dequeued element: " + queue.dequeue());  // Output: Dequeued element: 10
        queue.enqueue(40);
        System.out.println("Dequeued element: " + queue.dequeue());  // Output: Dequeued element: 20
    }
}
