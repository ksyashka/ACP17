package interviewtasks;
public class ReverseLinkedList {


    public static class Node {

        public Object value;
        public Node next;

        public Node() {
        }

        public Node( Object value, Node next) {
            this.next = next;
            this.value = value;
        }

        public static String asString(Node head){
            if (head == null) return "";
            return head.value + " " + asString(head.next);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        System.out.println(Node.asString(root));
        System.out.println(Node.asString(reversion(root)));
    }

    public static Node reversion(Node head) {
        Node iterator = head;
        Node next;
        Node previous = null;

        while (iterator != null){
            next = iterator.next;
            iterator.next = previous;
            previous = iterator;
            iterator = next;
        }
        head = previous;
        return head;
    }
}
