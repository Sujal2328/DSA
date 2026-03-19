import java.util.*;

class Solution {
    public long subArrayRanges(int[] nums) {
        long maxSum = sumOfSubarrayMaximums(nums);
        long minSum = sumOfSubarrayMinimums(nums);
        return maxSum - minSum;
    }

    private long sumOfSubarrayMinimums(int[] nums) {
        int n = nums.length;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            prevSmaller[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            nextSmaller[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long minSum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - prevSmaller[i];
            long right = nextSmaller[i] - i;
            minSum += (long) nums[i] * left * right;
        }

        return minSum;
    }

    private long sumOfSubarrayMaximums(int[] nums) {
        int n = nums.length;
        int[] prevGreater = new int[n];
        int[] nextGreater = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            prevGreater[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            nextGreater[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long maxSum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - prevGreater[i];
            long right = nextGreater[i] - i;
            maxSum += (long) nums[i] * left * right;
        }

        return maxSum;
    }
}