
public class LetterBag {
	private final static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789,.() '\"![]/%-_;?-=:";
	private static int[] letterFrequencies;
	
	public LetterBag() {
		letterFrequencies = new int[84];
	}
	/***
	 * adds a letter to the bag
	 * @param letter the letter to be added
	 */
	public void add(String letter) {
		String lower = letter.toLowerCase();
		int index = getIndexForLetter(lower);
		letterFrequencies[index]++;
	}
	private static int getIndexForLetter(String lower) {
		return alphabet.indexOf(lower);
	}
	/***
	 * returns total number of words in a bag
	 * @return total number of words in a bag
	 */
	public static int getTotalWords(){
		int totalWords = 0;
		
		for(int i = 0; i < letterFrequencies.length; i++) {
			if(letterFrequencies[i] != 0) totalWords += letterFrequencies[i];
	
		}
		return totalWords;
	}
	/***
	 * counts how many different words are in a bag
	 * @return number of different words in a bag
	 */
	public static int getNumUniqueWords() {
		int counter = 0;
		for(int i = 0; i < letterFrequencies.length; i++) {
			if(letterFrequencies[i] != 0) counter++;
		}
		return counter;
	}
	/***
	 * counts how many of a certain letter is in a bag
	 * @param letter number of occurrences of this letter
	 * @return number of input letter that is in a bag
	 */
	public static int getNumOccurances(String letter) {
		int index = getIndexForLetter(letter);
		return letterFrequencies[index];
	}
	/***
	 * counts most frequent word that appears
	 * @return the words that occurs the most in the bag
	 */
	public String getMostFrequent() {
		int mostFrequent = 0;
		
		for(int i = 0; i < letterFrequencies.length; i ++) {
			if(letterFrequencies[i] > mostFrequent) mostFrequent = i;
		}
		
		return alphabet.substring(mostFrequent, mostFrequent+1);
	}
}
