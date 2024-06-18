class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int ret = 0;
        for (int i = trainers.length - 1, j = players.length - 1; i >= 0 && j >= 0; j--) {
            if (trainers[i] >= players[j]) {
                ret++;
                i--;
            }
        }
        return ret;
    }
}
