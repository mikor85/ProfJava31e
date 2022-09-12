package lesson11.homework;

import java.util.Stack;

// ****** Написать функцию, которая проверяет сбалансированность скобок трех видов.
// Пример "{}()" -> true, "{()[]}" -> true, "[}" -> false, "{{{])" -> false
// Подумайте, какие из пройденных контейнеров можно использовать - Stack, Queue, Deque.

public class AreStringBracketsBalanced {
    public static void main(String[] args) {
        String stringOne = "{}()";
        System.out.println(isBalanced(stringOne));
        String stringTwo = "{()[]}";
        System.out.println(isBalanced(stringTwo));
        String stringThree = "[}";
        System.out.println(isBalanced(stringThree));
        String stringFour = "{{{])";
        System.out.println(isBalanced(stringFour));
    }

    private static boolean isBalanced(String string) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> brackets = new Stack<>();
        char c;
        for (int i = 0; i < string.length(); i++) {
            c = string.charAt(i);
            switch (c) {
                case '(' -> {
                    brackets.push(1);
                    stack.push(c);
                }
                case '[' -> {
                    brackets.push(2);
                    stack.push(c);
                }
                case '{' -> {
                    brackets.push(3);
                    stack.push(c);
                }
            }
            if (!stack.isEmpty() && !brackets.isEmpty()) {
                switch (c) {
                    case ')':
                        if (brackets.peek() == 1) {
                            stack.pop();
                            brackets.pop();
                            break;
                        }
                    case ']':
                        if (brackets.peek() == 2) {
                            stack.pop();
                            brackets.pop();
                            break;
                        }
                    case '}':
                        if (brackets.peek() == 3) {
                            stack.pop();
                            brackets.pop();
                            break;
                        }
                }
            }
        }
        return stack.isEmpty();
    }
}
