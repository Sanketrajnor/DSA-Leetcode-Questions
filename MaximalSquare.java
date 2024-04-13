class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // Initialize memoization array with -1
        }

        int maxSide = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    maxSide = Math.max(maxSide, maximalSquareRecursive(matrix, i, j, memo));
                }
            }
        }

        return maxSide * maxSide;
    }

    private int maximalSquareRecursive(char[][] matrix, int i, int j, int[][] memo) {
        if (i == matrix.length || j == matrix[0].length || matrix[i][j] == '0') {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int right = maximalSquareRecursive(matrix, i, j + 1, memo);
        int down = maximalSquareRecursive(matrix, i + 1, j, memo);
        int diagonal = maximalSquareRecursive(matrix, i + 1, j + 1, memo);

        memo[i][j] = 1 + Math.min(Math.min(right, down), diagonal);
        return memo[i][j];
    }
}
