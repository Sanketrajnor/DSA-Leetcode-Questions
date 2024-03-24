class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            if (hm.containsKey(num) == true) {
                int temp = hm.get(num);
                hm.put(num, temp + 1);
            } else {
                hm.put(num, 1);
            }
        }
        for (int ans : nums) {
            if (hm.get(ans) != 1) {
                return ans;
            }
        }
        return -1;
    }
}
