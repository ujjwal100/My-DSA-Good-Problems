// Problem : https://leetcode.com/problems/gas-station/
// Reference Video Solution : https://youtu.be/zcnVaVJkLhY
// O(N) Time +  O(1) Aux space
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int prevBalance = 0, currBalance = 0, index = 0;
        for (int i = 0; i < gas.length; i++) {
            currBalance += gas[i] - cost[i];
            if (currBalance < 0) {
                prevBalance += currBalance;
                currBalance = 0;
                index = i + 1;
            }
        }
        return (prevBalance + currBalance >= 0 ? index : -1);
    }
}
