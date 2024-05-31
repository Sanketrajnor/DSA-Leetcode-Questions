public class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] res = new int[n];
        int x = 0;
        for (int i = 0; i < n; i++) {
            res[i] = x ^ pref[i];
            x ^= res[i];
        }
        return res;
    }
}
