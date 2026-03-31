class Solution {
    public boolean isPalindrome(String s) {
        for(char ch : s.toCharArray()) {
			if(!Character.isLetterOrDigit(ch)) {
				s = s.replace(ch, ' ');
			}
		}

		String str = s.replace(" ", "");
		str = str.toLowerCase();

		return str.equals(new StringBuilder(str).reverse().toString());
    }
}
