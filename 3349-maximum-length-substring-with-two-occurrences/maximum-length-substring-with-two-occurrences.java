class Solution {
    public int maximumLengthSubstring(String s) {
        int maxlen =0;
        int left =0;

        HashMap<Character,Integer> map = new HashMap<>();
        for(int right =0;right<s.length();right++){
            char ch  = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
          int limit =2;
         while(map.get(s.charAt(right))>limit){
            char chl = s.charAt(left);
            map.put(chl,map.get(chl)-1);
            left++;
         }
         maxlen =Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}