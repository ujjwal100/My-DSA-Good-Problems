class Solution {
    public int longestStrChain(String[] words) {
        HashSet<String> wordSet = new HashSet<>();
        wordSet.addAll(Arrays.asList(words));
        HashMap<String, Integer> dp = new HashMap<>();
        int ans = 0;
        for (String word : words) {
            ans = Math.max(ans, getLongestStrChain(word, wordSet, dp));
        }
        return ans;
    }
    
    int getLongestStrChain(String word, HashSet<String> wordSet, HashMap<String, Integer> dp) {
        if (dp.containsKey(word)) {
            return dp.get(word);
        }
        
        int ans = 0;
        
        if (wordSet.contains(word)) {
            for (int i = 0; i < word.length(); i++) {
            String next = word.substring(0, i) + word.substring(i + 1);
            ans = Math.max(ans, 1 + getLongestStrChain(next, wordSet, dp));
            }
        }
        
        
        dp.put(word, ans);
        return ans;
    }
}
