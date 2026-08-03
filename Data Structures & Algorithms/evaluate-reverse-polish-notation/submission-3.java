class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> process = new Stack<>();
        int i = 0;
        int result = 0;

        while (i < tokens.length) {
            String curr = tokens[i];
            if (!curr.equals("+") && !curr.equals("-") &&
                !curr.equals("*") && !curr.equals("/")) {
                process.add(Integer.parseInt(curr));
            } else {
                int n2 = process.pop();
                int n1 = process.pop();

                switch(curr) {
                    case "+":
                        result = n1 + n2;
                        break;
                    case "-":
                        result = n1 - n2;
                        break;
                    case "/":
                        result = n1 / n2;
                        break;
                    case "*":
                        result = n1 * n2;
                        break;
                }
                process.push(result);
            }
            i++;
        }

        return process.pop();

    }
}
