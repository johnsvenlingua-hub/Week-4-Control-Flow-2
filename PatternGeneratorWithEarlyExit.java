public class PatternGeneratorWithEarlyExit {
    public static void main(String[] args) {
        int size = 5;

        System.out.println("=== PATTERN GENERATOR ===");

        for (int row = 1; row <= size; row++) {
            if (row == 3) {
                continue; 
            }

            for (int col = 1; col <= row; col++) {
                if (col > 3) {
                    break; 
                }

                System.out.print("* ");
            }

            System.out.println();
        }
    }
}
