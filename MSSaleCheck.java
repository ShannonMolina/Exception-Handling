/****************************************************************************
*MSSaleCheck.java
*Molina
*
*This class implements try/catch for exceptions, a print numeric method,
*a print alphabetic method, and a get error method.
****************************************************************************/

import java.text.DecimalFormat;

public class MSSaleCheck {

    private String sale; //sale is a string
    private int dollars;
    private int cents;
    private String error = null;


    public MSSaleCheck(String sale)
    {
        try
        {
            if(sale.charAt(0)!='$') //if does not start with $ then error
            {
                error="Invalid sale format missing $ - " + sale + "\"";
            }
            else if(sale.indexOf(".") == -1) //if does not have . then error
            {
                 error = "Invalid sale format missing . - " + sale + "\"";
            }
            else
            {
                dollars = Integer.parseInt(sale.substring(1,sale.indexOf(".")));
            }
        }
        catch (Exception e)
        {
            error="Invalid dollar format - For input string: \""+sale.substring(1,sale.indexOf("."))+"\"";
        }
        if(sale.indexOf(".")!=-1)
        {
            try
            {
                 cents=Integer.parseInt(sale.substring(sale.indexOf(".")+1,sale.length()));
            }
            catch(Exception e)
            {
               if(error!=null)
               {
                 error+="\nInvalid cents format - For input string: \""+sale.substring(sale.indexOf(".")+1,sale.length())+"\"";
               }
               else
               {
                   error="Invalid cents format - For input string: \""+sale.substring(sale.indexOf(".")+1,sale.length())+"\"";
               }
        }
        }
    }

   public void printNumeric()
   {
       DecimalFormat df = new DecimalFormat("#.00");
       double total = dollars+cents/100.0;
       System.out.println("$"+df.format(total));
   }

   public void printAlphaetic()
   {
       System.out.println(dollars+" dollars and "+cents+" cents.");
   }

    public String getError() {
        return error;
    }


}
