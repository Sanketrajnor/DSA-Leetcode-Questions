class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 2) {
                result ^= entry.getKey();
            }
        }
        return result;
    }
}
