/*
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.LowerCaseTokenizerFactory;
import com.aliasi.tokenizer.EnglishStopTokenizerFactory;
import com.aliasi.tokenizer.PorterStemmerTokenizerFactory;
import com.aliasi.tokenizer.TokenizerFactory;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.util.CoreMap;
*/

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.tokenize.TokenSampleStream;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
*/
public class TDemo {
	private static String paragraph = "Let's pause, \nand then reflect.";

	public static void main(String[] args) {
	//Токенизация при помощи объекта класса Scanner 
	System.out.println("Использование класса Scanner для токенизации");
	usingTheScannerClass();

	}

	private static void usingTheScannerClass(){
		Scanner scanner = new Scanner(paragraph);
		List<String> list = new ArrayList<>();
		//Указываемразделители
		scanner.useDelimiter("[ ,.]");

		while (scanner.hasNext()) {
			String token = scanner.next();
			list.add(token);
		}
		for (String token:list) {
			System.out.println(token);
		}
	}
}
