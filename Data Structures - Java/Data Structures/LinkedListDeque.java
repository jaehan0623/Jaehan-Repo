public class LinkedListDeque<T> {
    private class Node {
        private T item;
        private Node next;
        private Node prev;

        Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }
        Node(T i) {
            item = i;
        }
        public T getItem(int index) {
            if (index == 0) {
                return item;
            } else {
                return this.next.getItem(index - 1);
            }
        }
    }
    private Node sentinel;
    private Node last;
    private int size;

    /* @ josh hug's video */
    public LinkedListDeque() {
        sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        last = sentinel;
    }
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        last = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i));
        }
    }
    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
        if (last == sentinel) {
            last = sentinel.next;
        }
    }
    public void addLast(T item) {
        last.next = new Node(item, sentinel, last);
        last = last.next;
        sentinel.prev = last;
        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        Node current = sentinel.next;
        for (int n = 1; n <= size; n++) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T returnValue = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        last = sentinel.prev;
        return returnValue;
    }
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        T returnValue = last.item;
        last = last.prev;
        last.next = sentinel;
        sentinel.prev = last;
        size -= 1;
        return returnValue;
    }
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node answer = sentinel.next;
        while (index != 0) {
            answer = answer.next;
            index--;
        }
        return answer.item;
    }
    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        } else {
            return sentinel.next.getItem(index);
        }
    }
}




