import java.util.Stack;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class TwoStackQueue {
    public Stack<Integer> stackpop;
    public Stack<Integer> stackpush;

    public TwoStackQueue(){
        this.stackpop = new Stack<Integer>();
        this.stackpush = new Stack<Integer>();

    }
    public void add(int pushInt){
        this.stackpush.push(pushInt);
    }
    public int poll(){
        if(stackpop.empty()&&stackpush.empty())
            throw new RuntimeException("your queue is empty!");
        if(stackpop.empty()){
            while (!stackpush.empty()){
                stackpop.push(stackpush.pop());
            }
        }
        return stackpop.pop();
    }
    public int peek(){
        if(stackpop.empty()&&stackpush.empty())
            throw new RuntimeException("your queue is empty!");
        if(stackpop.empty()){
            while (!stackpush.empty()){
                stackpop.push(stackpush.pop());
            }
        }
        return stackpop.peek();
    }
}
