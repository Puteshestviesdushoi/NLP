import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.ling.*;

import java.io.StringReader;
import java.util.Properties;

public class TokenizationWithStanford {
    private static String paragraph = "Let's pause, and then reflect.";

    public static void main(String[] args) {
        usingTheStanfordTokenizer();
    }

    private static void usingTheStanfordTokenizer() {
        Properties props = new Properties();
        props.put("annotators", "tokenize");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        
        Annotation document = new Annotation(paragraph);
        pipeline.annotate(document);
        
        for (CoreMap sentence : document.get(SentencesAnnotation.class)) {
            for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
                System.out.println(token.word());
            }
        }
    }
}
