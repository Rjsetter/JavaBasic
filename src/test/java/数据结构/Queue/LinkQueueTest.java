package 数据结构.Queue;


import org.junit.Test;

public class LinkQueueTest {

    @Test
    public void fun(){
        LinkQueue<Integer> lq = new LinkQueue<Integer>();

        System.out.println("队列是否为空："+lq.isNull());

        //依次插入1、2、3、4
        lq.push(new QNode<Integer>(1));
        lq.push(new QNode<Integer>(2));
        lq.push(new QNode<Integer>(3));
        lq.push(new QNode<Integer>(4));

        //依次出队
        System.out.println("依次出队：");
        while(!lq.isNull()){
            System.out.println(lq.pop().getData());
        }

    }
}