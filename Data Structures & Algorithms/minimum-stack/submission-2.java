class MinStack {

    List<Integer> stack;
    List<Integer> minTrack;
    int size;
    int min;
    public MinStack() {
        stack = new ArrayList<>();
        minTrack = new ArrayList<>();
        size = 0;
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.add(size, val);

        if (val < min) {
            min = val;
        }
        minTrack.add(size, min);

        size++;
    }
    
    public void pop() {
        size--;
        stack.remove(size);
        minTrack.remove(size);

        // restore min
        if (size == 0) {
            min = Integer.MAX_VALUE;
        } else {
            min = minTrack.get(size - 1);
        }
    }
    
    public int top() {
        return stack.get(size - 1);
    }
    
    public int getMin() {
        return minTrack.get(size - 1);
    }
}
