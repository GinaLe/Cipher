import java.util.Arrays;

import fileIO.FHSfileIO;

public class Tester {
	private static final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789,.() '\"![]/%-_;?-=:";

	public static void main(String[] args) {
		
//		String plainText = "Nima's pants are on fire!!!?!!";
//		String cipherText = Cipher.rotationCipherEncrypt(plainText, 25);
//	
//		System.out.println("Plaintext: " + plainText);
//		System.out.println("Cipertext: " + cipherText);
		
//		String cipher = Cipher.vigenereCipherEncrypt("hello there", "code");
//		String plain = Cipher.vigenereCipherDecrypt(cipher, "code");
//		
//		System.out.println(cipher);
//		System.out.println(plain);
//		
//		Dictionary d = Dictionary.buildDictionary("E:\\Gina APCS\\CipherBlankTemplate\\words.txt");
//		System.out.println(d.isWord("hi"));
//		System.out.println(d.isWord("xxidera"));
		
//		System.out.println(Arrays.toString(Cipher.getWords(" b c def  gh  : ")));
//		System.out.println(Cipher.isEnglish("Hi my name is dog"));
		
//		String message = FHSfileIO.readFileAsString("D:\\Gina APCS\\CipherBlankTemplate\\cipher1.txt");
//		String decrypt = Cipher.rotationCipherCrack(message, alphabet);
//		System.out.print(decrypt);
		
		
	
		String sentence = "Look there is a dog over there. The dog is very cute and small. "
							+ "It is a sunny day today."
							+ " Wow I wish I was at home. "
							+ "Except I have tennis practice and work after six hours of school.";
		String password = "dog";
		String encryptedCode = Cipher.vigenereCipherEncrypt(sentence, password, alphabet);
		System.out.println(encryptedCode);
		String passwordDecrypt = Cipher.vigenereCipherCrackThreeLetter(encryptedCode, alphabet);
		System.out.print(passwordDecrypt);
	}

}