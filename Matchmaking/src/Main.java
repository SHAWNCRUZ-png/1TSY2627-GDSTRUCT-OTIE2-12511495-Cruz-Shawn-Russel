import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayQueue matchmakingQueue = new ArrayQueue(50);
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int totalGamesCreated = 0;
        int targetGames = 10;
        int turnCount = 1;
        int playerUniqueId = 1;

        System.out.println("Matchmaking Simulator");
        System.out.println("Rules: At least 5 players are required to launch a match.");
        System.out.println("Goal: Reach " + targetGames + " matches total to finish.\n");

        while (totalGamesCreated < targetGames) {
            System.out.println("--- Turn " + turnCount + " ---");

            int newPlayersCount = random.nextInt(7) + 1;
            System.out.println(newPlayersCount + " new players entered the matchmaking pool.");

            for (int i = 0; i < newPlayersCount; i++) {
                Player newPlayer = new Player("Player_" + playerUniqueId);
                matchmakingQueue.enqueue(newPlayer);
                playerUniqueId++;
            }

            System.out.println("Current players waiting in queue: " + matchmakingQueue.size());

            while (matchmakingQueue.size() >= 5 && totalGamesCreated < targetGames) {
                totalGamesCreated++;
                System.out.println("\nMatch found! Launching Game #" + totalGamesCreated);
                System.out.print("Teams: ");

                for (int p = 0; p < 5; p++) {
                    Player player = matchmakingQueue.dequeue();
                    System.out.print("[" + player.getName() + "] ");
                }
                System.out.println("\n");
            }

            if (totalGamesCreated >= targetGames) {
                break;
            }

            System.out.print("Press Enter to progress to the next turn...");

            // This consumes any stray empty lines or inputs left behind
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            System.out.println();
            turnCount++;
        }

        System.out.println("=============================================");
        System.out.println("Simulation complete. " + targetGames + " matches formed successfully.");
        System.out.println("Remaining players left in queue: " + matchmakingQueue.size());
        System.out.println("=============================================");

        scanner.close();
    }
}
