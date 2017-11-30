package samples.algorithms.cracking;

import java.util.*;

public class Stacks {

	public static void main(String... args) {

		MultiStack<Integer> ms = new MultiStack<>(3);

		ms.push(1);
		ms.push(2);
		ms.push(3);
		ms.push(4);
		ms.push(5);
		ms.push(6);
		ms.push(7);
		ms.push(8);
		System.out.println(ms);

		System.out.println("popAt(0): " + ms.popAt(0));
		System.out.println(ms);

		System.out.println("popAt(1): " + ms.popAt(1));
		System.out.println(ms);

		System.out.println("pop(): " + ms.pop());
		System.out.println(ms);
	}
}

class MultiStack<T> {

	private List<Node<T>> stacks;
	private int maxSize;
	private int size;

	public MultiStack(int maxSize) {
		this.stacks = new ArrayList<>();
		this.maxSize = maxSize;
		this.size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void push(T value) {

		int index = (size-1)/maxSize;

		// Connect new node to previous
		Node<T> last = index < stacks.size() ? stacks.get(index) : null;
		Node<T> n = new Node<>(value, last, null);
		if (last != null) {
			last.next = n;
		}

		size++;
		int newIndex = (size-1)/maxSize;

		// Move stack pointer or create another one
		if (newIndex == index && size > 1) {
			stacks.set(index, n);
		} else {
			stacks.add(n);
		}
	}

	public T pop() {

		if (isEmpty()) throw new IllegalStateException("stack is empty");

		int index = (size-1)/maxSize;

		Node<T> n = stacks.get(index);

		Node<T> prev = n.prev;
		if (prev != null) {
			prev.next = null;
		}

		size--;
		int newIndex = (size-1)/maxSize;

		// Move stack pointer or remove stack
		if (newIndex == index) {
			stacks.set(index, prev);
		} else {
			stacks.remove(index);
		}

		return n.value;
	}

	public T popAt(int index) {

		int lastIndex = stacks.size()-1;

		if (index == lastIndex) {
			return pop();
		}

		Node<T> n = stacks.get(index);

		// Remove node from stack
		n.prev.next = n.next;
		n.next.prev = n.prev;

		// Move pointers up (except last one)
		for (int i=index; i<lastIndex; i++) {
			stacks.set(i, stacks.get(i).next);
		}
		// Last pointer might be removed if previous overlaps it
		if (stacks.get(lastIndex) == stacks.get(lastIndex-1)) {
			stacks.remove(lastIndex);
		}

		size--;

		return n.value;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < stacks.size(); i++) {
			sb.append(i).append(": ");
			Node<T> node = stacks.get(i);
			Node<T> prev = i > 0 ? stacks.get(i-1) : null;
			while (node != prev) {
				sb.append(node.value).append(" ");
				node = node.prev;
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	static class Node<T> {

		T value;
		Node<T> prev;
		Node<T> next;

		Node(T value, Node<T> prev, Node<T> next) {
			this.value = value;
			this.prev = prev;
			this.next = next;
		}
	}

}

