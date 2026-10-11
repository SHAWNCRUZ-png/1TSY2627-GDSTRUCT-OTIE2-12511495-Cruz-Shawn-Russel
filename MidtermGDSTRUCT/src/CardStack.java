public class CardStack {
    private Card[] stackArray;
    private int top;
    private int capacity;

    // Constructor to initialize the stack size
    public CardStack(int capacity) {
        this.capacity = capacity;
        this.stackArray = new Card[capacity];
        this.top = -1; // -1 means the stack starts completely empty
    }

    // PUSH: Add an item to the top of the stack
    public void push(Card card) {
        if (isFull()) {
            System.out.println("Stack Overflow: Cannot add card.");
            return;
        }
        stackArray[++top] = card;
    }

    // POP: Remove and return the top item
    public Card pop() {
        if (isEmpty()) {
            return null; // Stack Underflow
        }
        Card removedCard = stackArray[top];
        stackArray[top] = null; // Clear the memory reference
        top--;
        return removedCard;
    }

    // Check if the stack has no items
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is completely full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Get the current number of cards in this stack
    public int size() {
        return top + 1;
    }

    // Utility to show all cards currently in the stack
    public void displayStack() {
        if (isEmpty()) {
            System.out.print("[Empty]");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i]);
            if (i < top) {
                System.out.print(", ");
            }
        }
    }
}
