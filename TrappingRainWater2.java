class Solution {
    public int trapRainWater(int[][] heightMap) {
        
    if (heightMap == null || heightMap.length < 3 || heightMap[0].length < 3) {
            return 0;
        }
        int[][] water = new int[heightMap.length][heightMap[0].length];
        for (int i = 0; i < heightMap.length; i++) {
            System.arraycopy(heightMap[i], 0, water[i], 0, heightMap[i].length);
        }

        boolean updated = true;
        boolean init = true;
        while (updated) {
            updated = false;
            for (int i = 1; i < heightMap.length - 1; i++) {
                for (int j = 1; j < heightMap[i].length - 1; j++) {
                    int val = Math.max(heightMap[i][j], Math.min(water[i - 1][j], water[i][j - 1]));
                    if (init || val < water[i][j]) {
                        water[i][j] = val;
                        updated = true;
                    }
                }
            }
            init = false;
            for (int i = heightMap.length - 2; i > 0; i--) {
                for (int j = heightMap[i].length - 2; j > 0; j--) {
                    int val = Math.max(heightMap[i][j], Math.min(water[i + 1][j], water[i][j + 1]));
                    if (val < water[i][j]) {
                        water[i][j] = val;
                        updated = true;
                    }
                }
            }
        }

        int rs = 0;
        for (int i = 1; i < water.length - 1; i++) {
            for (int j = 1; j < water[0].length - 1; j++) {
                if (water[i][j] - heightMap[i][j] > 0) {
                    rs += water[i][j] - heightMap[i][j];
                }
            }
        }
        return rs;
    }
}
