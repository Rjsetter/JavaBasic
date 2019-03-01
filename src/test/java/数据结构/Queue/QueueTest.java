package 数据结构.Queue;

import org.junit.Test;

public class QueueTest {
    @Test
    public void queueTest() {
        Queue<Character> queue = new Queue<Character>(4);
        //判断列空
        System.out.println("队列是否为空：" + queue.isNull());
        //入队A,B,C
        queue.push('A');
        queue.push('B');
        queue.push('C');
        System.out.println("队列是否为满：" + queue.isFull());
        System.out.println("队列满了，现在插入失败,返回false："+queue.push('D'));
        Character data = queue.pop();
        System.out.println("现在出队："+data);
        System.out.println("队列未满，现在插入成功,返回true："+queue.push('D'));
        System.out.println("现在出队："+queue.pop());
        System.out.println("现在出队："+queue.pop());
        System.out.println("现在出队："+queue.pop());
        System.out.println("队列为空，出队失败："+queue.pop());
    }
}
