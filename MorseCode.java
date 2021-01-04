// written by kyra lee 2019
      
import java.util.*;
import java.io.*;

public class MorseCode
{
      //here are two arrays, one of English characters and one of their corresponding Morse Code equivalents.
      //english[i] is the English equivalent of code[i] for every index i in the arrays 
   public static final String [] english = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
                                   "Ä","Á","Å","Ch","É","Ñ","Ö","Ü",
            							  "0","1","2","3","4","5","6","7","8","9",
            							  ".",",",":","?","'","-","_","(",""+(char)(34),"@","="};	//char 34 is the quote character
   public static final String [] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..",
                                ".-.-",".--.-",".--.-","----","..-..","--.--","---.","..--",
            						  "-----",".----","..---","...--","....-",".....","-....","--...","---..","----.",
            						  ".-.-.-","--..--","---...","..--..",".----.","-....-","-..-.","-.--.-",".-..-.",".--.-.","-...-"};
   public String [] getEnglish()
   {
      return english;
   }
   public String [] getMorse()
   {
      return code;
   }	
   public boolean checkUpperCase(String word)
   {
      char[] check = word.toCharArray();
      for(int i = 0; i < check.length; i++)
      {
         if(!Character.isUpperCase(check[i])) // if lowercase
            return false;
      }
      return true;
   }
   public static Map flip(Map<String, String> m)
   {
      Map<String, String> ans = new HashMap();
      for(String key: m.keySet())
      {
         String value = m.get(key);
         if(!ans.containsKey(value))
            ans.put(value, key);   
      }
      return ans;
   }
   public static ArrayList<String[]> readEngFile(String name) throws IOException
   {
      Scanner in = new Scanner(new FileReader(name));
      ArrayList<String []> engChar = new ArrayList();
      while(in.hasNextLine())
      {
         String eng = in.nextLine();
         String[] engLet = eng.split(" ");
         engChar.add(engLet);
      }
      
      return engChar;
   }
   public static String[] readMorseFile(String name) throws IOException
   {
      Scanner in = new Scanner(new FileReader(name));
      String morse = in.nextLine();
      String[] morChar = morse.split("/");
      
      return morChar;
   }

   
}
      



