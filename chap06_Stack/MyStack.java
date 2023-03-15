package chap06_Stack;

import java.util.ArrayList;
import java.util.Stack;

public class MyStack<T> {
    private ArrayList<T> stack = new ArrayList<>();

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MyStack<Integer> ms = new MyStack<>();
        ms.push(11);
        ms.push(13);
        System.out.println(ms.pop());
        ms.push(1999);
        System.out.println(ms.pop());
        System.out.println(ms.pop());

    }
}
