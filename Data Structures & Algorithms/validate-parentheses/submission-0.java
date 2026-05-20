class Solution {
    public boolean isValid(String s) {
        Stack<Character> validate = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                validate.push(')');
            } else if (c == '[') {
                validate.push(']');
            } else if (c == '{') {
                validate.push('}');
            } else {
                if (validate.isEmpty() || validate.pop() != c) {
                    return false;
                }
            }

        }

        return validate.isEmpty();
    }
}
