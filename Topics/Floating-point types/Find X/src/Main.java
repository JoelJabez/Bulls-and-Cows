import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // x = (c - b) / a
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double x = 0;
        try {
            x = (c - b) / a;
        } catch (Exception e) {
            System.out.println("Can't divide with 0");
        }

        System.out.println(x);
    }
}