// LC-Premium Question -> https://github.com/ujjwal100/My-DSA-Good-Problems/blob/main/LC%20Premium/Shortest%20Word%20Distance%20II%20-%20LeetCode.pdf 
// O(words1.len + words2.len) TC per Query
class WordDistance {
    Map<String, List<Integer>> wordsMap;

    public WordDistance(String[] wordsDict) {
       populateWordsIndexMap(wordsDict);
        
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> words1 = wordsMap.get(word1);
        List<Integer> words2 = wordsMap.get(word2);
        int answer = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < words1.size() && j < words2.size()) {
            answer = Math.min(Math.abs(words1.get(i) - words2.get(j)), answer);
            if (words1.get(i) <= words2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return answer;
        
    }
    
    private void populateWordsIndexMap(String[] wordsDict) {
        wordsMap = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsMap.get(wordsDict[i]) == null) {
                wordsMap.put(wordsDict[i], new ArrayList<Integer>());
            }
            wordsMap.get(wordsDict[i]).add(i);
        }
        
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
