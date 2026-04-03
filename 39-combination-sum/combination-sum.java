class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        solve(0,candidates,target,ds,ans);
                return ans;
            }
     public void solve(int index, int[] candidates,int target,List<Integer>ds,List<List<Integer>> ans){
        int n  = candidates.length;
        if(target==0){
           
           ans.add(new ArrayList<>(ds));
            return ;
            
        }
        if(index == n){
            return;
        }
             if(candidates[index] <= target){
                ds.add(candidates[index]);
                 solve(index, candidates, target - candidates[index], ds, ans);
                 ds.remove(ds.size() - 1);
             }
             solve(index + 1, candidates, target, ds, ans);

     }
}