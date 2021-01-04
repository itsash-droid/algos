
public class Stack<Item> implements iStack<Item>{

    private class Node {
        Item data;
        Node next;

        public Node(Item item) {
            data = item;
            next = null;
        }
    }

    private Node first = null;
    private int count = 0;

    Stack() {

    }

    @Override
    public void push(Item item) {        
        Node newNode =  new Node(item);
        newNode.next = first;
        first = newNode;
        ++this.count;
    }

    @Override
    public Item pop() {
        if(!isEmpty()) {
            Node old = first;
            first = first.next;
            --this.count;
            return old.data;
        }
        throw new StackOverflowError("No items to pop!");
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return count;
    }

    public static void main(String args[]) {
        Stack<Integer> st = new Stack<>();
        //System.out.println(st.pop());
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.pop());
        st.push(11);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        //System.out.println(st.pop());

        Stack<String> st2 = new Stack<>();
        st2.push("item1");
        st2.push("item2");
        st2.push("item3");
        System.out.println(st2.pop());
        System.out.println(st2.size());
    }

}
