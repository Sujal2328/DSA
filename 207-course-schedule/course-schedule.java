class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }
        int[] visited = new int[numCourses];
        int[] pathvisited = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i] == 0){
              if(dfs(i,adj,visited,pathvisited)){
                return false;
              }
            }
        }
        return true;
    }
    public boolean dfs(int node,ArrayList<ArrayList<Integer>> adj, int[] visited,int[] pathvisited){
         visited[node] =1;
         pathvisited[node] =1;
        
        for(int nei : adj.get(node)){
            if(visited[nei]==0){
                if(dfs(nei,
                       adj,
                       visited,
                       pathvisited)) {

                    return true;
                }
            }
            else if(pathvisited[nei] == 1) {

                return true;
            }
        }
        pathvisited[node] = 0;

        return false;
    }
}