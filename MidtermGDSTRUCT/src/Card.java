public class Card {
    private String name;

    // Constructor
    public Card(String name) {
        this.name = name;
    }

    // Getter method to get the card's name
    public String getName() {
        return name;
    }

    // Allows us to print the card name directly
    @Override
    public String toString() {
        return name;
    }
}
