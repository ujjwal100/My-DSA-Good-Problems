// Problem : https://tinyurl.com/coding-ninjas-painters-partion
import java.util.*;
// DP -> O(N^2)
// if arr[i] > arr[i+1] -> painter++
// else 
//  getMinTime(k, i) -> time = sum arr[i..j]
// if arr[i] > arr[i+1] -> getMinTime(k - 1, i+1)
// else 

// O(NlogN)
// min = min of all
// max = sum
// time -> if painters > k -> time to increase -> low = mid + 1 else high = mid - 1
// isTimeEnough()

public class Solution 
{
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.

        int low = 0;
        int high = 0;
        for (int area : boards) {
            high += area;
        }
        int time = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isTimeEnough(boards, k, mid)) {
                time = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return time;
    }

    private static boolean isTimeEnough(ArrayList<Integer> boards, int k, int timeLimit) {
        int painters = 0;
        int timePerHead = 0;
        for (int timePerBoard : boards) {
            if (timePerBoard > timeLimit) {
                return false;
            } else {
                if (timePerHead + timePerBoard <= timeLimit) {
                    timePerHead += timePerBoard;
                } else {
                    timePerHead = timePerBoard;
                    painters++;
                }
            }
        }

        return painters < k;
    }
}
