import java.util.Scanner;

public class MilkDelivery {
    public static int totalUniqueDistance(int num, int[][] houses) {
        int[] minHouse = new int[100001]; // Assuming the maximum house number is 100000
        int[] maxHouse = new int[100001];

        // Initialize the arrays with maximum and minimum values
        for (int i = 0; i < 100001; i++) {
            minHouse[i] = Integer.MAX_VALUE;
            maxHouse[i] = Integer.MIN_VALUE;
        }

        // Update the arrays with actual values from the input
        for (int i = 0; i < num; i++) {
            minHouse[houses[i][0]] = Math.min(minHouse[houses[i][0]], houses[i][1]);
            maxHouse[houses[i][0]] = Math.max(maxHouse[houses[i][0]], houses[i][1]);
        }

        // Calculate the total unique distance
        int totalDistance = 0;
        int prevHouse = 0;
        for (int i = 1; i < 100001; i++) {
            if (minHouse[i] != Integer.MAX_VALUE) {
                totalDistance += Math.abs(i - prevHouse);
                prevHouse = maxHouse[i];
            }
        }

        return totalDistance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int[][] houses = new int[num][2];
        for (int i = 0; i < num; i++) {
            houses[i][0] = scanner.nextInt();
            houses[i][1] = scanner.nextInt();
        }

        int result = totalUniqueDistance(num, houses);
        System.out.println(result);

        scanner.close();
    }
}
