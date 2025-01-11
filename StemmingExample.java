import com.aliasi.tokenizer.Tokenization;
import com.aliasi.tokenizer.TokenizerFactory;
import com.aliasi.tokenizer.PorterStemmerTokenizerFactory;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;

public class StemmingExample {
    public static void main(String[] args) {
        usingTheLingPipeStemmer();
    }

    private static void usingTheLingPipeStemmer() {
        String words[] = {"bank", "banking", "banks", "banker", "banked", "bankart"};
        TokenizerFactory tokenizerFactory = IndoEuropeanTokenizerFactory.INSTANCE;
        TokenizerFactory porterFactory = new PorterStemmerTokenizerFactory(tokenizerFactory);

        for (String word : words) {
            Tokenization tokenizer = new Tokenization(word, porterFactory);
            String[] stems = tokenizer.tokens();
            System.out.print("Word: " + word);
            for (String stem : stems) {
                System.out.println("  Stem: " + stem);
            }
        }
    }
}
