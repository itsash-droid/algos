
public class Queue<Item> implements iQueue<Item>{

    private class Node {
        Item data;
        Node next;

        public Node(Item item) {
            this.data = item;
            this.next = null;
        }
    }

    private Node first = null;
    private Node last = null;
    private int count = 0;

    @Override
    public void enqueue(Item item) {
        Node newNode = new Node(item);
        if (last != null) {
            last.next = newNode;
            last = last.next;
        } else {
            last = newNode;
            first = newNode;
        }
        ++this.count;
    }

    @Override
    public Item dequeue() {
        if (!isEmpty()) {
            Node node = first;
            if (first == last) {
                last = last.next;
            }
            first = first.next;
            --this.count;
            return node.data;
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        return first == null && last == null;
    }

    @Override
    public int size() {
        return this.count;
    }

    public static void main(String args[]) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.dequeue() + " " + queue.size());
        queue.enqueue(30);
        System.out.println(queue.dequeue() + " " + queue.size());
        System.out.println(queue.dequeue() + " " + queue.size());
        System.out.println(queue.dequeue() + " " + queue.size());
    }

}
