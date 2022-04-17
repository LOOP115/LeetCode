import java.util.Stack;

// Attempt 1  和官方第一种解法一样  入队 O(n) 出队 O(1)  100%
class MyQueue {

    private final Stack<Integer> stack1 = new Stack<>();
    private final Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {
    }

    public void push(int x) {
        // Pop all the elements in stack 1 and push them to stack 2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        // Push x to stack 1
        stack1.push(x);
        // Pop all the elements in stack 2 and push them to stack 1
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.empty();
    }

}


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


// Solution 2  摊还分析  入队 O(1) 出队 O(1)  100%
class MyQueue2 {

    private final Stack<Integer> stack1 = new Stack<>();
    private final Stack<Integer> stack2 = new Stack<>();
    private int front;

    public MyQueue2() {
    }

    public void push(int x) {
        // 用 front 记录 stack1 中第一个被 push 的元素
        if (stack1.empty()) {
            this.front = x;
        }
        stack1.push(x);
    }

    // 出列时利用 stack2 进行摊还
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            return stack2.peek();
        }
        return front;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
