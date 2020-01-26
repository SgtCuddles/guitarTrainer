import java.util.Scanner;
import java.util.Random;

public class GuitarTrainer{

   public static void main(String[] args){
      char[] notes = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
      char noteLetter = 'x';
      String note = "";
      boolean hard = false;
      Scanner userInput = new Scanner(System.in);
      Random rand = new Random();
      
      int noteNum = Math.abs(rand.nextInt())%7;//picks note letter
      noteLetter = notes[noteNum];//sets note letter
      noteNum = Math.abs(rand.nextInt(4))+2;//picks note number
      note = "" + noteLetter + noteNum;//combines note for final value
      
      for(int j = 2; j <=5; j++)
      {
         for(int i = 0; i <=6; i++)
         {
            String tmp = "" + notes[(i+4)%7]+""+j;
            System.out.println(getLimit(tmp) + " " + tmp);
         }
      }
      
      //drawStaff(note);
   }
   
   public String drawStaff(String note){
      int upperLimit = 5;
      int lowerLimit = 15;
      String[] staff = new String[] {
                        "E     _=_     ", " D     =      ",
                        "C     _=_     ", " B     =      ", 
                        "A     _=_     ", " G     =      ", 
                        "F |----_------", " E|    =      ",
                        "D |----_------", " C|    =      ",
                        "B |----_------", " A|    =      ",
                        "G |----_------", " F|    =      ",
                        "E |----_------", " D     =      ",
                        "C     _=_     ", " B     =      ",
                        "A     _=_     ", " G     =      ",
                        "F     _=_     ", " E     =      "};
      //sets viewing area
      int tmpLimit = getLimit(note);
      if(tmpLimit<5)
      {
         upperLimit = tmpLimit;
      }
      if(tmpLimit>15)
      {
         lowerLimit = tmpLimit;
      }
      return(note + " " + tmpLimit);
   }
   
   //if note doesn't fit on base staff, this extends the viewing area
   public static int getLimit(String note)
   {
      int limit = 5;
      if(Character.getNumericValue(note.charAt(1)) >= 4)
      {
         if(note.charAt(0) == 'a' || note.charAt(0) == 'b' )//a4 b4
         {
            limit = 3;
         }
         else if((note.charAt(0) == 'c' || note.charAt(0) == 'd') && Character.getNumericValue(note.charAt(1)) > 4)//c5 d5
         {
            limit = 1;
         }
         else if(note.charAt(0) == 'e' && Character.getNumericValue(note.charAt(1)) > 4)//e5
         {
            limit = 0;
         }
      }
      else if(Character.getNumericValue(note.charAt(1)) <= 3)
      {
         if(note.charAt(0) == 'c' || note.charAt(0) == 'b' && note.charAt(1) != '3' )//c3 b2
         {
            limit = 17;
         }
         else if((note.charAt(0) == 'a' || note.charAt(0) == 'g') && Character.getNumericValue(note.charAt(1)) < 3)//a2 g2
         {
            limit = 19;
         }
         else if((note.charAt(0) == 'f' || note.charAt(0) == 'e') && Character.getNumericValue(note.charAt(1)) < 3)//f2 e2
         {
            limit = 21;
         }
      }
      return limit;
   }
}