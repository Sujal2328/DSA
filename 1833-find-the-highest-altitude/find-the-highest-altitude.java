class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int alti=0;
        int maxi =0;
        for(int i=0;i<n;i++){
            alti+=gain[i];
            maxi = Math.max(maxi,alti);
        }
        return maxi;
    }
}