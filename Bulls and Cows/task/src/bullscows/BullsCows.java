package bullscows;

import java.util.*;

public class BullsCows {
	private static Random random;
	private static final ArrayList<Character> secretCodeList = new ArrayList<>();
	private static int rangeOfCharacters;

	private BullsCows() {}

	public static void StartGame() {
		SecretCodeLimit();

		StringBuilder secretCode = null;
		String stringSecretCodeLength = input("Input the length of the secret code:");
		int secretCodeLength = convertToInt(stringSecretCodeLength);

		if (secretCodeLength != -1) {
			String stringRangeOfCharacters = input("Input the number of possible symbols in the code:");
			boolean isSuccess = convertToInt(stringRangeOfCharacters, secretCodeLength);
			if (isSuccess) {
				secretCode = generateCode(secretCodeLength);
				printMessage(secretCodeLength);
			}
		}

		if (secretCode != null) {
			System.out.println("Okay, let's start a game!");

			int cowCounter;
			int bullCounter;
			int turn = 1;

			do {
				cowCounter = 0;
				bullCounter = 0;

				String inputCode = input("Turn " + turn + ":");
				HashSet<Integer> secretCodeDuplicates = groupDuplicates(inputCode);

				if (inputCode.length() == secretCode.length()) {
					if (Objects.equals(secretCode, inputCode)) {
						bullCounter = inputCode.length();
					} else {
						for (int i = 0; i < inputCode.length(); i++) {
							if (!verifyDuplicates(secretCodeDuplicates, secretCode, i)) {
								if (inputCode.charAt(i) == secretCode.charAt(i)) {
									bullCounter++;
									continue;
								}

								for (int j = 0; j < secretCode.length(); j++) {
									if (inputCode.charAt(i) == secretCode.charAt(j)) {
										if (verifyDuplicates(secretCodeDuplicates, secretCode, j)) {
											bullCounter++;
										} else {
											cowCounter++;
										}
									}
								}
							}
						}
					}

					StringBuilder message = new StringBuilder("Grade: ");
					StringBuilder bull = new StringBuilder("bulls");
					StringBuilder cow = new StringBuilder("cows");

					if (cowCounter == 0 && bullCounter == 0) {
						message.append("None");
					} else {
						if (bullCounter == 1) {
							bull.deleteCharAt(4);
						}
						if (cowCounter == 1) {
							cow.deleteCharAt(3);
						}

						message.append(String.format("%d %s and %d %s", bullCounter, bull, cowCounter, cow));
					}

					if (bullCounter == inputCode.length()) {
						System.out.println("Grade: " + inputCode.length() + " bulls");
						System.out.println("Congratulations! You guessed the secret code.");
					} else {
						System.out.println(message);
					}
				}
				turn++;
			} while (bullCounter != secretCode.length());
		}
	}

	private static void SecretCodeLimit() {
		char ch = '0';
		for (; ch <= '9'; ch++) {
			secretCodeList.add(ch);
		}

		for (ch = 'a'; ch <= 'z'; ch++) {
			secretCodeList.add(ch);
		}
	}

	private static String input(String message) {
		Scanner scanner = new Scanner(System.in);

		System.out.println(message);
		return scanner.nextLine();
	}

	private static int convertToInt(String text) {
		int secretCodeLength = -1;
		try {
			secretCodeLength = Integer.parseInt(text);
		} catch (NumberFormatException nfe) {
			System.out.printf("Error \"%s\" isn't a valid number.\n", text);
			return secretCodeLength;
		}

		if (secretCodeLength < 1 || 36 < secretCodeLength) {
			System.out.println("Error: minimum length is 1 and maximum length is 36");
			return -1;
		}
		return secretCodeLength;
	}

	private static boolean convertToInt(String text, int secretCode) {
		try {
			rangeOfCharacters = Integer.parseInt(text) - 1;
		} catch (NumberFormatException nfe) {
			System.out.printf("Error \"%s\" isn't a valid number.\n", text);
			return false;
		}

		if (rangeOfCharacters < 1 || 36 <= rangeOfCharacters) {
			System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
			return false;
		} else if (secretCode > rangeOfCharacters) {
			System.out.printf("Error: it's not possible to generate a code with length of %d with %d unique symbols.\n", secretCode, rangeOfCharacters);
			return false;
		}

		return true;
	}

	private static StringBuilder generateCode(int number) {
		if (0 >= number || number > 36) {
			System.out.printf("Error: can't generate a secret number with length of %d because there aren't enough unique digits", number);
			return null;
		}

		random = new Random();

		List<Character> uniqueCodeList = new ArrayList<>();
		StringBuilder uniqueCode = new StringBuilder();

		uniqueCodeList.add(randomNumber());
		for (int i = 1; i < number; i++) {
			char code = randomNumber();
			while (uniqueCodeList.contains(code)){
				code = randomNumber();
			}

			uniqueCodeList.add(code);
		}

		for (Character character: uniqueCodeList) {
			uniqueCode.append(character);
		}
		return uniqueCode;
	}

	private static void printMessage(int secretCodeLength) {

		System.out.print("The secret is prepared: ");
		for (int i = 0; i < secretCodeLength; i++) {
			System.out.print("*");
		}
		System.out.print(" (");
		if (rangeOfCharacters < 10) {
			System.out.print("0-" + secretCodeList.get(rangeOfCharacters));
		} else if (rangeOfCharacters < 37) {
			if (rangeOfCharacters == 10) {
				System.out.print("0-9, a");
			} else {
				System.out.print("0-9, a-" + secretCodeList.get(rangeOfCharacters));
			}
		}
		System.out.print(").");
		System.out.println();
	}

	private static Character randomNumber() {
		return secretCodeList.get(random.nextInt(rangeOfCharacters));
	}

	private static HashSet<Integer> groupDuplicates(String inputCode) {
		HashSet<Integer> secretCodeDuplicates = new HashSet<>();

		for (int i = 0; i < inputCode.length(); i++) {
			for (int j = i + 1; j < inputCode.length(); j++) {
				if (inputCode.charAt(i) == inputCode.charAt(j)) {
					secretCodeDuplicates.add(j);
				}
			}
		}

		return secretCodeDuplicates;
	}

	private static boolean verifyDuplicates(HashSet<Integer> duplicates, StringBuilder secretCode, int n) {
		return duplicates.contains(secretCode.indexOf(String.valueOf(secretCode.charAt(n))));
	}
}
