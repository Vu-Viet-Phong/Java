package iu.dsa.tung.labs.lab04;

class Node<T> {
	private Node<T> next = null;
	private T data = null;

	public Node(T data) {
		this.data = data;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public Node<T> getNext() {
		return next;
	}

	@Override
	public Node<T> clone() {
		Node<T> cloner = new Node<T>(this.data);
		cloner.setNext(getNext());
		return cloner;
	}

	@Override
	public String toString() {
		if (this.data == null) {
			return "null";
        }
		return this.data.toString();
	}
}

public class CircularLinkedList<T> {
	private Node<T> current = null;
	private Node<T> head = null;
	private Node<T> tail = null;
	private Integer size = 0;

	public CircularLinkedList() {}

    public Node<T> getCurrent() {
		return current;
	}
	
	public void setCurrent(Node<T> current) {
		this.current = current;
	}

	public Integer size() {
		return size;
	}

	public Boolean isEmpty() {
		if (head == null) {
			return true;
        } else {
			return false;
	    }
    }
	
	public void insert(T data) {
		if (head == null) {
			Node<T> newLink = new Node<T>(data);
			head = newLink;
			current = newLink;
			tail = newLink;
			current.setNext(head);
		} else {
			current.setNext(new Node<T>(data));
			current.getNext().setNext(head);
			current = current.getNext();
			tail = current;
		}
		size++;
	}

	public Node<T> search(T data) {
		Node<T> trace = head;

		if (head == null) {
			return null;
        }

		do {
			if (trace.getData() == data) {
				return trace;
            }
			trace = trace.getNext();
		} while (trace != head);

		return null;
	}

	public void step() {
		current = current.getNext();
	}

	public void delete(T data) {
		Node<T> trace = head;
		Node<T> prev = tail;

		if (head == null) {
			return;
        }

		if (head.getNext() == head && head.getData() == data) {
			head = null;
			return;
		}
		

		if (head.getNext() != head) {
			if (head.getData() == data) {
				trace = head.getNext();
				prev.setNext(head.getNext());
				size--;
			}

			do {
				if (trace.getData() == data) {
					prev.setNext(trace.getNext());
					trace = trace.getNext();
					size--;
				}
				prev = prev.getNext();
				trace = trace.getNext();
			} while (trace != head);
		}
	}

	public void display() {
		System.out.println("CircularLinkedList: " + this.toString());
	}

	@Override
	public String toString() {
		String string = new String();
		Node<T> trace = head;

		if (trace == null) {
			return "null";
        }

		do {
			string += trace.toString() + " ";
			trace = trace.getNext();
		} while (trace != head);

		return string;
	}
}