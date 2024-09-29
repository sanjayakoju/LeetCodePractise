package practise;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueues {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    // Push operation
    public void push(int value) {
        queue2.add(value);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Pop operation
    public int pop() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue1.poll();
    }

    // Peek Operation
    public int peek() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue1.peek();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.peek());

    }
}

