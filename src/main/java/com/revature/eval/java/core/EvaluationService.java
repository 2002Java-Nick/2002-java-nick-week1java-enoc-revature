// Do Friday at 5pm!
package com.revature.eval.java.core;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Collection;

// revisit: 6,7
public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		//return null;
		
		String tla = "";
		String[] stringArray = phrase.split("[- ]");
		for(int i=0; i<stringArray.length; i++) {
			tla += Character.toUpperCase(stringArray[i].charAt(0));
		}
		
		return tla;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			//return false;
			
			boolean equilateral = true;
			if(
					Double.compare(this.sideOne, this.sideTwo) != 0 &&
					Double.compare(this.sideThree, this.sideTwo) != 0 &&
					Double.compare(this.sideOne, this.sideThree) != 0
			)
				equilateral = false;
			return equilateral;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			//return false;

			boolean isosceles = false;
			if(
					Double.compare(this.sideOne, this.sideTwo) == 0 ||
					Double.compare(this.sideThree, this.sideTwo) == 0 ||
					Double.compare(this.sideOne, this.sideThree) == 0
			)
				isosceles = true;
			return isosceles;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			//return false;

			boolean scalene = true;
			if(
					Double.compare(this.sideOne, this.sideTwo) == 0 ||
					Double.compare(this.sideThree, this.sideTwo) == 0 ||
					Double.compare(this.sideOne, this.sideThree) == 0
			)
				scalene = false;
			return scalene;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		//return 0;
		String score1 = "AEIOULNRST"; // Score of 1
		String score2 = "DG"; // Score of 2
		String score3 = "BCMP"; // Score of 3
		String score4 = "FHVWY"; // Score of 4
		String score5 = "K"; // Score of 5
		String score8 = "JX"; // Score of 8
		String score10 = "QZ"; // Score of 10
		
		int scoreCounter = 0;
		
		for(int i=0; i<string.length(); i++) {
			if(score1.contains(Character.toString(Character.toUpperCase(string.charAt(i))))) {
				scoreCounter += 1;
				continue;
			}
			if(score2.contains(Character.toString(Character.toUpperCase(string.charAt(i))))) {
				scoreCounter += 2;
				continue;
			}
			if(score3.contains(Character.toString(Character.toUpperCase(string.charAt(i))))) {
				scoreCounter += 3;
				continue;
			}
			if(score4.contains(Character.toString(Character.toUpperCase(string.charAt(i))))) {
				scoreCounter += 4;
				continue;
			}
			if(score5.contains(Character.toString(Character.toUpperCase(string.charAt(i))))) {
				scoreCounter += 5;
				continue;
			}
			if(score8.contains(Character.toString(Character.toUpperCase(string.charAt(i))))) {
				scoreCounter += 8;
				continue;
			}
			if(score10.contains(Character.toString(Character.toUpperCase(string.charAt(i))))) {
				scoreCounter += 10;
				continue;
			}
		}
		
		return scoreCounter;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		//return null;
		
		String phoneNumber = "";
		char[] charArray = string.toCharArray();
		for(int i=0; i<charArray.length; i++)
			if(Character.isDigit(charArray[i]))
				phoneNumber += charArray[i];
		if(phoneNumber.length() != 10)
			throw new IllegalArgumentException();

		return phoneNumber;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		//return null;
		
	
		int strCount = 0;
		//String[] stringArray = string.split("[\\s|,|\n]");
		String[] stringArray = string.split("[ ,\n]");
		//String[] uniqueArray;
		//ArrayList<String> uniqueArray = new ArrayList<>();
		//String[] stringUnique;
		Map<String, Integer> wordOccurrence = new java.util.HashMap<>();
		java.util.HashSet<String> uniqueSet = new java.util.HashSet<String>();
		java.util.Collections.addAll(uniqueSet,stringArray);
		Object[] uniqueArray = uniqueSet.toArray();
		//String[] uniqueArray = (String[])uniqueSet.toArray();
		/*
		for(int i=0; i<stringArray.length; i++) {
			if(!string.contains(stringArray[i]))
				uniqueArray.add(stringArray[i]);
		}
		for(int i=0; i<uniqueArray.size(); i++) {
			strCount=0;
			for(int j=0; j<stringArray.length; j++)
				if(uniqueArray.get(i)==stringArray[j])
					strCount++;
			wordOccurrence.put(uniqueArray.get(i),strCount);
		}
		for(int i=0; i<uniqueArray.size(); i++) {
			strCount=0;
			for(int j=0; j<stringArray.length; j++)
				if(uniqueArray.get(i)==stringArray[j])
					strCount++;
			wordOccurrence.put(uniqueArray.get(i),strCount);
		}
		*/
		for(int i=0; i<uniqueArray.length; i++) {
			for(int j=0; j<stringArray.length; j++) {
				if((String) uniqueArray[i]==stringArray[j])
					strCount++;
			}
			wordOccurrence.put((String)uniqueArray[i],strCount);
			strCount=0;
		}
		return wordOccurrence;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			//int searchIndex = Array.getLength(t);
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		//return null;
		
		ArrayList<Integer> vowelIndex = new ArrayList<>();
		String pigString = "";
		//int vowelIndex = 0;
		String vowels = "aeiou";
		String consonants = "bcdfghjklmnpqrstvwxyz";
		String[] stringArray = string.split(" ");
		if(string.contains(" ")) {
			for(int i=0; i<stringArray.length; i++) {
				if(vowels.contains(Character.toString(stringArray[i].charAt(0)))) {
					stringArray[i] += "ay";
				}
			}
			/*
			for(int i=0; i<stringArray.length; i++) {
				pigString = pigString + stringArray[i] + " ";
			}
			*/
			for(int i=0; i<stringArray.length; i++) {
				if(consonants.contains(Character.toString(stringArray[i].charAt(0)))) {
					for(int j=0; j<stringArray[i].length(); j++) {
						if(vowels.contains(Character.toString(stringArray[i].charAt(j)))) {
//							if((Character.toString(stringArray[i].charAt(vowelIndex.get(i-1))) + 
//									Character.toString(stringArray[i].charAt(vowelIndex.get(i)))) == "qu")
//								vowelIndex.set(i, vowelIndex.get(i)+1);
							if(((Character.toString(stringArray[i].charAt(j-1))) + 
								Character.toString(stringArray[i].charAt(j))) == "qu"){
									//vowelIndex.set(i, vowelIndex.get(i)+1);
									vowelIndex.add(j+1);
								} else {
									vowelIndex.add(j);
								}
							break;
						}
					}
				}
			}
			for(int i=0; i<stringArray.length; i++) {
				pigString = pigString + stringArray[i].substring(vowelIndex.get(i),stringArray[i].length()) + stringArray[i].substring(0,vowelIndex.get(i)) + "ay ";
			}
		} else {
			if(vowels.contains(Character.toString(string.charAt(0)))) {
				pigString = string + "ay";
			}
			if(consonants.contains(Character.toString(string.charAt(0)))) {
				for(int i=0; i<string.length(); i++) {
					if(vowels.contains(Character.toString(string.charAt(i)))) {
						vowelIndex.add(i);
						break;
					}
					if(string.charAt(vowelIndex.get(0)) == 'u')
						vowelIndex.set(0, vowelIndex.get(0)+1);
				}
				pigString = string.substring(vowelIndex.get(0),string.length()) + string.substring(0,vowelIndex.get(0)) + "ay";
			}
			
		}
		
			return pigString.trim();
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		//return false;
		
		String numberStr = Integer.toString(input);
		int powerNum = numberStr.length();
		int armstrongSum = 0;
		int runningInt;
		for(int i=0; i<powerNum; i++) {
			runningInt = Integer.parseInt(Character.toString(numberStr.charAt(i)));
			armstrongSum += java.lang.Math.pow(runningInt, powerNum);
		}
		
		return input==armstrongSum;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		return null;
		
		/*
		java.util.List<Long> primes = new java.util.ArrayList<>();
		boolean morePrimes = true;
		long runningPrime = 2;
		while(morePrimes) {
			if(l%runningPrime == 0) {
				primes.add(runningPrime);
				l /= runningPrime;
			} else {
				runningPrime++;
			}
			if(l/runningPrime == 0) {
				morePrimes = false;
			}
		}
		
		return primes;
		*/
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			//return null;
			
			int charAsInt;
			char[] charArray = string.toCharArray();
			char[] shiftedArray = new char[charArray.length];
			for(int i=0; i<charArray.length; i++) {
				//if(charArray[i]+this.key < )
				if(!Character.isAlphabetic(charArray[i])) {
					shiftedArray[i] = charArray[i];
					continue;
				}

				charAsInt = charArray[i] + this.key;
				//if(Character.isUpperCase(charArray[i]) && charAsInt > 90) {
				if(Character.isUpperCase(charArray[i]) ) {
					if(charAsInt > 90) {
					shiftedArray[i] = (char) (charAsInt-26);
					} else {
					shiftedArray[i] = (char) (charAsInt);
					}
				} else {
				//if(Character.isLowerCase(charArray[i]) && charAsInt > 122) {
					if(charAsInt > 122) {
						shiftedArray[i] = (char) (charAsInt-26);
					} else {
						shiftedArray[i] = (char) (charAsInt);
					}
				}
				
			}

			
			return new String(shiftedArray);
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		return 0;
		
		/*
		//boolean morePrimes = true;
		//int runningPrime = 2;
		int nthPrime;
		//int runningCount = 0;
		int runningInput = 2;
		List<Long> primeList = new ArrayList<>();
		List<Long> tempList = new ArrayList<>();

		//public List<Long> calculatePrimeFactorsOf(long l) {
		// Generate primes
		//while(i<runningCount && morePrimes) {
		//while(i<runningCount) {
		while(i>primeList.size()) {
		*/
			/*
			if(i%runningPrime == 0) {
				i /= runningPrime;
			} else {
				runningPrime++;
			}
			if(i/runningPrime == 0) {
				morePrimes = false;
			}
			*/
		/*
			while(primeList.size() <= tempList.size()) {
				tempList = this.calculatePrimeFactorsOf(runningInput);
				runningInput++;
			}
			//primeList = tempList;
			primeList.clear();
			primeList.addAll(tempList);
			//runningCount = primeList.size();
			//runningCount++;
		}
		
		//return runningPrime;
		nthPrime =  java.lang.Math.toIntExact(primeList.get(primeList.size()-1));
		//return (int) primeList.get(primeList.size()-1);
		return nthPrime;
		*/
	}
	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			//return null;
			int charAsInt;
			char[] charArray = string.toCharArray();
			ArrayList<Character> shiftedArray = new ArrayList<>();
			for(int i=0; i<charArray.length; i++) {
				if(Character.isDigit(charArray[i])) {
					shiftedArray.add(charArray[i]);
					continue;
				} else if(!Character.isLetter(charArray[i])){
					continue;
				}

				if(Character.isUpperCase(charArray[i]) ) {
					charArray[i] = Character.toLowerCase(charArray[i]);
				}
				charAsInt = charArray[i];
				shiftedArray.add((char) (122 - (charAsInt-97)));
				
			}

			String beforeSpaces = "";
			for(char letter : shiftedArray)
				beforeSpaces += letter;

			String afterSpaces = "";
			int i=0;
			int offset = 0;
			while(i <= beforeSpaces.length()) {
				if(i % 6 == 0) {
					afterSpaces += " ";
					offset++;
				} else {
					afterSpaces += Character.toString(beforeSpaces.charAt(i-offset));
				}
				i++;
			}
			if(i % 6 == 0) {
				afterSpaces += " ";
			}
			int k = beforeSpaces.length();
			for(int j=offset-1; j>0; j--) {
				afterSpaces += beforeSpaces.charAt(k-j);
			}
			return afterSpaces.trim();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			//return null;

			int charAsInt;
			char[] charArray = string.toCharArray();
			ArrayList<Character> shiftedArray = new ArrayList<>();
			for(int i=0; i<charArray.length; i++) {
				if(Character.isDigit(charArray[i])) {
					shiftedArray.add(charArray[i]);
					continue;
				} else if(!Character.isLetter(charArray[i])){
					continue;
				}

				if(Character.isUpperCase(charArray[i]) ) {
					charArray[i] = Character.toLowerCase(charArray[i]);
				}
				charAsInt = charArray[i];
				shiftedArray.add((char) (122 - (charAsInt-97)));
				
			}

			String beforeSpaces = "";
			for(char letter : shiftedArray)
				beforeSpaces += letter;

			String afterSpaces = "";
			int i=0;
			int offset = 0;
			while(i <= beforeSpaces.length()) {
				if(i % 6 == 0) {
					afterSpaces += " ";
					offset++;
				} else {
					afterSpaces += Character.toString(beforeSpaces.charAt(i-offset));
				}
				i++;
			}
			if(i % 6 == 0) {
				afterSpaces += " ";
			}
			int k = beforeSpaces.length();
			for(int j=offset-1; j>0; j--) {
				afterSpaces += beforeSpaces.charAt(k-j);
			}
			return afterSpaces.replaceAll(" ","");
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		//return false;
		
		int[] isbn = new int[11];
		String isbnString = string.replaceAll("-","");
		
		// Convert X or validate string
		if(isbnString.charAt(isbnString.length()-1) == 'X') {
			isbnString = isbnString.substring(isbnString.length()-2);
			isbnString = isbnString.substring(isbnString.length()-2, isbnString.length()-1);
		}

		// Make string into int[]
		for(int i=0; i<isbnString.length(); i++) {
			isbn[i] = isbnString.charAt(i);
		}
		
		// Validate
		if((isbn[0]*10 + isbn[1]*9 + isbn[2]*8 + isbn[3]*7 + isbn[4]*6 + isbn[5]*5 + isbn[6]*4 + isbn[7]*3 + isbn[8]*2 + isbn[9]) % 11 == 0)
			return true;
		else
			return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		//return false;

		boolean[] letters = new boolean[26];
		string = string.replaceAll(" ", "");
		string = string.toLowerCase();
		for(int i=0; i<string.length(); i++) {
			letters[string.charAt(i) - 97] = true;
		}
		
		//List<Boolean> validateList = new ArrayList<>();
		boolean validationFlag = true;
		for(boolean elem : letters) {
		if(elem != true)
			validationFlag = false;
		}
		return validationFlag;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		return null;
		
		/*
		String format = "yyyy/MM/dd hh:mm:ss";
		Date date = new Date(millis)
		//java.time.LocalDateTime datetime = new java.time.LocalDateTime();
		java.time.LocalDateTime datetime = LocalDateTime.from(given);
		//java.time.format.DateTimeFormatter format = java.time.format.DateTimeFormatter.patternOf(format);
        //String p = "yyyy/MM/dd hh:mm:ss.SSS";
        //DateTimeFormatter f = DateTimeFormatter.ofPattern(p);
        //System.out.println("Current datetime: " + LocalDateTime.now().format(f));

		
		return null;
		*/
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		//return 0;
		
		/*
		java.util.Set<Integer> uniqueSet = new java.util.HashSet<>();
		ArrayList<Integer> uniqueArray = new ArrayList<>();
		ArrayList<Integer> toAddArray = new ArrayList<>();
		for(int x : set)
			uniqueSet.add(x);
		uniqueArray.addAll(uniqueSet);
		for(int x : uniqueArray) {
			if(x%i == 0 && x != i)
				toAddArray.add(x);
		}
		
		int summation = 0;
		for(int x : toAddArray) {
			summation += x;
		}
		
		
		return uniqueArray.size();
		*/
		ArrayList<Integer> toAddArray = new ArrayList<>();
		for(int j=2; j<i; j++) {
			for(int k=0; k<toAddArray.size(); k++) {
				if(j % set[k] == 0)
					toAddArray.add(j);
			}
		}
		
		int summation = 0;
		for(int x : toAddArray)
			summation += x;
		
		//return summation;
		return toAddArray.size();
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		//return false;
		
		string = string.replaceAll(" ", "");
		char[] charArray = string.toCharArray();

		// Validate input
		for(char ch : charArray) {
			if(!Character.isLetter(ch))
				return false;
		}
		int[] intArray = new int[charArray.length];
		for(int i=0; i<charArray.length; i++) {
			intArray[i] = Integer.parseInt(Character.toString(charArray[i]));
		//System.out.printf("charArray[%d]=%c%n", i, charArray[i]);
		//System.out.printf("intArray[%d]=%c%n", i, intArray[i]);
		}
		
		//System.out.printf("intArray.length=%d%n",intArray.length);

		for(int i=0; i<intArray.length; i++) {
			//System.out.println("i=" + i);
			if((i+1)%2 == 0) {
				System.out.printf("%n%n");
				System.out.printf("i+1=%d%n",i+1);
				System.out.println("(i+1)%2="+((i+1)%2));
				System.out.printf("Before Doubling: intArray[%d]=%d%n", i, intArray[i]);
				intArray[i] *= 2;
				System.out.printf("Before Subtraction: intArray[%d]=%d%n", i, intArray[i]);
				if(intArray[i] > 9)
					intArray[i] -= 9;
				System.out.printf("After: intArray[%d]=%d%n", i, intArray[i]);
			}
		}
		
		int summation = 0;
		for(int x : intArray)
			summation += x;

		//return false;

		return summation%10 == 0;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		//return 0;
		
		string = string.replaceAll("\\?", "");
		String[] stringArray = string.split(" ");
		boolean[] operatorFlag = {false, false, false, false}; //0->Add, 1->Sub, 2->Mul, 3->Div
		//String[] dataArray = new String[3];
		if(string.contains("plus")) {
			operatorFlag[0] = true;
		} else if(string.contains("minus")) {
			operatorFlag[1] = true;
		} else if(string.contains("multiplied")) {
			operatorFlag[2] = true;
		} else {
			operatorFlag[3] = true;
		}
		ArrayList<String> dataArray = new ArrayList<>();
		for(String s : stringArray) {
			if(!Character.isLetter(s.charAt(0)))
				dataArray.add(s);
		}
		for(String s : dataArray)
			System.out.println(s);
		
		if(operatorFlag[0])
			return Integer.parseInt(dataArray.get(0)) + Integer.parseInt(dataArray.get(1));
		else if(operatorFlag[1])
			return Integer.parseInt(dataArray.get(0)) - Integer.parseInt(dataArray.get(1));
		else if(operatorFlag[2])
			return Integer.parseInt(dataArray.get(0)) * Integer.parseInt(dataArray.get(1));
		else
			return Integer.parseInt(dataArray.get(0)) / Integer.parseInt(dataArray.get(1));
		
		//return 0;
	}

}
