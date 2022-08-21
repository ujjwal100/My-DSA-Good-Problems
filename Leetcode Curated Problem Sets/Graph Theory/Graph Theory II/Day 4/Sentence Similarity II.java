/*
Q : https://leetcode.com/problems/sentence-similarity-ii/
Q : link : https://tinyurl.com/sentence-similarity-ii
TC : O(L1 + l2) = O(N)
SC : O(L1 + L2) = O(N)

*/
class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        DSU dsu = new DSU();
        for (String str : sentence1) {
            dsu.makeSet(str);
        }
        for (String str : sentence2) {
            dsu.makeSet(str);
        }
        
        for (List<String> similarWords : similarPairs) {
            dsu.makeSet(similarWords.get(0));
            dsu.makeSet(similarWords.get(1));
        }
        
        for (List<String> similarWords : similarPairs) {
            dsu.unionSet(similarWords.get(0), similarWords.get(1));
        }
        
        if (sentence1.length != sentence2.length) {
            return false;
        }
        
        for (int i = 0; i < sentence1.length; i++) {
            if (!dsu.findSet(sentence1[i]).equals(dsu.findSet(sentence2[i]))) {
                return false;
            }
        }
        
        return true;
    }
    
    static class DSU {
        HashMap<String, String> parent;
        HashMap<String, Integer> size;
        
        public DSU() {
            parent = new HashMap<>();
            size = new HashMap<>();
        }
        
        public void makeSet(String c) {
            parent.put(c, c);
            size.put(c, 1);
        }
        
        public String findSet(String c) {
            if (parent.get(c).equals(c)) {
                return c;
            }
            
            String parentStr = findSet(parent.get(c));
            parent.put(c, parentStr);
            return parentStr;
        }
        
        public void unionSet(String c1, String c2) {
            String p1 = findSet(c1);
            String p2 = findSet(c2);
            
            if (!p1.equals(p2)) {
                if (size.get(p2) > size.get(p1)) {
                    String temp = p1;
                    p1 = p2;
                    p2 = temp;
                }
                parent.put(p2, p1);
                size.put(p1, size.get(p1) + size.get(p2));
            }
        }
    }
}
