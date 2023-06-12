import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lowerRange = scanner.nextInt();
        int higherRange = scanner.nextInt();
        int range = scanner.nextInt();
        int target = scanner.nextInt();

        int minimumSeed = 0;
        int highestValue = target;

        Random random;
        for (int i = lowerRange; i <= higherRange; i++) {
            random = new Random(i);

            int max = 0;
            for (int j = 0; j < range; j++) {
                int randomNumber = random.nextInt(target);
                if (randomNumber > max) {
                    max = randomNumber;
                }
            }

            if (highestValue > max) {
                highestValue = max;
                minimumSeed = i;
            }
        }

        System.out.println(minimumSeed);
        System.out.println(highestValue);
    }
}