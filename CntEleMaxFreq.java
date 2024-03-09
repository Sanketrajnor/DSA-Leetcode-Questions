class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hs.put(nums[i], hs.getOrDefault(nums[i], 0) + 1);
            maxi = Math.max(maxi, hs.get(nums[i]));
        }
        int res = 0;
        for (int keys : hs.keySet()) {
            if (hs.get(keys) == maxi)
                res += hs.get(keys);
        }
        return res;
    }
}