import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            double distance = Double.parseDouble(scanner.nextLine());
            double hours = Double.parseDouble(scanner.nextLine());

            System.out.println(distance / hours);
        } catch (Exception e) {
            System.out.println("That's not a number");
        }
    }
}