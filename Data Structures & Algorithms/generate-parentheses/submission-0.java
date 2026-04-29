class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        int open = 0;
        int close = 0;

        helper(open, close, new StringBuilder(), n);

        return ans;
    }

    private void helper(int open, int close, StringBuilder partial, int n) {
        if (partial.length() == 2*n) {
            ans.add(partial.toString());
            return;
        }

       // Add open
        if (open < n) {
            partial.append("(");
            helper(open+1, close, partial, n);
            partial.setLength(partial.length() - 1);
        }
        
        // Add close but conditional
        if (close < open) {
            partial.append(")");
            helper(open, close+1, partial, n);
            partial.setLength(partial.length() - 1);
        }
    }
}
