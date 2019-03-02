package 数据结构.Tree;

import Pojo.Person;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void insert() {
        Person person_1 = new Person(12,"hello");
        Person person_2 = new Person(14,"hello");
        Person person_3 = new Person(15,"hello");
        Person person_4 = new Person(16,"hello");
        Node node_1 = new Node(person_2);
        Node node_2 = new Node(person_1);
        Node node_3 = new Node(person_3);
        Node node_4 = new Node(person_4);
        BinaryTree tree = new BinaryTree();
        tree.insert(node_1);
        tree.insert(node_2);
        tree.insert(node_4);
        tree.insert(node_3);
        tree.traverse(2);
        tree.displayTree();
    }

    @Test
    public void inorder() {
    }
}