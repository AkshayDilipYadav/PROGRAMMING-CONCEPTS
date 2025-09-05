package ShallowDeepCopyExercise;

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class Main {
    static void printList(Node head){
        Node t = head;
        while(t != null){
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.println("null");
    }

    // Shallow Copy
    static Node shallowCopy(Node head){
        return head;
    }

    //Deep Copy
    static Node deepCopy(Node head){
        if(head == null)return null;

        Node newHead = new Node(head.data);
        Node currentOld = head.next;
        Node currentNew = newHead;

        while(currentOld != null){
            currentNew.next = new Node(currentOld.data);
            currentNew = currentNew.next;
            currentOld = currentOld.next;
        }
        return newHead;

    }

    public static void main(String[] args){

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original List: ");
        printList(head);

        Node shallow = shallowCopy(head);
        System.out.println("\nShallow Copy List: ");
        printList(shallow);

        Node deep = deepCopy(head);
        System.out.println("\nDeep Copy list: ");
        printList(deep);

        // modify original list
        head.next.data = 99;

        System.out.println("\nAfter modifying original list: ");
        System.out.println("Original List:");
        printList(head);

        System.out.println("Shallow Copy list (affected)");
        printList(shallow);

        System.out.println("Deep Copy list (not affected): ");
        printList(deep);
    }
}
