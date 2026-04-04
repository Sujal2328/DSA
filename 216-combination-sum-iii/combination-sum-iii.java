import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> st = new ArrayList<>();

        solve(1, k, n, st, ans);

        return ans;
    }

    public void solve(int start, int k, int target, List<Integer> st, List<List<Integer>> ans) {

        if (k == 0 && target == 0) {
            ans.add(new ArrayList<>(st));
            return;
        }

       
        if (k == 0 || target < 0 || start > 9) {
            return;
        }

     
        st.add(start);
        solve(start + 1, k - 1, target - start, st, ans);

        
        st.remove(st.size() - 1);

        solve(start + 1, k, target, st, ans);
    }
}