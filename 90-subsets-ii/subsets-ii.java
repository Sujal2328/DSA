class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> st = new ArrayList<>();
                    
        Arrays.sort(nums);
       
        
        solve(0,nums,st,ans);

        return ans;
    }

    public void solve (int index,int[] nums, List<Integer> st,List<List<Integer>> ans){
        
            ans.add(new ArrayList<>(st));
          
           
           for(int i=index;i< nums.length;i++){
            if(i>index && nums[i] == nums[i-1]){
                continue;
            }
            
            st.add(nums[i]);
            solve(i + 1, nums, st,ans);
            st.remove(st.size() - 1);
    }
    }
}