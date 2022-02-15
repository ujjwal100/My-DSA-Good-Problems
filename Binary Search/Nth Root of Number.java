// Problem (Pramp) : 
// In this question we’ll implement a function root that calculates the n’th root of a number. 
// The function takes a nonnegative number x and a positive integer n, and returns the positive n’th root of x 
// within an error of 0.001 (i.e. suppose the real root is y, then the error is: |y-root(x,n)| and must satisfy |y-root(x,n)| < 0.001).
class Solution {

  // O(logX) Time O(1) aux space
  static double root(double x, int n) {
      // your code goes here
    double low = 0;
    double high = x;
    
    while (high - low >= 0.001) {
      double mid = low + (high - low) / 2;
      double nthPower = Math.pow(mid, n); // ~ O(1) time
      if (Math.abs(nthPower - x) < 0.001) {
        return mid;
      } else if (nthPower > x) {
        high = mid;
      } else {
        low = mid;
      }
    }
    
    return high; // when x is < 0.001
  }
