package lesson28.genericPractice.genericBinaryTree;

public class BinaryTree {

    private Vortex root;

    public BinaryTree() {
    }

    public BinaryTree(Vortex root) {
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
            return 1 + Math.max(
                    right == null ? 0 : right.depth(),
                    left == null ? 0 : left.depth()
            );
        }

        @Override
        public String toString() {
            StringBuilder b = new StringBuilder("{");
            b.append("\"left\":");
            b.append(left == null ? "{}" : left.toString());
            b.append(", \"value\":");
            b.append(value);
            b.append(",");
            b.append("\"right\":");
            b.append(right == null ? "{}" : right.toString());
            b.append("}");
            return b.toString();
        }


    }  // end of class Vortex

    private Vortex addRecursive(Vortex current, int value) {
        if (current == null) {
            return new Vortex(value);
        }

        // value == current.value - возвращаем current вершину
        // value < current.value - добавляем вершину куда-то слева
        // value > current.value - добавляем вершину куда-то справа
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }
        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
