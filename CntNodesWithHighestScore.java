class Solution {
    public int countHighestScoreNodes(int[] parents) {
        int N = parents.length;

        // Initialize adjacency list and subtree sizes array
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            al.add(new ArrayList<>());
        }
        long[] subtreeSizes = new long[N];

        // Construct adjacency list
        for (int i = 1; i < N; i++) {
            al.get(parents[i]).add(i);
        }

        // Calculate subtree sizes using DFS
        dfs(al, subtreeSizes, 0);

        long maxSubtreeSize = Arrays.stream(subtreeSizes).max().getAsLong();
        return (int)Arrays.stream(subtreeSizes).filter(size -> size == maxSubtreeSize).count();
    }

    // DFS function to calculate subtree sizes and update the array s    
    private long dfs(List<List<Integer>> al, long[] subtreeSizes, int currNode) {
        long productOfSizes = 1, sumOfSizes = 1;

        // Traverse neighbors of the current node
        for (int neighbor : al.get(currNode)) {
            long neighborSize = dfs(al, subtreeSizes, neighbor);
            productOfSizes *= neighborSize;
            sumOfSizes += neighborSize;
        }

        // Update subtreeSizes array for the current node
        subtreeSizes[currNode] = productOfSizes * Math.max(1, al.size() - sumOfSizes);

        // Return the sum of subtree sizes
        return sumOfSizes;
    }
}
