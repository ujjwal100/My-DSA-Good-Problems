// (((((((()))))) (())))
// ))))((((()
//  -> L >= R -> ok -> if (L==R) -> leftAns = max(ans, 2 * R )
// else L = R = 0

// from right -> R >= L -> ok - > if (R == L) rightAns = max(ans, 2 * L)

// ans = max(leftAns, rightAns)


// if (L == R) ans = max(ans, L + R)
// 
// ()((( ((())) ans = 6 <-
// from left -> ans = 2
// from right -> ans 


// O(N) Time + O(1) Aux Space
//User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        // code here
        int openCount = 0, closeCount = 0;
        int answer1 = 0, answer2 = 0;
        
        // process from left
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                openCount++;
            } else {
                closeCount++;
            }
            
            if (openCount < closeCount) {
                openCount = closeCount = 0;
            } else if (openCount == closeCount) {
                answer1 = Math.max(answer1, 2 * closeCount);
            }
        }
        
        // process from right
        openCount = closeCount = 0;
        
        for (int i = S.length() - 1; i>= 0; i--) {
            if (S.charAt(i) == '(') {
                openCount++;
            } else {
                closeCount++;
            }
            
            if (closeCount < openCount) {
                openCount= closeCount = 0;
            } else if(openCount == closeCount) {
                answer2 = Math.max(answer2, 2 * openCount);
            }
        }
        
        return Math.max(answer1, answer2);
    }
};
