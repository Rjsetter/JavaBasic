package 数据结构;

public class Stack {
    private int size;                   //栈的大小
    private int top;                    //栈顶下标
    private int [] stackArray;          //栈的容器

    //构造函数
    public Stack(int size){
        stackArray = new int[size];
        top = -1;   //初始化栈的时候，栈内无元素，栈顶下标设为-1
        this.size =size;
    }

    //入栈，同时，栈顶元素的下标加一
    public void push(int elem){
        if(isFull())
            System.out.println("栈已满！！");
        else {
            stackArray[++top] = elem; //插入栈顶
        }
    }

    //出栈，删除栈顶元素，同时栈顶元素下标减一
    public int pop(){
        if(isEmpty())
            return -1;
        return stackArray[top--];
    }
    //查看栈顶元素但是不删除
    public int peek(){
        if(isEmpty())
            return -1;
        return stackArray[top];
    }
    //判空
    public boolean isEmpty(){
        return (top == -1);
    }
    //判满
    public boolean isFull(){
        return (top == size-1);
    }

    public static void main(String []args){
        Stack stack = new Stack(5);
        stack.push(4);
        stack.push(8);
        stack.push(2);
        stack.push(1);
        stack.push(3);
        System.out.println("栈元素有："+stack.toString());
        System.out.println("取栈顶元素，不删除："+stack.peek());
        stack.push(7);
        System.out.println("取栈顶元素，并删除："+stack.pop());
        System.out.println("取删除后的栈顶元素："+stack.peek());
        stack.push(7);
        System.out.println("取删除后的栈元素："+stack.peek());
    }
}
