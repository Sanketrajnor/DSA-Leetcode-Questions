class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftParentheses = new Stack<>();
        Stack<Integer> stars = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                leftParentheses.push(i);
            } else if (ch == '*') {
                stars.push(i);
            } else {
                if (!leftParentheses.isEmpty()) {
                    leftParentheses.pop();
                } else if (!stars.isEmpty()) {
                    stars.pop();
                } else {
                    return false;
                }
            }
        }
        
        while (!leftParentheses.isEmpty() && !stars.isEmpty()) {
            if (leftParentheses.peek() < stars.peek()) {
                leftParentheses.pop();
                stars.pop();
            } else {
                break;
            }
        }
        
        return leftParentheses.isEmpty();
    }
}
