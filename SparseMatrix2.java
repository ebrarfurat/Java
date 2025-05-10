class Node {
    int colIndex;
    int value;
    Node next;

    Node(int colIndex, int value) {
        this.colIndex = colIndex;
        this.value = value;
        this.next = null;
    }
}

public class SparseMatrix2 {
    int numRows;
    Node[] rows;

    public SparseMatrix2(int numRows, int numCols) {
        this.numRows = numRows;
        rows = new Node[numRows];
    }

    public void set(int row, int col, int value) {
        Node newNode = new Node(col, value);

        if (rows[row] == null) {
            rows[row] = newNode;
        } else {
            Node current = rows[row];
            Node prev = null;

            while (current != null && current.colIndex < col) {
                prev = current;
                current = current.next;
            }

            if (current != null && current.colIndex == col) {
                current.value = value;
            } else {
                newNode.next = current;
                if (prev == null) {
                    rows[row] = newNode;
                } else {
                    prev.next = newNode;
                }
            }
        }
    }

    public int get(int row, int col) {
        Node current = rows[row];
        while (current != null && current.colIndex <= col) {
            if (current.colIndex == col) {
                return current.value;
            }
            current = current.next;
        }
        return 0;
    }

    public static void main(String[] args) {
        // DÜZELTME: SparseMatrix yerine SparseMatrix2 kullanılmalı
        SparseMatrix2 matrix = new SparseMatrix2(3, 3);
        
        matrix.set(0, 0, 1);
        matrix.set(0, 1, 0);
        matrix.set(0, 2, 0);
        matrix.set(1, 0, 0);
        matrix.set(1, 1, 2);
        matrix.set(1, 2, 0);
        matrix.set(2, 0, 0);
        matrix.set(2, 1, 0);
        matrix.set(2, 2, 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix.get(i, j) + " ");
            }
            System.out.println();
        }
    }
}
