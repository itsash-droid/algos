
public interface iQueue<Item> {

    void enqueue(Item item);

    Item dequeue();

    boolean isEmpty();

    int size();
}
