public class TokenizationWithSplit {
    public static void main(String[] args) {
        String text = "Mr. Smith went to 123 Washington avenue.";
        String tokens[] = text.split("\\s+");
        for (String token : tokens) {
            System.out.println(token);
        }

        text = "Let's pause, and then reflect.";
        tokens = text.split("[ ,.]");
        for (String token : tokens) {
            System.out.println(token);
        }
    }
}
