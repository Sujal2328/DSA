class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxlen = 0;
        int left =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int right =0;right<nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.get(nums[right])>k){
                map.put(nums[left],map.getOrDefault(nums[left],0)-1);
                left++;
            }
            maxlen = Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}