class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> prevMin = new ArrayDeque<>();
    int currentMin = Integer.MAX_VALUE;

    public MinStack() {
    }
    
    public void push(int val) {
        this.prevMin.push(this.currentMin);
        this.currentMin = Math.min(this.currentMin, val);
        this.stack.push(val);
    }
    
    public void pop() {
        this.currentMin = this.prevMin.pop();
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.currentMin;
    }
}
