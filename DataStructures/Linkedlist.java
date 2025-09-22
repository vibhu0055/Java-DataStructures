public class Linkedlist {
    public static void main(String[] args){
        Linkedlist ll = new Linkedlist();
        ll.insertF(2);
        ll.insertF(1);
        ll.insertL(3);
        ll.insertL(4);
        ll.insertAt(5,3);
        ll.insertL(6);
        ll.deleteAt(3);
        ll.display();
    }

    private Node head = null;
    private Node tail = null;
    private int size;

    //Constructors
    public Linkedlist(){
        this.size = 0;
    }
    private class Node {
        private int val;
        private Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
        public Node(int val){
            this.val = val;
        }
    }

    //Insertions into Linked list
    public void insertF (int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail == null) tail = node;
        size++;
    } 

    public void insertL (int val){
        Node node = new Node(val);
        if(tail == null){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            tail = node;
        }
        size++;   
    }

    public void insertAt (int val , int index){
        if(index == 0) {
            insertF(val);
            size++;
            return;
        }
        if(index == size) {
            insertL(val);
            size++;
            return;
        }

        Node temp = head;
        for(int i = 1; i< index ; i++ ){
            temp = temp.next;
        }
        Node node = new Node(val , temp.next);
        temp.next = node;
        size++;
    }

    //Deletions at different positions

    public void deleteF (){
        head = head.next;
        if(head == null){  // case: if there is only 1 element
            tail = null; 
        }
    }

    public void deleteL (){
        Node temp = head;
        for(int i = 1; i<size-1; i++){
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;
    }

    public void deleteAt(int index){
        if(index == 0) {
            deleteF();
            size--;
            return;
        }
        if(index == size) {
            deleteL();
            size--;
            return;
        }
        Node temp = head;
        for(int i = 1; i < index; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public void display(){
        Node temp = head; // Prevents from changing the structure of Linkedlist
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }
}
