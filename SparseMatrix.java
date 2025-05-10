class Node{
    int row;
    int col;
    int value;
    Node next;

    public Node(int row, int col, int value){
        this.row = row;
        this.col = col;
        this.value = value;
        this.next = null;
    }
}

public class SparseMatrix{
    private Node head;
    public SparseMatrix(){
        this.head = null;
    }

    public void insert(int row, int col, int value){
        Node newNode = new Node(row, col, value);
        if(head == null){
            head = newNode;
        }
        else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            current.next = newNode;
            }
        }
    }

    public void display(){
        Node current = head;

        while(current != null){
            System.out.println("Row: " + current.row + ", Column: " + current.col + ", Value: " + current.value);
            current = current.next;
        }
    }

    public static void main(String[] args){
        SparseMatrix matrix = new SparseMatrix();

        matrix.insert(0, 1, 2);
        matrix.insert(1, 0, 3);
        matrix.insert(1,2,4);

        System.out.println("Sparse Matrix");
        matrix.display();
    }
}
