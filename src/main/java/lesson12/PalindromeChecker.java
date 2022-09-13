package lesson12;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeChecker {
    public static void main(String[] args) {
        System.out.println(checkPalindrome("алла"));
        System.out.println(checkPalindrome("ал"));
        System.out.println(checkPalindrome("ароза упала на лапу азора"));
    }

    public static boolean checkPalindrome(String p) {
        Deque<Character> chars = new ArrayDeque<>();
        //p = p.replaceAll(" ", "");

        for (int i = 0; i < p.length(); i++) {
            if (!(p.charAt(i) == ' ')) {
                chars.addFirst(p.charAt(i));
            }
        }
        for (int i = 0; i < chars.size(); i++) {
            if (chars.removeFirst().equals(chars.removeLast())) {
                return true;
            }
        }

//        for (Character c : p.toCharArray()) {
//            chars.add(c);
//        }
//
//        while (chars.size() > 1) {
//            if (!chars.removeFirst().equals(chars.removeLast())) {
//                return false;
//            }
//        }

        //return true;
        return false;
    }
}
