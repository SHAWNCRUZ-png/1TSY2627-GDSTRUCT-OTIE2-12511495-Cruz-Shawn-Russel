import java.util.Random;

public class Main {

    public static int elevatorSearch(int[] building, int target) {
        Random random = new Random();
        int topFloor = building.length - 1;
        int passCount = 1;

        while (true) {
            System.out.println("\n===== ELEVATOR PASS RUN #" + passCount + " =====");

            int currentFloor = 0;
            System.out.println("\nStarting Ascent from Ground Floor\n");

            while (currentFloor <= topFloor) {
                System.out.println("Elevator stopped at Floor Index: " + currentFloor);

                if (building[currentFloor] == target) {
                    return currentFloor;
                }

                int stepUp = random.nextInt(4) + 1;
                currentFloor += stepUp;
            }
            System.out.println("\nTarget not found. Starting Descent from Top Floor\n");
            currentFloor = topFloor;

            while (currentFloor >= 0) {
                System.out.println("Elevator stopped at Floor Index: " + currentFloor);

                if (building[currentFloor] == target) {
                    return currentFloor;
                }

                int stepDown = random.nextInt(4) + 1;
                currentFloor -= stepDown;
            }
            System.out.println("Missed the target floor this pass due to random gaps! Resetting elevator...");
            passCount++;
        }
    }
    public static void main(String[] args) {
        int[] buildingFloors = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        int target = 9;

        System.out.println("Building Size: " + buildingFloors.length + " floors.");
        System.out.println("Target floor value " + target + " is hidden at middle index 8.");

        int resultIndex = elevatorSearch(buildingFloors, target);

        System.out.println("\nSUCCESS! The Elevator Method landed on Floor Index: " + resultIndex);
    }
}
