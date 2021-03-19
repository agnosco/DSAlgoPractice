package practice;

import org.springframework.util.StringUtils;

import java.util.*;

public class WordsLadderCount {

    public static void main(String[] args) {
        List<List<String>> ladders = new WordsLadderCount()
                .ladderLength("red", "tax", Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));

        for (List<String> ladder : ladders) {
            System.out.println(ladder);
        }
    }

    public List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();

        Queue<String> stringQueue = new LinkedList<>();
        Queue<Integer> stepQueue = new LinkedList<>();
        Queue<List<String>> wordLadderSoFar = new LinkedList<>();
        stringQueue.add(beginWord);
        stepQueue.add(1);
        wordLadderSoFar.add(Arrays.asList(beginWord));

        List<List<String>> retVal = new ArrayList<>();
        int minSteps = -1;

        while (!stringQueue.isEmpty()){
            String word = stringQueue.poll();
            int step = stepQueue.poll();
            List<String> wordLadder = wordLadderSoFar.poll();

            if(!visited.contains(word)){
                List<String> words = getWordOneDiff(word, wordList, visited);
                visited.add(word);

                for (String oneWord: words ) {
                    if(oneWord.equals(endWord)){
                        if (minSteps == -1) {
                            minSteps = step+1;
                        } else if (step+1 != minSteps) {
                            continue;
                        }

                        List<String> wordsSoFar = new ArrayList<>(wordLadder);
                        wordsSoFar.add(oneWord);
                        retVal.add(wordsSoFar);

                        continue;
                    }
                    stringQueue.add(oneWord);
                    stepQueue.add(step + 1);

                    List<String> wordsSoFar = new ArrayList<>(wordLadder);
                    wordsSoFar.add(oneWord);
                    wordLadderSoFar.add(wordsSoFar);
                }
            }
        }

        return retVal;
    }

    private List<String> getWordOneDiff(String word, List<String> wordList, Set<String> visited) {
        List<String> oneDiffWord = new ArrayList<>();

        for(String aWord : wordList){
            if (Math.abs(aWord.length() - word.length()) >= 2
                  || visited.contains(aWord)) {
                continue;
            }

            int diffCount = 0;
            int length = 0;
            while(diffCount <= 2  && length < aWord.length()){
                if(word.charAt(length) !=  aWord.charAt(length)){
                    diffCount++;
                }
                length++;
            }
            if(diffCount < 2){
                oneDiffWord.add(aWord);
            }
        }
        return oneDiffWord;
    }
}
