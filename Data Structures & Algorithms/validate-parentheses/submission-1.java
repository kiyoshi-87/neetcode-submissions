class Solution {
    public boolean isValid(String s) {
		if (s.length() == 1) {
			return false;
		}

		Set<Character> openingBrackets = Set.of('{', '[', '(');
		Set<Character> closingBrackets = Set.of('}', ']', ')');

		Stack<Character> st = new Stack<>();

		for (int i=0; i<s.length(); i++) {
			Character bracket = s.charAt(i);

			if (openingBrackets.contains(bracket)) {
				st.add(bracket);
			}

			else if (closingBrackets.contains(bracket) && !st.isEmpty()) {
				boolean check = checkForCorrectClosingBracketPair(bracket, st.peek());
				if (check) {
					st.pop();
				} else {
					return false;
				}
			}

            else if (closingBrackets.contains(bracket) && st.isEmpty()) {
				return false;
			}
		}

		return st.isEmpty();
	}

	public boolean checkForCorrectClosingBracketPair(Character closingBracket, Character openingBracket) {
		return (closingBracket == '}' && openingBracket == '{') || (closingBracket == ']'
			&& openingBracket == '[') || (closingBracket == ')' && openingBracket == '(');
	}
}
