import com.aliasi.tokenizer.TokenizerFactory;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.EnglishStopTokenizerFactory;
import com.aliasi.tokenizer.Tokenizer;

public class StopWordsExample {
    public static void main(String[] args) {
        usingLingpipeStopWord();
    }

    private static void usingLingpipeStopWord() {
        String paragraph = "A simple approach is to create a class to hold and remove stopwords.";
        TokenizerFactory factory = IndoEuropeanTokenizerFactory.INSTANCE;
        factory = new EnglishStopTokenizerFactory(factory);
        Tokenizer tokenizer = factory.tokenizer(paragraph.toCharArray(), 0, paragraph.length());

        while (tokenizer.hasNext()) {
            System.out.println(tokenizer.next());
        }
    }
}
