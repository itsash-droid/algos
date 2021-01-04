public class StackWithMax {

    Stack<Integer> stack;
    private Integer maxElem;

    public StackWithMax () {
        stack = new Stack<>();
        maxElem = Integer.MIN_VALUE;
    }

    public int max() {
        return maxElem;
    }

    public void push(Integer item) {
        if (maxElem <= item) {
            stack.push(maxElem);
            maxElem = item;
        }
        stack.push(item);
    }

    public Integer pop() {
        int elem = stack.pop();
        if (maxElem == elem) {
            maxElem = stack.pop();
        }

        return elem;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main (String args[]) {
        StackWithMax stMax = new StackWithMax();
        stMax.push(3);
        stMax.push(5);
        stMax.push(2);
        System.out.println(stMax.pop() + " " + stMax.max());
        stMax.push(7);
        stMax.push(1);
        System.out.println(stMax.pop() + " " + stMax.max());
        stMax.push(1);
        stMax.push(10);
        stMax.push(12);
        stMax.push(11);
        stMax.push(18);
        System.out.println(stMax.pop() + " " + stMax.max());
        System.out.println(stMax.pop() + " " + stMax.max());
        stMax.push(-1);
        System.out.println(stMax.pop() + " " + stMax.max());
        while(!stMax.isEmpty()) {
            System.out.println(stMax.pop() + " " + stMax.max());
        }
    }

}
