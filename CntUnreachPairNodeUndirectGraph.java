class Solution {
    public long countPairs(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 1; i < roots.length; i++) {
            roots[i] = i;
        }

        for (int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1];
            while (n1 != roots[n1]) {
                n1 = roots[n1];
            }
            while (n2 != roots[n2]) {
                n2 = roots[n2];
            }
            
            int newRoot = Math.min(n1, n2);
            roots[n1] = newRoot;
            roots[n2] = newRoot;
        }

        int[] rootLengths = new int[n];
        for (int i = 0; i < n; i++) {
            int node = i;
            while (roots[node] != node) {
                node = roots[node];
            }
            rootLengths[node]++;
        }

        long result = 0;
        for (int i = 0; i < rootLengths.length; i++) {
            int len = rootLengths[i];
            result += (long) len * (n - len);
            n -= len;
        }
        return result;
    }
}
