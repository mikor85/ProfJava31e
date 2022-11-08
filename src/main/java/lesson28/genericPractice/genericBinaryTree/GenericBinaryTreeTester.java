package lesson28.genericPractice.genericBinaryTree;

public class GenericBinaryTreeTester {
    public static void main(String[] args) {
        GenericBinaryTree<Integer> i = new GenericBinaryTree<>();
        i.add(6);
        i.add(2);
        i.add(12);
        System.out.println(i);
        System.out.println("----------");

        GenericBinaryTree<String> s = new GenericBinaryTree<>();
        s.add("Masha");
        s.add("Alex");
        s.add("Dina");
        System.out.println(s);
    }
}