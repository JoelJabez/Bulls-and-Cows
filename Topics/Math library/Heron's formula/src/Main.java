import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int x = scanner.nextInt();
        final int y = scanner.nextInt();
        final int z = scanner.nextInt();

        final double p = (x + y + z) / 2.0;

        final double result = Math.sqrt(p * ((p - x) * (p - y) * (p - z)));
        System.out.println(result);
    }
}