class MinStack {
    List<Integer> stack = new ArrayList<>();
    List<Integer> prevMin = new ArrayList<>();
    int currentMin = Integer.MAX_VALUE;

    public MinStack() {
    }
    
    public void push(int val) {
        this.prevMin.add(this.currentMin);
        this.currentMin = Math.min(this.currentMin, val);
        this.stack.add(val);
    }
    
    public void pop() {
        this.currentMin = this.prevMin.get(this.prevMin.size() - 1);
        this.prevMin.remove(this.prevMin.size() - 1);
        this.stack.remove(this.stack.size() - 1);
    }
    
    public int top() {
        return this.stack.get(this.stack.size() - 1);
    }
    
    public int getMin() {
        return this.currentMin;
    }
}
