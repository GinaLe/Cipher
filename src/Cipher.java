import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Cipher {
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789,.() '\"![]/%-_;?-=:" + '\n' + '\r';
	private static final String SIMPLE_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	// Set this variable to the default alphabet you wish to use
	private static final String DEFAULT_ALPHABET = ALPHABET;
	
	private static Dictionary dictionary = Dictionary.buildDictionary("D:\\Gina APCS\\CipherBlankTemplate\\words.txt");
	
	/**
	 * Returns plaintext encrypted by the rotation cipher with a shift of movement.
	 * @param alphabet the alphabet to be used for the encryption
	 * @param plainText the plain text to be encrypted.
	 * @param shiftAmount the number of characters in ALPHABET to shift by.
	 * @return returns the encrypted plainText.
	 */
	public static String rotationCipherEncrypt(String plain, int shift, String alphabet) {
		String newWord = "";
		for(int i = 0; i < plain.length();i++) {
			String letter = plain.substring(i, i+1);
			int index = alphabet.indexOf(letter);
			int shiftIndex = (index + shift) % alphabet.length();
			String newLetter = alphabet.substring(shiftIndex, shiftIndex+1);
			newWord = newWord + newLetter;
		}
		return newWord;
 
	}
	
	public static String rotationCipherEncrypt(String plainText, int shiftAmount) {
		return rotationCipherEncrypt(plainText, shiftAmount, DEFAULT_ALPHABET);
	}

	/**
	 * Returns a the result of decrypting cipherText by shiftAmount using the rotation cipher.
	 * @param alphabet the alphabet to be used for the encryption
	 * @param cipherText the encrypted text.
	 * @param shiftAmount the key to decrypt the cipher.
	 * @return returns the decrypted cipherText.
	 */
	public static String rotationCipherDecrypt(String cipher, int shift, String alphabet){
		String decryptedWord = "";
		for(int i = 0; i < cipher.length(); i++) {
			String letter = cipher.substring(i, i+1);
			int index = alphabet.indexOf(letter);
			int shiftIndex = index - shift ;
			while(shiftIndex < 0) shiftIndex += alphabet.length();
			String newLetter = alphabet.substring(shiftIndex, shiftIndex+1);
			decryptedWord = decryptedWord + newLetter;
		}
		return decryptedWord;
	}
	
	public static String rotationCipherDecrypt(String cipherText, int shiftAmount) {
		return rotationCipherDecrypt(cipherText, shiftAmount, DEFAULT_ALPHABET);
	}

	/**
	 * Returns plaintext encrypted by the vigenere cipher encoded with the String code
	 * @param alphabet the alphabet to be used for the encryption
	 * @param plainText the plain text to be encrypted.
	 * @param code the code to use as the encryption key.
	 * @return returns the encrypted plainText.
	 */
	public static String vigenereCipherEncrypt(String plain, String password, String alphabet) {

		String encryptedCode = "";
		for(int i = 0; i < plain.length(); i++) {
			String letterFromPlainText = plain.substring(i, i+1);
			int indexOfPlainText = alphabet.indexOf(letterFromPlainText);
			int j = i % password.length();
			String letterFromCode = password.substring(j, j+1);
			int indexOfCode = alphabet.indexOf(letterFromCode);
			int newIndex = (indexOfCode + indexOfPlainText) % alphabet.length();
			String newLetter = alphabet.substring(newIndex, newIndex+1);
			encryptedCode += newLetter;
		}
		return encryptedCode;
	}
	
	public static String vigenereCipherEncrypt(String plainText, String code) {
		return vigenereCipherEncrypt(plainText, code, DEFAULT_ALPHABET);
	}

	/**
	 * Returns the result of decrypting cipherText with the key code.
	 * @param alphabet the alphabet to be used for the encryption
	 * @param cipherText the encrypted text.
	 * @param code the decryption key
	 * @return returns the decrypted cipherText.
	 */
	public static String vigenereCipherDecrypt(String cipher, String password, String alphabet) {
		String decryptedCode = "";
		for(int i = 0; i < cipher.length(); i++) {
			String letterFromCipherText = cipher.substring(i, i+1);
			int indexOfCipherText = alphabet.indexOf(letterFromCipherText);
			int j = i % password.length();
			String letterFromCode = password.substring(j, j+1);
			int indexOfCode = alphabet.indexOf(letterFromCode);
			int newIndex = (indexOfCipherText - indexOfCode ) % alphabet.length();
			while(newIndex < 0) newIndex = newIndex + alphabet.length();
			String newLetter = alphabet.substring(newIndex, newIndex+1);
			decryptedCode += newLetter;
		}
		return decryptedCode;
	}
	
	public static String vigenereCipherDecrypt(String cipherText, String code) {
		return vigenereCipherDecrypt(cipherText, code, DEFAULT_ALPHABET);
	}

	/**
	 * returns a copy of the input plaintext String with invalid characters
	 * stripped out.
	 * 
	 * @param plaintext
	 *          The plaintext string you wish to remove illegal characters from
	 * @param alphabet
	 *          A string of all legal characters.
	 * @return String A copy of plain with all characters not in alphabet removed.
	 */
	private static String stripInvalidChars(String plaintext, String alphabet) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < plaintext.length(); i++) { 			// loop through plaintext
			if (alphabet.indexOf(plaintext.charAt(i)) >= 0) 	// get index of char
				b.append(plaintext.charAt(i)); 									// if it exists, keep it
			else
																												// otherwise skip it &
				System.out.println("Stripping letter: \"" + plaintext.charAt(i) // display
																																				// a
																																				// message
						+ "\"");
		}
		return b.toString();
	}
	/**
	 * Returns crypted code using perumtation
	 * @param plaintext the text that will be coded
	 * @param permutation array that describes how letters will be replaced
	 * @param alphabet string of characters
	 * @return crypted code using permutation
	 */
	public String substitutionCipher(String plaintext, int[] permutation, String alphabet) {
		String codeWord = "";
		for(int i = 0; i < plaintext.length(); i++) {
			String letter = alphabet.substring(permutation[i], permutation[i] + 1);
			codeWord = codeWord + letter;
		}
		return codeWord;
	}
	
	public static String rotationCipherCrack(String cipher, String alphabet){
		String decipheredText = "";
		for(int i = 0; i < alphabet.length(); i++) {
			decipheredText = rotationCipherDecrypt(cipher, i);
			if(isEnglish(decipheredText)) return decipheredText;
			}
			return "";
		}
	/**
	 * Returns if the permutation is valid
	 * @param permutation array with numbers representing index of alphabet
	 * @return if permutation is valid
	 */
	public static boolean isValidPermutation(int[] permutation) {
		for(int i = 0; i < permutation.length; i++) {
			for(int j = i + 1; j < permutation.length; j++) {
			if(permutation[i] == permutation[j]) return false;
			}
		}
		return true;
	}
	/**
	 * Returns a random permutation int array
	 * @param length length of the permutation
	 * @return random permutation int array
	 */
	public static int[] randomPermutation(int length) {
		int[] permutation = new int[length];
		for(int i = 0; i < permutation.length; i++) {
			permutation[i] = (int)(Math.random()*(length+1));
		}
		return permutation;
	}
	
	public static int countSpaces(String input){
		int spaceCounter = 0;
		for (int i = 0; i <  input.length()-1; i++){
			input = input.trim();
			String letter = input.substring(i, i+1);
			String nextLetter = input.substring(i+1, i+2);
			if (!letter.equals(" ") && nextLetter.equals(" ")){
				spaceCounter++;
			}
		}
		
		return spaceCounter;
	}
	
	public static String[] getWords(String input){
		input = input.trim();
		
		String[] output = new String[countSpaces(input)+1];
		int currentSpaceIndex = input.indexOf(" ");
		int prevSpace = 0;
		int nextFree = 1;
		
		if (output.length == 1){
			output[0] = input;
			return output;
		}
		
		String firstWord = input.substring(prevSpace, currentSpaceIndex);
		output[nextFree-1] = firstWord;
		prevSpace = currentSpaceIndex;
		currentSpaceIndex = input.indexOf(" ", prevSpace + 1);
		
		while (currentSpaceIndex != -1){
			String word = input.substring(prevSpace+1, currentSpaceIndex);
			
			if (!word.equals("")) {
				output[nextFree] =  word;
				nextFree++;
			}
			
			prevSpace = currentSpaceIndex;
			currentSpaceIndex = input.indexOf(" ", prevSpace + 1);
		}
		
		if (!input.substring(prevSpace, input.length()).equals("")){
			output[nextFree] = input.substring(prevSpace+1, input.length());
		}
		return output;
	}
	
	/**
	 * returns true if plaintext is valid English.
	 * 
	 * @param plaintext
	 *          the text you wish to test for whether it's valid English
	 * @return boolean returns true if plaintext is valid English.
	 */
	public static boolean isEnglish(String plaintext) {
		String[] plainText = getWords(plaintext);
		int englishWordCounter = 0;
			for(int i = 0; i <  plainText.length; i++ ) {
				if(dictionary.isWord(plainText[i]) == true) englishWordCounter++;  
			}
			
			if((englishWordCounter/(double)plainText.length) <  0.2) return false;
			else return true;
	
	}
	
	public static String getLettersOut(String encrypted, int index, int length) {
		String letterGroup = "";
		for(int i = index; i < encrypted.length(); i = i + length) {
			letterGroup = letterGroup + encrypted.substring(i, i+1);
		}
		return letterGroup;
	}
	
	public static String findCodeLetter(String letterGroup, String alphabet) {
		for(int i = 0; i < alphabet.length();i++) {
			String decoded = Cipher.rotationCipherDecrypt(letterGroup, i, alphabet);
			LetterBag bag = new LetterBag();
			for(int j = 0; j < decoded.length()-1; j++) {
				String letters = decoded.substring(j, j+1);
				bag.add(letters);
			}
			if(bag.getMostFrequent().equals(" ")){
			return alphabet.substring(i, i+1);
			}
		}
		return null;
	}
	public static String vigenereCipherCrackThreeLetter(String cipher, String alphabet) {
		String password = " ";
		int passSize = 3;
		for(int i = 0; i < passSize; i++) {
			String group = getLettersOut(cipher, i, passSize);
			password += findCodeLetter(group, alphabet);
		}
		return password;
	}
	
	public String vigenereCipherCrack(String cipher, int passwordLength, String alphabet) {
		String password = " ";
		for(int i = 0; i < passwordLength; i++) {
			String group = getLettersOut(cipher, i, passwordLength);
			password += findCodeLetter(group, alphabet);
		}
		return password;
	}

}