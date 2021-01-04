// written by kyra lee 2019

import java.io.*;
import java.util.*;

public class MorseCodeDriver
{
   public static void main(String[]arg)throws IOException
   {
      Scanner in = new Scanner (System.in);
      Map<String, String> engKey = new HashMap();
      MorseCode x = new MorseCode();
      String [] eng = x.getEnglish();
      String [] morse = x.getMorse();
            
      for(int i = 0; i < eng.length; i++)
      {
         engKey.put(eng[i], morse[i]);
      }
      Map<String, String> morsKey = x.flip(engKey);
      
      System.out.println("Would you like to encode or decode?");
      String ans = in.nextLine();
      
      if(ans.equals("encode") || ans.equals("Encode"))
      {
         System.out.println("What is the English file name?");
         String fileName = in.nextLine();
         ArrayList<String[]> engChar = x.readEngFile(fileName);
         String inMorse = "";
         String withSpace = "";
      
         for(int al = 0; al < engChar.size(); al++) // go through ArrayList
         {
            String[] encode = engChar.get(al);
            for(int st = 0; st < encode.length; st++) // go through each String array
            {
               for(int sub = 0; sub < encode[st].length(); sub++) // go through each element in String array
               {
                  String let = encode[st].substring(sub, sub + 1);
                  if(!x.checkUpperCase(let))
                     let = let.toUpperCase();
                 
                  withSpace += " ";   
                  withSpace += engKey.get(let);
               }
               inMorse = withSpace + "/";
               withSpace = inMorse; 
            }
            System.out.println(inMorse);
            withSpace = "";
         }
      }
      if(ans.equals("decode") || ans.equals("Decode"))
      {
         System.out.println("What is the Morse file name?");
         String fileName = in.nextLine();
         String [] morChar = x.readMorseFile(fileName);
         String withSpace = "";
         String inEng = "";
      
         for(int mo = 0; mo < morChar.length; mo++)
         {
            String []eachChar = (morChar[mo].trim()).split(" "); // each morse character
            for(int cha = 0; cha < eachChar.length; cha++)
            {
               inEng += morsKey.get(eachChar[cha]);
            }
            withSpace = inEng + " ";
            inEng = withSpace;
         }
         System.out.println(withSpace);
         
      }
   }
}
      




      


