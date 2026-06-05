class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        int[] pathvisited = new int[n];
        int[] check = new int[n];

        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i,graph,visited,pathvisited,check);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]==1){
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean dfs(int node,int[][] graph,int[] visited, int[] pathvisited,int[] check){
        visited[node] =1;
        pathvisited[node] =1;

        for(int nei: graph[node]){
            if(visited[nei]==0){
                if(dfs(nei,graph,visited,pathvisited,check)){
                    return true;
                }
            }
            else if(pathvisited[nei]==1){
                return true;
            }
            
        }
          pathvisited[node] = 0;


        check[node] = 1;

        return false;
    }
}