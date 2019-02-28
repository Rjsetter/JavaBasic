package CollectionLearn;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * This program demonstrates operations on linked lists.
 * @version 1.11 2012-01-26
 * @author Cay Horstmann
 */
public class LinkedListTest_1
{
    public static void main(String[] args)
    {
        List<String> a = new LinkedList<>();
        a.add("1");
        a.add("2");
        a.add("3");

        List<String> b = new LinkedList<>();
        b.add("4");
        b.add("5");
        b.add("6");
        b.add("7");
        b.add("8");
        b.add("9");
        b.add("10");

        // 合并两个列表
        //ListIterator有add方法，Iterator没有
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext())
        {
            if(aIter.hasNext())
                aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);

        // remove every second word from b

        bIter = b.iterator();
        while (bIter.hasNext())
        {
            bIter.next(); // skip one element
            if (bIter.hasNext())
            {
                bIter.next(); // skip next element
                bIter.remove(); // remove that element
            }
        }

        System.out.println(b);

        // bulk operation: remove all words in b from a

        a.removeAll(b);

        System.out.println(a);
    }
}
