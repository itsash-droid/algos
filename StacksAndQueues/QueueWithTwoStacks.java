
public class QueueWithTwoStacks<Item> implements iQueue<Item> {

    private Stack<Item> stack1;
    private Stack<Item> stack2;

    public QueueWithTwoStacks(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    @Override
    public void enqueue(Item item) {
        stack1.push(item);
    }

    @Override
    public Item dequeue() {
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public int size() {
        return 0;
    }

    public static void main(String args[]) {
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
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