import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueSubstrings {
	private static String text;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		text = scn.nextLine();
		scn.close();

		for (int i = 1; i < text.length(); i++) {
			printSubstrings(i);
		}
	}

	private static void printSubstrings(int length) {
		Set<String> set = new HashSet<String>();

		for (int i = 0; i < text.length() - length + 1; i++) {
			String sub = text.substring(i, length + i);
			set.add(sub);
		}

		for (String str : set) {
			if (isUniqueChars(str)) {
				System.out.println(str);
			}
		}
	}

	private static boolean isUniqueChars(String str) {
		int checker = 0;

		for (int i = 0; i < str.length(); ++i) {
			int val = str.charAt(i) - 'a';

			if ((checker & (1 << val)) > 0) {
				return false;
			}

			checker |= (1 << val);
		}

		return true;
	}
}
