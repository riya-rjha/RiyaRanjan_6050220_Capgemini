package Activity1;

import java.util.Stack;

class BalancedParentheses {

    public static boolean f(String expression) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {

        if (open == '(' && close == ')')
            return true;
        if (open == '{' && close == '}')
            return true;
        if (open == '[' && close == ']')
            return true;

        return false;
    }

    public static void main(String[] args) {

        String expression1 = "{[()]}";
        String expression2 = "{[(])}";
        String expression3 = "((()))";
        String expression4 = "([)]";

        System.out.println(expression1 + " -> " + f(expression1));
        System.out.println(expression2 + " -> " + f(expression2));
        System.out.println(expression3 + " -> " + f(expression3));
        System.out.println(expression4 + " -> " + f(expression4));
    }
}
