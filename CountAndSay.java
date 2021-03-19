package practice;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println( new CountAndSay().getCountAndSay(8));
    }

    private String getCountAndSay(int iteration) {
        String s = "1";
        int i = 1;

        while (i < iteration) {
            s = getNextIteration(s);
            i++;
        }

        return s;
    }

    private String getNextIteration(String s) {
        char prev = s.charAt(0);
        int count = 1;
        String retVal = "";

        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) != prev) {
                retVal = retVal +  count + prev;
                prev = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }

        retVal = retVal +  count + prev;

        return retVal;
    }
}
