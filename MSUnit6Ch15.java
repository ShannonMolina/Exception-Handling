/****************************************************************************
*MSUnit6Ch15.java
*Molina
*
*This is a program that validates a sale in dollars and cents with a
* $ and a .(period).
****************************************************************************/

import java.util.Scanner;


public class MSUnit6Ch15 {

    public static void main(String[] args) {

       Scanner scan =new Scanner(System.in);

       while(true)
       {
           System.out.print("\nPlease enter amount of sale in form $#.## <\"q\" to quit> : ");
           String sale = scan.nextLine();
           if(sale.equals("q"))
           {
               break;
           }
           else
           {
               MSSaleCheck saleCheck = new MSSaleCheck(sale);
               if(saleCheck.getError()==null)
               {
                   saleCheck.printNumeric();
                   saleCheck.printAlphaetic();
               }
               else
               {
                   System.out.println(saleCheck.getError());
               }
           }
       }
    }
}
