
/*Finds the words that can be made with using 3 letters following their order
* */
public class NumberPlateSpellingGame extends TextProgram {
    //Number of letters that have to be read
    private static final int N_LETTERS_IN_NUMBER = 3;

    /* Asks the user for a string of three letters and then output words that can be made from those letters.
    * */
    public void run() {
        String[] dictionary = readWordsFromDictionary();
        while (true){
            char[] letters = takeLetters();
            findPossibleWords(letters, dictionary);
        }

    }

    /* Goes through all words in dictionary and if it's possible to create this word, output it*/
    private void findPossibleWords(char[] letters, String[] dictionary) {
        for (String s : dictionary) {
            if (isPossibleToCreateWord(letters, s)) {
                println(s);
            }
        }
    }

    /* Read words from dictionary and add them to Array list.
     * Then turns arrayList to regular array to facilitate further work with it
    * */
    private String[] readWordsFromDictionary() {

        ArrayList<String> arrayList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("assets/en-dictionary.txt"));
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                arrayList.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrayList.toArray(new String[0]);
    }

    /* Goes through characters of word and check if it's match the chars in array of user's letters
     * If it's matches increases counter of matched letters and if it equals 3 that's means that
     * it's possible create word from those letters
    * */
    private boolean isPossibleToCreateWord(char[] letters, String word) {
        int j = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letters[j]) {
                j++;
                if (j == N_LETTERS_IN_NUMBER) {
                    return true;
                }
            }
        }
        return false;
    }

    /* Reads string from user
    *  If it's larger than 3 we take only first 3 letters
    *  If it's shorter than 3 catch error and inform user that string is too short
    * */
    private char[] takeLetters() {
        String letters = readLine("Enter letters: ").toLowerCase();

        if (letters.length() > N_LETTERS_IN_NUMBER) {
            println("You wrote too many letters. We'll take only 3 first");
        }

        char[] arrayOfLetters = new char[N_LETTERS_IN_NUMBER];
        try {
            for (int i = 0; i < N_LETTERS_IN_NUMBER; i++) {
                arrayOfLetters[i] = letters.charAt(i);
            }
        } catch (Exception e) {
            println("We need at least 3 letters for game ");
        }

        return arrayOfLetters;
    }

}
