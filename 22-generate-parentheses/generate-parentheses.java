class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
      
       solve(0,0, n, ans,sb);
      
        return ans;
    }
    public void solve(int open,int close,int n,List<String> ans , StringBuilder sb){

        if(sb.length() == 2*n){
            ans.add(sb.toString());
        }

        if(open<n){
            sb.append('(');
            solve(open+1,close,n,ans,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(')');
            solve(open,close+1,n,ans,sb);
            sb.deleteCharAt(sb.length()-1);
        }
         
    }
}