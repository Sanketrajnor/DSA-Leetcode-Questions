class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        
        Arrays.sort(freq);
        int maxFreq = freq[25] - 1;
        int idleSlots = maxFreq * n;
        
        for (int i = 24; i >= 0; i--) {
            idleSlots -= Math.min(freq[i], maxFreq);
        }
        
        return tasks.length + Math.max(0, idleSlots);
    }
}
