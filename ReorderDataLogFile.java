package practice;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataLogFile {
    public static void main(String[] args) {
        new ReorderDataLogFile().reorder(new String[3]);
    }

    private String[] reorder(String[] logs) {

//        Comparator<String> letterBeforeDigit = (a, b) -> (a.charAt(a.indexOf(" ") +1 )  - (b.charAt(1)));

        Comparator<String> letterBeforeDigit = Comparator.comparing((String a) -> Character.isDigit(a.charAt(a.indexOf(" ") + 1)));
        Comparator<String> lexicographically = Comparator.comparing((String a) -> a.substring((a.indexOf(" ") + 1)));
        Comparator<String> relativeOrder = (String a, String b) -> 0;
        Comparator<String> identifierOrder = Comparator.comparing(a -> a.substring(0, a.indexOf(" "));
        Comparator<String> lexicoThenIdentifier = lexicographically.thenComparing(identifierOrder);

        Comparator<String> combined = letterBeforeDigit.
                thenComparing((a,b) -> !Character.isDigit(a.charAt(a.indexOf(" ") + 1))
                ? lexicoThenIdentifier.compare(a, b)
                : relativeOrder.compare(a,b));


        Arrays.sort(logs,combined);
        return logs;


    }


}
