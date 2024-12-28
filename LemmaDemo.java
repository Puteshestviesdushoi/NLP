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
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.tokenize.TokenSampleStream;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.postag.POSModel;
import opennlp.tools.lemmatizer.DictionaryLemmatizer;
import opennlp.tools.postag.POSTaggerME;


public class LemmaDemo {
	private static String paragraph = "Let's pause, \nand then reflect. They enjoy hiking in the mountains.";
	public static void main (String[] args) {
		System.out.println("Токенизация при помощи библиотеки OpenNLP");
		System.out.println("\nИспользование класса SlimleTokenize");
		SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;
		String tokens[] = simpleTokenizer.tokenize(paragraph);
		for (String token : tokens) {
			 System.out.println(token);
		}
		System.out.println("\n\n");
		System.out.println("Токенизация при помощи WhitespaceTokenizer");
		tokens = WhitespaceTokenizer.INSTANCE.tokenize(paragraph);
		for (String token : tokens) {
			System.out.println(token);

		}
		System.out.println("\n\n");
	
		System.out.println("Использование класса TokenizerME");
		try {
			InputStream modelIn = new FileInputStream(new File(getModelDir(), "opennlp-en-ud-ewt-tokens-1.2-2.5.0.bin"));
			TokenizerModel model = new TokenizerModel(modelIn);
			Tokenizer tokenizer = new TokenizerME(model);
			tokens = tokenizer.tokenize(paragraph);
                	for (String token : tokens) {
                        	System.out.println(token);
			}
		System.out.println("\n\n");
		} catch (IOException ex){
			
			ex.printStackTrace();
	
		}

		System.out.println("\nИспользование класса TokenizerME на русском ");
                try {
                        InputStream modelIn1 = new FileInputStream(new File(getModelDir(), "opennlp-en-ud-ewt-tokens-1.2-2.5.0.bin"));

                        TokenizerModel model1 = new TokenizerModel(modelIn1);
                        Tokenizer tokenizer1 = new TokenizerME(model1);
			String paragraph1 = "Проврка, какая-то бим бим бам бам. Дима осуждает";
                        			String tokens1[] = tokenizer1.tokenize(paragraph1);
                        for (String token : tokens1) {
                                System.out.println(token);
                        }
                System.out.println("\n\n");
                } catch (IOException ex){

                        ex.printStackTrace();
		}
   		System.out.println("\n\n");
		// лемматизация при помощи библиотек OpenNLP
		System.out.println("Лемматизация OpenNLP");
		try {
			//Подключение модели для распределения частей речи 
			InputStream posModelIN = new FileInputStream("/home/share/4.142.2.23/openNLPModels/en-pos-maxent.bin");
			POSModel posModel = new POSModel(posModelIN);
			POSTaggerME posTagger = new POSTaggerME(posModel);

			//разметка токенов
			String[] tags = posTagger.tag(tokens);
			//загрузка словаря с леммами
			InputStream dictLemmatizer = new FileInputStream("/home/share/4.142.2.23/openNLPModels/en-lemmatizer.txt");
			DictionaryLemmatizer lemmatizer = new DictionaryLemmatizer(dictLemmatizer);
			String[] tagsN = new String[tokens.length];
			for (int i=0;i < tokens.length; i++) {
				tokens[i].toLowerCase();
                                 switch (tags[i]){
				 	case "NOUN": 
						if (tokens[i].charAt(tokens[i].length()-1)=='s')
							tagsN[i] = "NNS";
						else
							tagsN[i] = "NN";
						break;
					case "VERB":
					       if (tokens[i].charAt(tokens[i].length()-1)=='g')
                                                        tagsN[i] = "VBG";
                                                else
                                                        tagsN[i] = "VB";
    						break;
					case "PRON": 
						tagsN[i] = "PRP";
                                            	break;
					case "CCONJ": 
					    tagsN[i] = "CC";
                                            break;
					case "ADV": 
					    tagsN[i] = "JJ";
                                            break;
					case "ADP": 
					    tagsN[i] = "RP";
                                            break;
					case "DET": 
					    tagsN[i] = "DT";
                                            break;
				 }
                        }

			//Получение лемм
			String[] lemmas = lemmatizer.lemmatize(tokens, tagsN);

			//вывод результатов
			System.out.println("\nРузультат лемматизации с помощью OpenNLP");
			System.out.println("\nСлово - Часть речи: Лемма");
			for (int i=0;i < tokens.length; i++) {
				System.out.println(tokens[i] + " - " + tags[i] + " :  " +lemmas[i]);
			}

			System.out.println("\n\n");
			} catch (IOException ex){
			ex.printStackTrace();
			}
			}
	public static File getModelDir() {
		return new File ("/home/share/4.142.2.23/openNLPModels");

	}
} 

