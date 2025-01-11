import java.io.StringReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class TokenizationWithStreamTokenizer {
    public static void main(String[] args) {
        try {
            StreamTokenizer tokenizer = new StreamTokenizer(new StringReader("Let's pause, and then reflect."));
            boolean isEOF = false;

            while (!isEOF) {
                int token = tokenizer.nextToken();
                switch (token) {
                    case StreamTokenizer.TT_EOF:
                        isEOF = true;
                        break;
                    case StreamTokenizer.TT_WORD:
                        System.out.println(tokenizer.sval);
                        break;
                    case StreamTokenizer.TT_NUMBER:
                        System.out.println(tokenizer.nval);
                        break;
                    default:
                        System.out.println((char) token);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }
}
