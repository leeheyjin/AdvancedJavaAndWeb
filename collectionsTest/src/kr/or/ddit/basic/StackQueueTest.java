package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("가");
		stack.push("나");
		stack.push("다");
		stack.push("라");
		stack.push("마");
		System.out.println(stack);

		System.out.println("꺼낸 값: " + stack.pop());
		System.out.println(stack);
		stack.push("바");
		System.out.println(stack);
		
		System.out.println("peek(): " + stack.peek());
		System.out.println(stack);
		
		Queue<String> queue = new LinkedList<>();
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		queue.offer("D");
		queue.offer("E");
		System.out.println(queue);
		
		System.out.println(queue.poll());
		System.out.println(queue);
		
		System.out.println(queue.poll());
		System.out.println(queue);

		System.out.println(queue.peek());
		System.out.println(queue);
		
	}

}
