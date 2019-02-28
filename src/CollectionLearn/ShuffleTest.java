package CollectionLearn;

import java.util.*;

/**
 * This program demonstrates the random shuffle and sort algorithms.
 * @version 1.11 2012-01-26
 * @author Cay Horstmann
 */
public class ShuffleTest
{
   public static void main(String[] args)
   {
      List<Integer> numbers = new ArrayList<>();
      for (int i = 1; i <= 49; i++)
         numbers.add(i);
      Collections.shuffle(numbers);
      List<Integer> winningCombination = numbers.subList(0, 6);
      Collections.sort(winningCombination,Collections.reverseOrder());
      System.out.println(winningCombination);
      System.out.println(Collections.max(winningCombination));
      System.out.println(Collections.min(winningCombination));
      Collections.swap(winningCombination,2,4);
      System.out.println(winningCombination);
      winningCombination.removeIf(integer -> integer.equals(6));
      System.out.println("有6就删除"  +winningCombination);
      Collections.fill(winningCombination,8);
      System.out.println(winningCombination);
      System.out.println(Collections.frequency(winningCombination,7));

   }
}
