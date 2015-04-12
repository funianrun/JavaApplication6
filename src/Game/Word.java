package Game;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
 
public class Word {
 
    private int             randomInt;
 
    private List<String>  words;
 
    private Random          random;
 
    private String          word;
 
    public Word() {
        random = new Random();
        this.randomInt = -1;
        this.words = new ArrayList<String>();
        this.words.add("computer");
        this.words.add("spatula");
        this.words.add("monkeys");
        this.words.add("oregano");
        this.words.add("soupcon");
    }
 
    public String getWord() {
        int nextInt = randomInt;
        while (nextInt == randomInt) {
            nextInt = random.nextInt(words.size());
        }
        this.randomInt = nextInt;
 
        this.word = words.get(randomInt);
        return word;
    }
 
    public String getHiddenWord() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            String s = word.substring(i, i + 1);
            if (s.equals(" ") || s.equals(",")) {
                builder.append(s);
            } else {
                builder.append("_");
            }
        }
        return builder.toString();
    }
 
}