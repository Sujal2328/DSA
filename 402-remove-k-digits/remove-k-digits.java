class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> st = new ArrayDeque<>();

        for (char ch : num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peekLast() > ch) {
                st.removeLast();
                k--;
            }
            st.addLast(ch);
        }

        // Important for cases like "9", k=1 or "1234", k=2
        while (k > 0 && !st.isEmpty()) {
            st.removeLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;

        while (!st.isEmpty()) {
            char digit = st.removeFirst();

            if (leadingZero && digit == '0') {
                continue;
            }

            leadingZero = false;
            sb.append(digit);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}