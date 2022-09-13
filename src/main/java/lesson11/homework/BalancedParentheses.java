package lesson11.homework;

// ****** Написать функцию, которая проверяет сбалансированность скобок трех видов.
// Пример "{}()" -> true, "{()[]}" -> true, "[}" -> false, "{{{])" -> false
// Подумайте, какие из пройденных контейнеров можно использовать - Stack, Queue, Deque.

import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        System.out.println(checkParentheses("{}()"));           // -> true
        System.out.println(checkParentheses("{()[]}"));         // -> true
        System.out.println(checkParentheses("[}"));             // -> false
        System.out.println(checkParentheses("{{{])"));          // -> false
        System.out.println(checkParentheses("{()()[[()]()]}")); // -> true
    }

    public static boolean checkParentheses(String s) {
        Stack<Character> chars = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                chars.add(c);
            } else if (
                    c == ')' && chars.peek() == '(' ||
                            c == ']' && chars.peek() == '[' ||
                            c == '}' && chars.peek() == '{'
            ) {
                chars.pop();
            }
        }
        return chars.size() == 0;
    }
}
