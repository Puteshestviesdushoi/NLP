import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.InputStream;

public class TokenizationWithOpenNLP {
    private static String paragraph = "Let's pause, and then reflect.";

    public static void main(String[] args) {
        usingTheSimpleTokenizerClass();
        // usingTheTokenizerMEClass(); // Uncomment to test TokenizerME
    }

    private static void usingTheSimpleTokenizerClass() {
        System.out.println("--- SimpleTokenizer");
        SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;
        String tokens[] = simpleTokenizer.tokenize(paragraph);
        for (String token : tokens) {
            System.out.println(token);
        }
    }

    // Example method for TokenizerME (to be uncommented)
    private static void usingTheTokenizerMEClass() {
        try {
            InputStream modelIn = new FileInputStream("path/to/your/model.bin");
            TokenizerModel model = new TokenizerModel(modelIn);
            TokenizerME tokenizer = new TokenizerME(model);
            String tokens[] = tokenizer.tokenize(paragraph);
            for (String token : tokens) {
                System.out.println(token);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
