public class Solution {
    public int minBitFlips(int start, int goal) {
        int res = 0;
        // The 'maxi' variable is not needed since we're iterating until both start and goal are 0.
        while (start != 0 || goal != 0) {
            // Check if the least significant bits of start and goal are different
            if ((start & 1) != (goal & 1))
                res++;

            // Right shift start and goal to check the next bit in the next iteration
            start = start >> 1;
            goal = goal >> 1;
        }

        return res;
    }
}
