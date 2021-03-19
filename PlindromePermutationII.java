package practice;

import java.util.*;

public class PlindromePermutationII {
    Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        new PlindromePermutationII().generatePalindromes("aabbc");
    }

    public List<String> generatePalindromes(String s) {
        // write your code here
        Map<Character, Integer> map = new HashMap<>();
        if(!canPermutePalindrome(s, map)){
            return new ArrayList<>();
        }

        List<Character> charList = new ArrayList();
        char[] st = new char[s.length() / 2];
        char oddChar = ' ';

        for(Map.Entry<Character, Integer> c : map.entrySet() ){
            int count = c.getValue();
            if(c.getValue() % 2 == 1){
                oddChar = c.getKey();
            }
            while(count > 1){
                charList.add(c.getKey());
                count = count /2;
            }
        }

        permute(charList, 0, oddChar);
        return new ArrayList<String>(set);
    }

    private void permute(List<Character> charList, int start, char oddChar) {
        char[] chararr = new char[charList.size()];
        for (int i =0; i<charList.size(); i++) {
            chararr[i] = charList.get(i);
        }
        Arrays.sort(chararr);

        boolean repeat;
        NexxtPermutation np = new NexxtPermutation();

        do {
            String aStr = getString(chararr, 0, oddChar);
            System.out.println(aStr);
            repeat = np.nextPermutation(chararr);
        } while (repeat);
    }

    private String getString(char[] chararr, int i, char oddChar) {
        if (i == chararr.length) {
            return oddChar == ' ' ? "" : oddChar + "";
        }
        return chararr[i] + getString(chararr, i+1, oddChar) + chararr[i];
    }

    public boolean canPermutePalindrome(String s, Map<Character, Integer> map) {
        // write your code here

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int oddCount = 0;

        for(char c : map.keySet()){
            oddCount += map.get(c) % 2;
        }
        return oddCount <= 1;
    }
}
