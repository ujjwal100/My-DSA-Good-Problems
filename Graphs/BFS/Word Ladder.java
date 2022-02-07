// Problem : https://leetcode.com/problems/word-ladder/
//
// L -> length of word 
// N -> wordList length
// O(L * N) time 
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        for (String word : wordList) {
            words.add(word);
        }
        
        if (beginWord.equals(endWord) || !words.contains(endWord)) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0;
        Set<String> isVisited = new HashSet<>();
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                String word = queue.poll();
                
                for (int i = 0; i < word.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        String newWord = word.substring(0, i) + ch + word.substring(i+1);
                        if (words.contains(newWord) && (!isVisited.contains(newWord))) {
                            if (newWord.equals(endWord)) {
                                return level + 1;
                            }
                            isVisited.add(newWord);
                            queue.add(newWord);
                        }
                    }
                }
                
            }
        }
        
        return 0;
    }
}
