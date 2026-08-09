import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int n = g.length;
        int m = s.length;
        int max = 0;

        while (i < n && j < m) {

            if (s[j] >= g[i]) {
                max++;
                i++;
            }

            j++;
        }

        return max;
    }
}