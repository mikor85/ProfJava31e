package lesson16;

public class BinaryTreeTest {
    public static void main(String[] args) {
        /*
        MyBinaryTree.Vortex v5 = new MyBinaryTree.Vortex(5);
        MyBinaryTree.Vortex v4 = new MyBinaryTree.Vortex(4);
        MyBinaryTree.Vortex v3 = new MyBinaryTree.Vortex(3);
        MyBinaryTree.Vortex v2 = new MyBinaryTree.Vortex(2, null, v5);
        MyBinaryTree.Vortex v1 = new MyBinaryTree.Vortex(1, v3, v4);
        MyBinaryTree.Vortex v0 = new MyBinaryTree.Vortex(0, v1, v2);

        MyBinaryTree tree = new MyBinaryTree(v0);
        System.out.println(tree.countVertices());

        System.out.println(tree);
        System.out.println(tree.depth());
         */
        /*
            {
                "name": "Max Kotkov",
                "age": 34,
                "faculty": "physics",
                "friend": {
                    "lastname": "Smith"
                }
             }
         */

        // Binary Search Tree BST
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        myBinaryTree.add(6);
        myBinaryTree.add(3);
        myBinaryTree.add(10);
        myBinaryTree.add(1);
        System.out.println(myBinaryTree);  // {"left":{"left":{}, "value":3,"right":{}}, "value":6,"right":{"left":{}, "value":10,"right":{}}}


    } // end of main
}
