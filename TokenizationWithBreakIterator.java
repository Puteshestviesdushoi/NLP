import java.text.BreakIterator;

public class TokenizationWithBreakIterator {
    public static void main(String[] args) {
        BreakIterator wordIterator = BreakIterator.getWordInstance();
        String text = "Let's pause, and then reflect.";
        wordIterator.setText(text);
        int boundary = wordIterator.first();
        
        while (boundary != BreakIterator.DONE) {
            int begin = boundary;
            boundary = wordIterator.next();
            int end = boundary;
            if (end == BreakIterator.DONE) break;
            System.out.println(boundary + " [" + text.substring(begin, end) + "]");
        }
    }
}
