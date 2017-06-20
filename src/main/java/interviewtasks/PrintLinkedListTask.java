package interviewtasks;

public class PrintLinkedListTask {


    public static class Node {

        public Object value;
        public Node next;

        public Node() {
        }

        public Node( Object value, Node next) {
            this.next = next;
            this.value = value;
        }
    }

    public static String asString(Node head){
        if (head == null) return "";
        return head.value + " " + asString(head.next);
    }

    public static void main(String[] args) {
        Node root = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        System.out.println(asString(root));
    }

}
