
public interface iStack<Item> {
    
    void push(Item item);

    Item pop();

    boolean isEmpty();

    int size();
}
