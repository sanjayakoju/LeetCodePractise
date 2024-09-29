package practise;

import java.util.Stack;

class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Enqueue operation
    public void enqueue(int value) {
        stack1.push(value);
    }

    // Dequeue operation
    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Poll operation
    public int poll() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.poll());
        System.out.println(queue.dequeue());
    }
}

