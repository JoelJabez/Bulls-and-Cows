// You can experiment here, it won’t be checked

import java.util.Random;

public class Task {
	public static void main(String[] args) {
		Random random = new Random(100);

		for (int i = 100; i < 200; i++) {
			System.out.println(random.nextInt(i, 200));
		}
	}
}
