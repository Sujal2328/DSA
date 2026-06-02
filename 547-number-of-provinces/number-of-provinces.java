class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        int count = 0;

        for(int i = 0;i<n;i++){
            if(!visited[i]){
                dfs(isConnected,visited,i);
                count++;
            }
        }
        return count ;
    }
    public void dfs(int[][] graph,boolean[] visited,int city){
        visited[city] = true;
        for(int nei = 0;nei<graph.length;nei++){
            if(graph[city][nei] == 1 && !visited[nei]){
                dfs(graph,visited,nei);
            }
        }
    }
}