class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {

            if (color[i] == -1) {

                if (!dfs(i, 0, color, graph)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int node, int clr,
                       int[] color,
                       int[][] graph) {

        color[node] = clr;

        for (int neighbour : graph[node]) {

            if (color[neighbour] == -1) {

                if (!dfs(neighbour,
                         1 - clr,
                         color,
                         graph)) {
                    return false;
                }

            } else if (color[neighbour] == clr) {

                return false;
            }
        }

        return true;
    }
}