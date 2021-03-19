package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wordbreakii {
    public static void main(String[] args) {
        String s= "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        new wordbreakii().wordBreak("", new ArrayList<>(
                Arrays.asList( "a","aa","aaa","aaaa","aaaaa","aaaaaa")), 0, new ArrayList[s.length()]);

//        "aaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//                ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
    }

    private List<String> wordBreak(String s, ArrayList<String> strings, int i, List<String> [] memo) {
        if(memo[i] != null ){
            return memo[i];
        }
        if(i == s.length()){
            return Arrays.asList("");
        }

        List<String> res = new ArrayList<>();
        for (int j = i + 1; j <= s.length(); j++) {
            String pmatch = s.substring(i, j);
            if(strings.contains(pmatch)) {

                List<String> next = wordBreak(s, strings, j, memo);
                if (!next.isEmpty()) {
                    for (String suffix : next) {
                        res.add(pmatch + (suffix.equals("") ? "" : " ") + suffix);
                    }
                }
            }
        }

        memo[i] = res;
        return res;
    }
}
