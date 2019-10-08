public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int first = 3;

    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        items = (T []) new Object[other.items.length];

        for (int i = 0; i < items.length; i++) {
            items[i] = (T) other.items[i];
        }
        size = other.size;
        first = other.first;
    }

    private void resize(int capacity) {
        T[] a = (T []) new Object[capacity];
        System.arraycopy(items, first, a, 0, size - first);
        System.arraycopy(items, 0, a, size - first, first);
        first = 0;
        items = a;
    }
    private void reduce(int capacity) {
        T[] a = (T []) new Object[capacity];
        if (first + size - 1 > items.length) {
            int length = items.length;
            System.arraycopy(items, first, a, 0, length - first + 1);
            System.arraycopy(items, 0, a, length - first + 1, size - (length - first + 1));
        } else {
            System.arraycopy(items, first, a, 0, size);
        }
        first = 0;
        items = a;
    }
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        if (first == 0) {
            items[items.length - 1] = item;
            first = items.length - 1;
        } else {
            items[first - 1] = item;
            first -= 1;
        }
        size += 1;
    }
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
            items[size] = item;
        } else if (first + size >= items.length) {
            items[(first + size) % items.length] = item;
        } else {
            items[first + size] = item;
        }
        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        if (first + size > items.length) {
            for (int i = first; i < items.length; i++) {
                System.out.print(items[i] + " ");
            }
            for (int i = 0; i < (first + size) % items.length; i++) {
                System.out.print(items[i] + " ");
            }
        } else {
            for (int i = first; i < first + size; i++) {
                System.out.print(items[i] + " ");
            }
        }
        System.out.println();
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T answer = items[first];
        items[first] = null;
        if (first == items.length - 1) {
            first = 0;
        } else {
            first += 1;
        }
        size -= 1;
        double ratio = (double) size / (double) items.length;
        if (items.length >= 16 && ratio < 0.25) {
            reduce(items.length / 2);
        }

        return answer;
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T answer;
        if (first + size > items.length) {
            answer = items[(first + size - 1) % items.length];
            items[(first + size - 1) % items.length] = null;
        } else {
            answer = items[first + size - 1];
            items[first + size - 1] = null;
        }
        size -= 1;
        double ratio = (double) size / (double) items.length;
        if (items.length >= 16 && ratio < 0.25) {
            reduce(items.length / 2);
        }
        return answer;
    }
    public T get(int index) {
        if (first + index + 1 > items.length) {
            return items[(first + index) % items.length];
        } else {
            return items[first + index];
        }
    }
}

