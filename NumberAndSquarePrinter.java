public class NumberAndSquarePrinter {
    public static void main(String[] args) {
        int upperLimit = 20;

        System.out.println("=== NUMBER & SQUARE PRINTER ===");
        System.out.println("Number\t|\tSquare");
        System.out.println("------------------------");

        for (int i = 1; i <= upperLimit; i++) {
            int square = i * i;
            System.out.println(i + "\t|\t" + square);
        }
    }
}
