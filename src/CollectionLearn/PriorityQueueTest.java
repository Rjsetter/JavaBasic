package CollectionLearn;

import java.util.*;
import java.time.*;

/**
 * This program demonstrates the use of a priority queue.
 * @version 1.02 2015-06-20
 * @author Cay Horstmann
 */
public class PriorityQueueTest
{
   public static void main(String[] args)
   {
      PriorityQueue<LocalDate> pq = new PriorityQueue<>();
      pq.add(LocalDate.of(1906, 12, 9)); // G. Hopper
      pq.add(LocalDate.of(1815, 12, 10)); // A. Lovelace
      pq.add(LocalDate.of(1903, 12, 3)); // J. von Neumann
      pq.add(LocalDate.of(1910, 6, 22)); // K. Zuse

      System.out.println("Iterating over elements...");
      for (LocalDate date : pq)
         System.out.println(date);
      System.out.println("Removing elements...");
      while (!pq.isEmpty())
         System.out.println(pq.remove());

      PriorityQueue<String> ps = new PriorityQueue<>();
      ps.add("sadzcx"); // G. Hopper
      ps.add("aaaaa"); // A. Lovelace
      ps.add("absds"); // J. von Neumann
      ps.add("sbsd"); // K. Zuse

      System.out.println("Iterating over elements...");
      for (String s : ps)
         System.out.println(s);
      System.out.println("Removing elements...");
      while (!ps.isEmpty())
         System.out.println(ps.remove());
   }
}
