package Game;
 


import java.util.ArrayList;
import java.util.List;
 
 
public class HangmanModel {
 
    private int             maximumWrongGuesses;
    private int             numberOfGuesses;
    private int             wrongGuesses;
 
    private List<Character>   unguessedLetters;
 
    private Word          word;
 
    private String          currentWord;
    private String          hiddenWord;
 
    public HangmanModel() {
        this.word = new Word();
        init();
    }
 
    public void init() {
        this.numberOfGuesses = 0;
        this.wrongGuesses = 0;
        this.maximumWrongGuesses = Hangman.maximumWrongGuesses;
        this.unguessedLetters = resetLettersGuessed();
        this.currentWord = word.getWord();
        this.hiddenWord = word.getHiddenWord();
    }
 
    private List<Character> resetLettersGuessed() {
        List<Character> unguessedLetters = new ArrayList<Character>();
        for (int i = 0; i < 26; i++) {
            Character c = (char) (i + 'A');
            unguessedLetters.add(c);
        }
        return unguessedLetters;
    }
 
    public boolean isPossibleLetter(String letter) {
        String u = letter.toUpperCase();
        Character c = u.charAt(0);
        return unguessedLetters.contains(c);
    }
 
    public void guessLetter(String letter) {
        String l = letter.toLowerCase();
        String u = letter.toUpperCase();
 
        StringBuilder builder = new StringBuilder();
        boolean incorrectGuess = true;
        for (int i = 0; i < currentWord.length(); i++) {
            String s = currentWord.substring(i, i + 1);
            if (l.equals(s.toLowerCase())) {
                builder.append(s);
                incorrectGuess = false;
            } else {
                builder.append(hiddenWord.charAt(i));
            }
        }
 
        numberOfGuesses++;
 
        if (incorrectGuess) {
            wrongGuesses++;
        }
 
        Character c = u.charAt(0);
        unguessedLetters.remove(c);
 
        hiddenWord = builder.toString();
    }
 
    public boolean isDead() {
        return wrongGuesses >= maximumWrongGuesses;
    }
 
    public boolean isSolved() {
        boolean isSolved = true;
 
        for (int i = 0; isSolved && i < hiddenWord.length(); i++) {
            char c = hiddenWord.charAt(i);
            if (c == '_') {
                isSolved = false;
            }
        }
 
        return isSolved;
    }
 
    public String getUnguessedLetters() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < unguessedLetters.size(); i++) {
            builder.append(unguessedLetters.get(i));
            if (i < (unguessedLetters.size() - 1)) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
 
    public String getNumberOfGuesses() {
        return Integer.toString(numberOfGuesses);
    }
 
    public List<String> getHiddenWord() {
        List<String> lines = new ArrayList<String>();
 
        int size = 12;
        String s = hiddenWord;
 
        while (s.length() > size) {
            int pos = 0;
            while (pos >= 0 && pos < size) {
                pos = s.indexOf(" ", pos + 1);
            }
            if (pos >= 0) {
                String t = s.substring(0, pos);
                lines.add(expandHiddenWord(t));
                s = s.substring(pos + 1);
            } else {
                break;
            }
        }
 
        lines.add(expandHiddenWord(s));
 
        return lines;
    }
 
    private String expandHiddenWord(String word) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            builder.append(word.charAt(i));
            if (i < (word.length() - 1)) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
 
    public int getWrongGuesses() {
        return wrongGuesses;
    }
 
    public String getCurrentWord() {
        return currentWord;
    }
 
}