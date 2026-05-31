class Solution {
    public int numberOfSubstrings(String s) {
        
        int left =0;
        int n  = s.length();
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int right = 0; right<n;right++){
            char ch = s.charAt(right);
         
            map.put(ch, map.getOrDefault(ch, 0) + 1);
       
       while(map.size()==3){
           ans+= n-right;
           char lch = s.charAt(left);
           map.put(lch, map.get(lch) - 1);
             if(map.get(lch) == 0){
            map.remove(lch);
        }

        left++;
       }
       
        }
    return ans;
    }
}