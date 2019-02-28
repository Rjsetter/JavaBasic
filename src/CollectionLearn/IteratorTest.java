package CollectionLearn;

import java.util.*;

public class IteratorTest {
    public static void main(String []args){
        List<String> stringList = new ArrayList<>();
        for(int i=1;i<=10;i++)
            stringList.add("ArrayList—-"+i);
        Set<String> stringSet = new HashSet<>();
        for(int i=1;i<=10;i++)
            stringSet.add("stringSet"+i);
        Iterator<String> iterator= stringList.iterator();
        Iterator<String> iteratorSet= stringSet.iterator();
        //对迭代器的每一个元素调用这个 lambda 表达式，直到再没有元素为止
//        iterator.forEachRemaining(element->System.out.println(element));
        iteratorSet.forEachRemaining(element->System.out.println(element));

        ListIterator<String> listIterator = stringList.listIterator();

        listIterator.add("0");
        listIterator.forEachRemaining(element->System.out.println(element));
        //        while (iteratorSet.hasNext()){
//            if("stringSet4".equals(iteratorSet.next()))
//                iteratorSet.remove();
//            else{
//                System.out.println(iteratorSet.next());}
//        }
    }
}
