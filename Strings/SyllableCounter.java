/*Counts the number of syllables in English words*/
public class SyllableCounter extends TextProgram {

    /* Repeatedly prompt the user for a word and print out the estimated
     * number of syllables in that word.
     */
    public void run() {
        while (true) {
            String word = readLine("Enter a single word: ");
            println("  Syllable count: " + syllablesInWord(word));
        }
    }

    /**
     * Given a word, estimates the number of syllables in that word according to the
     * heuristic specified in the handout.
     *
     * @param word A string containing a single word.
     * @return An estimate of the number of syllables in that word.
     */
    private int syllablesInWord(String word) {
        int syllablesCounter = 0;
        word = word.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (isVowel(letter)) {
                if (i == 0 || !isVowel(word.charAt(i - 1))) {  //Checks if previous letter isn't vowel too. i==0 used for case when first letter in word is vowel
                    syllablesCounter++;
                }
            }
        }

        syllablesCounter = checkLastLetters(word, syllablesCounter);

        return syllablesCounter;
    }

    /*Checking the word two last letters.
    If the last one is 'e' and second last one is not, decreases syllable counter*/
    private int checkLastLetters(String word, int syllablesCounter) {
        if (word.length() == 1) {
            return 1;
        }
        char lastLetter = word.charAt(word.length() - 1);
        char secondLastLetter = word.charAt(word.length() - 2);
        if (lastLetter == 'e' && secondLastLetter != 'e') {
            syllablesCounter--;
        }

        if (syllablesCounter == 0) {        //Handling of the case where word have only one syllable and ends with letter 'e'
            syllablesCounter++;
        }
        return syllablesCounter;
    }


    /* Check if character is a vowel letter.
     * Returns true if it is and false if it's not
     */
    private boolean isVowel(char letter) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        for (char vowel : vowels) {
            if (letter == vowel) {
                return true;
            }
        }
        return false;
    }
}
