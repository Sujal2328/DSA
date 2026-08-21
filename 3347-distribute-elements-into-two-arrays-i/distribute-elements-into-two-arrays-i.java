class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        a1.add(nums[0]);
        a2.add(nums[1]);
        for(int i=2;i<n;i++){
            if(a1.get(a1.size()-1)>a2.get(a2.size()-1)){
                a1.add(nums[i]);
            }
            else{
                a2.add(nums[i]);
            }
        }
        int[] ans = new int[a1.size() + a2.size()];

int index = 0;


for (int x : a1) {
    ans[index++] = x;
}


for (int x : a2) {
    ans[index++] = x;
}

return ans;
    }
}