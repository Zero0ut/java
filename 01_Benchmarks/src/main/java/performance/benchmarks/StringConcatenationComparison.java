package performance.benchmarks;

public class StringConcatenationComparison {


    public static void main(String[] args){

        String[] words = new String[]{"How", "fast", "is", "String.format", "versus", "concatenation"};

        int numberOfIterations = 1000000;
        int numberOfWords = 5;

        // --------------------------------------------------------
        // String Concatenation
        // --------------------------------------------------------

        long start = System.currentTimeMillis();
        for (int i = 0; i < numberOfIterations; i++) {
            String s = "";
            for (String word : words) {
                s+=word;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Concatenation = " + (end - start) + " millisecond") ;

        // --------------------------------------------------------
        // String.Format
        // --------------------------------------------------------

        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfIterations; i++) {
            String s = String.format("%s%s%s%s%s%s",words[0],words[1],words[2],words[3],words[4],words[5]);
        }
        end = System.currentTimeMillis();
        System.out.println("String.format = " + (end - start) + " millisecond") ;

        // --------------------------------------------------------
        // StringBuilder
        // --------------------------------------------------------

        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfIterations; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(words[0]);
            sb.append(words[1]);
            sb.append(words[2]);
            sb.append(words[3]);
            sb.append(words[4]);
            sb.append(words[5]);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder = " + (end - start) + " millisecond");



        /*
         * Results on Java 8
         */

        /*
            Concatenation = 244 millisecond
            String.format = 2848 millisecond
            StringBuilder = 238 millisecond
        */

    }
}
