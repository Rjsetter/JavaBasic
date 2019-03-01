package 数据结构.Link;

/**
 * 双向链表封装类
 */
public class DoublelyLinkList {
    private LinkNode first;//指向链表中的第一个链结点
    private LinkNode last;//指向链表中的最后一个的链结点
    //初始化双向链表
    public DoublelyLinkList(){
        first = null;
        last = null;
    }
    //插入到链表的前端
    public void insertFirst(LinkNode linkNode){
        if(isEmpty()){//如果为空链表，则插入的第一个链结点既是表头也是表尾
            last =linkNode;
        }else{//如果不是空链表，则将链表的first指针指向该链结点
            first.previous=linkNode;
        }
        linkNode.next = first;
        first = linkNode;
    }
    //插入到尾端
    public void insertLast(LinkNode linkNode){
        if(isEmpty()){ //如果为空链表，则插入的第一个链结点既是表头也是表尾
            first = linkNode;
        }else{
            last.next = linkNode;
            linkNode.previous = last;
        }
        last = linkNode;
    }
    //删除第一个链结点。返回删除节点的引用
    public LinkNode deleteFirst() throws Exception{
        if(isEmpty()){
            throw new Exception("链表为空！不能进行删除操作");
        }
        LinkNode temLinkNode = first;
        if(first.next == null){
            last = null;  //如果只有一个链结点，则删除后会影响到last指针
        }else{  //如果至少有两个链结点，则将第二个链结点的previous设为null
            first.next.previous = null;
        }
        first = first.next;
        return temLinkNode;
    }
    //删除最后一个链结点，返回删除的链结点引用
    public LinkNode deleteLast() throws Exception{
        if(isEmpty()){
            throw new Exception("链表为空！不能进行删除操作");
        }
        LinkNode temp = last;
        if(last.previous == null){
            first = null;  //如果只有一个链结点，则删除后会影响到first指针
        }else{  //如果至少有两个链结点，则将倒数第二个链结点的next设为null
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }
    //查找属性为指定值的链结点
    public LinkNode find(int key){
        LinkNode cur = first;
        while(cur != null &&cur.age != key ){
            if(cur.next == null){
                return null;  //当前链结点不是要找的目标且已到达表尾
            }
            cur = cur.next;
        }

        return cur;
    }

    //在指定链结点之后插入，操作成功返回true，操作失败返回false
    public boolean insertAfter(LinkNode link){
        LinkNode target = find(link.age);
        boolean flag = true;
        if(target == null){  //没找到插入的参照链结点
            flag = false;
        }else{  //找到了插入的参照链结点
            if(target.next == null){ //参照链结点为表尾
                insertLast(link);
            }else { //该链表至少有两个链结点
                target.next.previous= link;
                link.next =target.next;
                //必须执行完上面两步，才能执行下面这两步
                //上面两步处理了link和它下一个链结点的关系
                //下面两步处理了link和它上一个链结点的关系
                target.next = link;
                link.previous =target;
            }
        }

        return flag;
    }

    //打印出所有的链表元素
    public void displayList(){
        LinkNode cur = first;
        while(cur != null){  //循环打印每个链结点
            cur.displayLink();
            cur = cur.next;
        }
    }


    //判空
    public boolean isEmpty(){
        return (first==null);
    }

}
class LinkNode{
    public int age;
    public String name;
    public LinkNode next;//指向下一个链结点
    public LinkNode previous;//指向上一个链结点

    public LinkNode(int age, String name) {
        this.age = age;
        this.name = name;
    }

    //打印该链结点信息
    public void displayLink(){
       System.out.println("name:"+name+",age:"+age);
    }
}