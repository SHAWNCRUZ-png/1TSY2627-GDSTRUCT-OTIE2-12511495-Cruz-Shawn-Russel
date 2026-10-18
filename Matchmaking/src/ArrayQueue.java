public class ArrayQueue {
    private Player[] elements;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.elements = new Player[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(Player item) {
        if (size == capacity) {
            System.out.println("Queue is full! Cannot add " + item.getName());
            return;
        }
        rear = (rear + 1) % capacity;
        elements[rear] = item;
        size++;
    }

    public Player dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        Player removedItem = elements[front];
        elements[front] = null;
        front = (front + 1) % capacity;
        size--;
        return removedItem;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
