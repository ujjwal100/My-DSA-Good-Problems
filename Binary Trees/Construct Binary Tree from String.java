// LC Premium Fb 
// Problem : https://github.com/ujjwal100/My-DSA-Good-Problems/blob/main/LC%20Premium/Construct%20Binary%20Tree%20from%20String%20-%20LeetCode.pdf
// O(N * L) time + O(H) Space
// N -> No. of Nodes L -> Len of String
class Solution {
    public TreeNode str2tree(String s) {
        if (s.length() == 0) {
            return null;
        }
        
        // extract root
        int i = 0;
        while (i < s.length() && s.charAt(i) != '(') {
            i++;
        }
        
        int rootValue = 1;
        int start = 0;
        
        if (s.charAt(start) == '-') {
            start++;
            rootValue = -1;
        }
        
        rootValue *= Integer.valueOf(s.substring(start, i));
        TreeNode root = new TreeNode(rootValue);
        
        // left & right subtrees
        int leftSubTreeStart = i;
               
        if (leftSubTreeStart < s.length()) {
            int leftSubTreeEnd = getEndingIndexOfSubtree(s, leftSubTreeStart);
            root.left = str2tree(s.substring(leftSubTreeStart + 1, leftSubTreeEnd));
            int rightSubTreeStart = leftSubTreeEnd + 1;
            if (rightSubTreeStart < s.length()) {
                root.right = str2tree(s.substring(rightSubTreeStart + 1, s.length() - 1));
            }
        }
        
        return root;
        
    }
    
    private int getEndingIndexOfSubtree(String s, int startIndex) {
        if (startIndex >= s.length()) {
            return s.length();
        }
        
        int count = 0;
        int i = startIndex;
        do {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                 count--;
            }
            i++;
        } while (count != 0 && i < s.length());
        
        return i - 1;
    }
}
