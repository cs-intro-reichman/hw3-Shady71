/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		System.out.println(preProcess("I am a weakish speller"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(spaceRemoval(str1));
		str2 = preProcess(spaceRemoval(str2));

		if ((str1.length() != str2.length())) {
			return false;
		}

		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if (str2.indexOf(str1.charAt(i)) == -1) {
					return false;
				}
				}
			}

		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String lowerCaseString = str.toLowerCase();
		String newString = "";

		for (int i = 0; i < lowerCaseString.length(); i++) {
			char character = lowerCaseString.charAt(i);

			if (character >= 'a' && character <= 'z' || character == ' ') {			
				newString += character;
			} 
		}
		return newString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newString = "";

		for (int i = 0; i < str.length(); i++) {
			while (str.length() > 0) {
				int randomIndex = (int) (Math.random() * str.length());
				char randomCharacter = str.charAt(randomIndex);
				newString += randomCharacter;

				str = str.substring(0, randomIndex) + str.substring(randomIndex + 1);
			}
		}
		return newString;
	}

	// Removes spaces from strings
	// needed for tests
	private static String spaceRemoval(String str) {
		String newString = "";

		for (int i = 0; i < str.length(); i++) {
			char character = str.charAt(i);
			if (character != ' ') {
				newString += character;
			}
		}

		return newString;
	}
	
}
