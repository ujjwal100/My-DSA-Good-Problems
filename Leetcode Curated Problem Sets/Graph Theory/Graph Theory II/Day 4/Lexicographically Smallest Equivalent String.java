/*
Q : https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
Link : https://tinyurl.com/lexico-small-equi-str
TC : O(L1 + L2) = O(N)
SC : O(26) = O(1)
*/
class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DSU dsu = new DSU();
        for (char c = 'a'; c <= 'z'; c++) {
            dsu.makeSet(c);
        }
        for (int i = 0; i < s1.length(); i++) {
            dsu.unionSet(s1.charAt(i), s2.charAt(i));
        }
        
        String ans = "";
        for (int i = 0; i < baseStr.length(); i++) {
            ans += dsu.findSet(baseStr.charAt(i));
        }
        
        return ans;
    }
    
    static class DSU {
        HashMap<Character, Character> parent;
        
        public DSU() {
            parent = new HashMap<>();
        }
        
        public void makeSet(char c) {
            parent.put(c, c);
        }
        
        public char findSet(char c) {
            if (parent.get(c) == c) {
                return c;
            }
            
            char parentChar = findSet(parent.get(c));
            parent.put(c, parentChar);
            return parentChar;
        }
        
        public void unionSet(char c1, char c2) {
            char p1 = findSet(c1);
            char p2 = findSet(c2);
            
            if (p1 != p2) {
                if (p2 > p1) {
                    char temp = p1;
                    p1 = p2;
                    p2 = temp;
                }
                parent.put(p1, p2);
            }
        }
    }
}
