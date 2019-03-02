package 数据结构.Tree;

import Pojo.Person;

public class Node {
    Person person;
    Node leftChild;//左子节点的引用
    Node rightChild;//右子节点的引用

    public Node(Person person) {
        this.person = person;
    }
    //返回存储的信息
    public Person getPerson() {
        return person;
    }
}
