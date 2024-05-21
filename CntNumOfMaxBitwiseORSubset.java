class Solution {
    int ans;
    int maxOr;
    int n;
    int[] nums;

    public int countMaxOrSubsets(int[] nums) {
        ans = 0;
        maxOr = 0;
        n = nums.length;
        this.nums = nums;
        for (int x : nums) {
            maxOr |= x;
        }
        for (int i = 0; i < n; i++) {
            backtracking(nums[i], i + 1);
        }
        return ans;
    }

    private void backtracking(int or, int start) {
        if (maxOr == or) {
            ans = ans + (1 << (n - start));
            return;
        }

        for (int i = start; i < n; i++) {
            backtracking(or | nums[i], i + 1);
        }
    }
}
