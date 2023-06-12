import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double gravity = 9.8;

        double densityOfLiquid = scanner.nextDouble();
        double heightOfLiquidColumn = scanner.nextDouble();

        double liquidPressure = densityOfLiquid * gravity * heightOfLiquidColumn;

        System.out.printf("%.4f\n", liquidPressure);
    }
}