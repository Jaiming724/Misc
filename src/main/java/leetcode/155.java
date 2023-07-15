#2 stack, at each level store the current min and the actual value
class MinStack {
    Stack<Integer> realStack = new Stack<>();  
    Stack<Integer> minStack = new Stack<>();  
    Integer minValue = null;
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(minValue==null){
            minValue = val;
        }else{
            if(minValue>val){
                minValue = val;
            }
        }
         realStack.push(val);
         minStack.push(minValue);
        
    }
    
    public void pop() {
 
         realStack.pop();
        int temp= minStack.pop();
        if(realStack.size()<=0){
            minValue = null;
        }else{
            minValue = minStack.peek();
        }

    }
    
    public int top() {
        return realStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}