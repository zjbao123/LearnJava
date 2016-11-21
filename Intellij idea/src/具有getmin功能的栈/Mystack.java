package 具有getmin功能的栈;

import java.util.Stack;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class Mystack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Mystack() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty!");

        }
        if (this.getmin() == this.stackData.peek()) {
            this.stackMin.pop();
        }
        return this.stackData.pop();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);

        } else if (this.getmin() >= newNum) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int getmin() {
        if(this.stackMin.isEmpty()){
            throw  new RuntimeException("Your stack is empty!");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        Mystack mystack =new Mystack();
        mystack.push(3);
        mystack.push(1);
        mystack.pop();
        mystack.push(8);
        mystack.push(5);
        System.out.println(mystack.getmin());


    }

}
