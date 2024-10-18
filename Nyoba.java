import java.util.ArrayList;
import java.util.*;

public class Nyoba {
   // Creatte calculator

   public static void main(String[] args) {
      System.out.println(Integer.parseInt("a"));
   }

   private int findPos(Object x)

   {

      int offset = 1;

      int currentPos = (x == null) ? 0 : Math.abs((x.element - 2) % array.length);

      while (array[currentPos] != null)

      {

         if (x == null)

         {

            if (array[currentPos].element == null)

               break;

         }

         else if (x.equals(array[currentPos].element))

            break;

         currentPos += offset;

         offset += 2;

         if (currentPos >= array.length)

            currentPos -= array.length;

      }

      return currentPos;

   }
}