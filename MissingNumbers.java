class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumN = n * (n + 1) / 2;
        int sumArray = 0;
        for (int num : nums) {
            sumArray += num;
        }
        return sumN - sumArray;
    }
}
