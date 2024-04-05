class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (st.size() == 0) {
                st.push(s.charAt(i));
                continue;
            }
            char currentChar = s.charAt(i);
            char stackTop = st.peek();

            if (Character.toLowerCase(currentChar) == Character.toLowerCase(stackTop) &&
                    ((Character.isLowerCase(currentChar) && Character.isUpperCase(stackTop)) ||
                            (Character.isUpperCase(currentChar) && Character.isLowerCase(stackTop)))) {
                st.pop();
            } else {
                st.push(currentChar);
            }

        }

        char[] arr = new char[st.size()];

        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = st.pop();
        }

        return String.valueOf(arr);

    }
}
