package lesson16;

public class MyBinaryTree {

    private Vortex root;

    public MyBinaryTree() {
    }

    public MyBinaryTree(Vortex root) {
        this.root = root;
    }

    public int countVertices() {
        return root.countVertices();
    }

    public int depth() {
        return root.depth();
    }

    static class Vortex {
        Vortex left;
        Vortex right;
        int value;

        public Vortex(int value) {
            this.value = value;
        }

        public Vortex(int value, Vortex left, Vortex right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public int countVertices() {
            return 1 +
                    (left == null ? 0 : left.countVertices()) +
                    (right == null ? 0 : right.countVertices());
        }

        public int depth() {
            // вернуть глубину
            return Math.max(
                    1 + (right == null ? 0 : right.depth()),
                    1 + (left == null ? 0 : left.depth())
            );
        }

        @Override
        public String toString() {
            StringBuilder b = new StringBuilder("{");
            b.append("'left':");
            b.append(left == null ? "{}" : left.toString());
            b.append(", 'value':");
            b.append(value);
            b.append(",");
            b.append("'right':");
            b.append(right == null ? "{}" : right.toString());
            b.append("}");
            return b.toString();
        }


    }  // end of class Vortex

    @Override
    public String toString() {
        return root.toString();
    }
}
