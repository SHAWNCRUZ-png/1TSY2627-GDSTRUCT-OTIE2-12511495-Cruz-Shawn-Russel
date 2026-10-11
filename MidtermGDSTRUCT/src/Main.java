import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    // Initialize the 3 required stacks with a max capacity of 30
    CardStack playerDeck = new CardStack(30);
    CardStack playerHand = new CardStack(30);
    CardStack discardPile = new CardStack(30);

    // Pool of card names to pull from randomly (with duplicate names allowed)
    String[] cardNames = {"Fireball", "Ice Blast", "Shield Block", "Healing Touch", "Sword Slash"};

    // Populate the player deck with exactly 30 cards
    for (int i = 0; i < 30; i++) {
      String randomName = cardNames[random.nextInt(cardNames.length)];
      playerDeck.push(new Card(randomName));
    }

    System.out.println("--- GAME INITIALIZED ---");
    System.out.println("Your 30-card deck is ready. Press Enter to start your first turn.");
    scanner.nextLine();

    int round = 1;

    // Main game loop: Runs until the player deck is empty
    while (!playerDeck.isEmpty()) {
      System.out.println("\n================= ROUND " + round + " =================");

      // Generate a random command: 0 = Draw, 1 = Discard, 2 = Get from Discard Pile
      int command = random.nextInt(3);
      int x = random.nextInt(5) + 1; // Random value from 1 to 5

      switch (command) {
        case 0: // DRAW CARDS
          System.out.println("COMMAND: Draw " + x + " card(s) from your deck.");
          for (int i = 0; i < x; i++) {
            if (!playerDeck.isEmpty()) {
              Card drawnCard = playerDeck.pop();
              playerHand.push(drawnCard);
            } else {
              System.out.println("-> Cannot draw! The deck has completely run out.");
              break;
            }
          }
          break;

        case 1: // DISCARD CARDS
          System.out.println("COMMAND: Discard " + x + " card(s) from your hand.");
          for (int i = 0; i < x; i++) {
            if (!playerHand.isEmpty()) {
              Card discardedCard = playerHand.pop();
              discardPile.push(discardedCard);
            } else {
              System.out.println("-> Cannot discard! Your hand is completely empty.");
              break;
            }
          }
          break;

        case 2: // RETRIEVE FROM DISCARD PILE
          System.out.println("COMMAND: Get " + x + " card(s) from the discarded pile.");
          for (int i = 0; i < x; i++) {
            if (!discardPile.isEmpty()) {
              Card retrievedCard = discardPile.pop();
              playerHand.push(retrievedCard);
            } else {
              System.out.println("-> Cannot retrieve! The discard pile is completely empty.");
              break;
            }
          }
          break;
      }

      // Display current game states
      System.out.println("\n--- Round Summary ---");
      System.out.print("Current Hand: ");
      playerHand.displayStack();
      System.out.println();
      System.out.println("Remaining cards in Deck: " + playerDeck.size());
      System.out.println("Cards in Discard Pile: " + discardPile.size());

      // Check if game should end immediately before waiting for user confirmation
      if (playerDeck.isEmpty()) {
        break;
      }

      // Prompt user input to go to the next turn
      System.out.print("\nPress Enter to proceed to the next turn...");
      scanner.nextLine();
      round++;
    }

    System.out.println("\n==========================================");
    System.out.println("GAME OVER! The player deck has been emptied.");
    System.out.println("==========================================");

    scanner.close();
  }
}
