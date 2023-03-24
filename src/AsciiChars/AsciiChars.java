package AsciiChars;
public class AsciiChars 
{
   //This function will print out valid numeric characters
  public static void printNumbers()
  {
    System.out.println("\nAll the valid numeric charaters are as following:");
    for(int i = 49; i <= 57; i++)  
    {  
        if(i != 57){
          System.out.print((char)i + ", ");
        }
        else
        {
          System.out.print((char)i + "\n\n");
        }          
    }  
  }

  //This function will print out all the lowercase alphabetic
  public static void printLowerCase()
  {
    System.out.println("\nAll the valid lowercase alphabetic are as following:");
    for(int i = 97; i <= 122; i++)  
    {  
        if(i != 122)
          System.out.print((char)i + ", ");
        else
          System.out.print((char)i + "\n\n");
          
    }  
  }

  //This function will print out all the uppercase alphabetic
  public static void printUpperCase()
  {
    System.out.println("\nAll the valid upperercase alphabetic are as following:");
    for(int i = 65; i <= 90; i++)  
    {   if(i != 90)
          System.out.print((char)i + ", ");  
        else
          System.out.print((char)i + "\n");
    }  
  }
}

