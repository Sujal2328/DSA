
class Solution {
    public String[] findRelativeRanks(int[] score) {

        String[] ans = new String[score.length];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        
        for (int i = 0; i < score.length; i++) {
            pq.add(new int[]{score[i], i});
        }

        int rank = 1;

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int index = current[1];

            if (rank == 1) {
                ans[index] = "Gold Medal";
            }
            else if (rank == 2) {
                ans[index] = "Silver Medal";
            }
            else if (rank == 3) {
                ans[index] = "Bronze Medal";
            }
            else {
                ans[index] = String.valueOf(rank);
            }

            rank++;
        }

        return ans;
    }
}