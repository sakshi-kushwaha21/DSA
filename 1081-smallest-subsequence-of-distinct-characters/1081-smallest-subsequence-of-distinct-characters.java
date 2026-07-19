class Solution {
    public String smallestSubsequence(String s) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        boolean[] used = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            freq[ch - 'a']--;

            if (used[ch - 'a']) {
                continue;
            }

            while (!stack.isEmpty()
                    && stack.peek() > ch
                    && freq[stack.peek() - 'a'] > 0) {

                used[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            used[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        for (char c : stack) {
            ans.append(c);
        }

        return ans.toString();
    }
}