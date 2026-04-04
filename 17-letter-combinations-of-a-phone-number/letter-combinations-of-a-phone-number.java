class Solution {
    public List<String> letterCombinations(String digits) {
         List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        String[] map = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };

        StringBuilder sb = new StringBuilder();

        solve(0, digits, map, sb, ans);

        return ans;
    }
     public void solve(int index, String digits, String[] map, StringBuilder sb,List<String
     > ans){

   if(index == digits.length()){
     ans.add(sb.toString());
     return;
   }
     String letters = map[digits.charAt(index) - '0'];

for (char ch : letters.toCharArray()) {
    sb.append(ch);
    solve(index + 1, digits, map, sb, ans);
    sb.deleteCharAt(sb.length() - 1);
        }
     }

     
}