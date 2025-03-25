package Stack;

import java.util.AbstractMap;
import java.util.Stack;

public class Min_stack { //leetcode no:155
//    Stack<AbstractMap.SimpleEntry<Integer, Integer>> stack;
//    public Min_stack() {
//        stack = new Stack<AbstractMap.SimpleEntry<Integer, Integer>>();
//    }
//
//    public void push(int val) {
//        if(stack.isEmpty()) stack.push(new AbstractMap.SimpleEntry<>(val, val));
//        else{
//            if(val < stack.peek().getValue()) {
//                stack.push(new AbstractMap.SimpleEntry<>(val, val));
//            }else{
//                stack.push(new AbstractMap.SimpleEntry<>(val,stack.peek().getValue()));
//            }
//        }
//    }
//
//    public void pop() {
//        if(!stack.isEmpty()){
//            stack.pop();
//        }
//    }
//
//    public int top() {
//        if(!stack.isEmpty()){
//            int top = stack.peek().getKey();
//            return top;
//        }
//        return 0;
//    }
//
//    public int getMin() {
//        if(!stack.isEmpty()){
//            int min = stack.peek().getValue();
//            return min;
//        }
//        return 0;
//    }
//
//    public void display(){
//        for (AbstractMap.SimpleEntry<Integer, Integer> s: stack) {
//            System.out.print(s.getKey() + ", ");
//        }
//    }

    //improvised
    Stack<Long> stack;
    long min;
    public Min_stack(){
        stack = new Stack<Long>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val){
        if(stack.isEmpty()){
            stack.push((long)val);
            min = val;
        }else if(val >= min){
            stack.push((long)val);
        }else{
            stack.push((long)2 * val - min); // Encoded value
            min = val;
        }
    }

    public long getMin(){
        return min;
    }

    public void pop(){
        if (stack.isEmpty()) return;

        if (stack.peek() < min) { // Encoded value detected
            min = 2 * min - stack.peek(); // Restore previous min
        }
        stack.pop();

        if (stack.isEmpty()) {
            min = Integer.MAX_VALUE; // Reset min if stack is empty
        }
    }

    public long top(){
        if(stack.isEmpty()) return 0;
        else if(stack.peek() > min){
            return stack.peek();
        }
        return min;
    }

    public void display(){
        for (long s : stack) {
            System.out.print(s + ", ");
        }
    }

    public static void main(String[] args) {
        Min_stack ms = new Min_stack();
        ms.push(2147483646);
        ms.push(2147483646);
        ms.push(2147483647);
        System.out.println("top " + ms.top());
        ms.pop();
        System.out.println("min " + ms.getMin());
        ms.pop();
        System.out.println("min " + ms.getMin());
        ms.pop();
        ms.push(2147483647);
        System.out.println("top " + ms.top());
        System.out.println("min " + ms.getMin());
        ms.push(-2147483648);
        System.out.println("top " + ms.top());
        System.out.println("min " + ms.getMin());
        ms.pop();
        System.out.println("min " + ms.getMin());
//        ms.display();
    }

}
