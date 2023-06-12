import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double firstVectorX = scanner.nextDouble();
        final double firstVectorY = scanner.nextDouble();

        final double secondVectorX = scanner.nextDouble();
        final double secondVectorY = scanner.nextDouble();

        final double dotProduct = firstVectorX * secondVectorX + firstVectorY * secondVectorY;

        final double firstVectorLength = Math.sqrt(Math.pow(firstVectorX, 2) + Math.pow(firstVectorY, 2));
        final double secondVectorLength = Math.sqrt(Math.pow(secondVectorX, 2) + Math.pow(secondVectorY, 2));

        final double result = Math.toDegrees(Math.acos(dotProduct / (firstVectorLength * secondVectorLength)));

        System.out.println((int) result);
    }
}