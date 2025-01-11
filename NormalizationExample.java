public class NormalizationExample {
    public static void main(String[] args) {
        usingLingPipeForNormalization();
    }

    private static void usingLingPipeForNormalization() {
        String paragraph = "A simple approach is to create a class to hold and remove stopwords.";
        String result = paragraph.toLowerCase();
        System.out.println(result + "\nЗавершено ЛингПайп--------");
    }
}
