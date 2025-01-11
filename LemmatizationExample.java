import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.ling.*;
import java.util.Properties;

public class LemmatizationExample {
    public static void main(String[] args) {
        usingTheStanfordLemmatizer();
    }

    private static void usingTheStanfordLemmatizer() {
        String paragraph = "Similar to stemming is Lemmatization. This is the process of finding its lemma.";

        Properties props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, lemma");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        
        Annotation document = new Annotation(paragraph);
        pipeline.annotate(document);
        
        for (CoreMap sentence : document.get(SentencesAnnotation.class)) {
            for (CoreLabel word : sentence.get(TokensAnnotation.class)) {
                System.out.println(word.lemma());
            }
        }
    }
}
