import java.util.Scanner;

public class SumUntilSentinelValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        System.out.println("=== SUM UNTIL SENTINEL VALUE (-1) ===");
        System.out.println("Enter integers to add to the sum. Enter -1 to finish.");

        while (true) {
            System.out.print("Enter a number: ");
            int input = scanner.nextInt();

            if (input == -1) {
                break;
            }

            sum += input;
        }

        System.out.println("\nFinal Sum: " + sum);
        scanner.close();
    }
}
