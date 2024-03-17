
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int st = newInterval[0], end = newInterval[1];
        boolean inserted = false;
        for (int[] inv : intervals) {
            int cst = inv[0], cend = inv[1];
            if(cend < st || inserted){
                ans.add(new int[]{cst,cend});
                continue;
            }
            st = Math.min(st, cst);
            if(end < cst){
                ans.add(new int[]{st, end});
                ans.add(new int[]{cst, cend});
                inserted = true;
                continue;
            }
            if (end <= cend) {
                ans.add(new int[]{st, cend});
                inserted = true;
                continue;
            }
        }
        if (!inserted) {
            ans.add(new int[]{st, end});
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
