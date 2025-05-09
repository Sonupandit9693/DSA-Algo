class MinStack {
    class Node{
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(head == null){
            // have not any value in stack
            head = new Node(val, val, null);
        }else{
            head = new Node(val, Math.min(val, head.min), head);
        }
    }
    
    public void pop() {
        if(head != null){
            head = head.next;
        }
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */