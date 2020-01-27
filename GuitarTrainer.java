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
      
      int check = -1;
      while(check == -1)
      {
         int noteNum = Math.abs(rand.nextInt())%7;//picks note letter
         noteLetter = notes[noteNum];//sets note letter
         noteNum = Math.abs(rand.nextInt(4))+2;//picks note number
         note = "" + noteLetter + noteNum;//combines note for final value
         
         check = getValue(note);
      }
      
      
      
      System.out.print(drawStaff(note));
   }
   
   public static String drawStaff(String note){
      int upperLimit = 5;
      int lowerLimit = 15;
      String[] staff = new String[] {
                        "E     -=-     ", " D     =      ",
                        "C     -=-     ", " B     =      ", 
                        "A     -=-     ", " G     =      ", 
                        "F |----=------", " E|    =      ",
                        "D |----=------", " C|    =      ",
                        "B |----=------", " A|    =      ",
                        "G |----=------", " F|    =      ",
                        "E |----=------", " D     =      ",
                        "C     -=-     ", " B     =      ",
                        "A     -=-     ", " G     =      ",
                        "F     -=-     ", " E     =      "};
      //sets viewing area
      int tmpLimit = getValue(note);
      if(tmpLimit<5)
      {
         upperLimit = tmpLimit;
      }
      if(tmpLimit>15)
      {
         lowerLimit = tmpLimit;
      }
      //sets up staff to print
      String printable = note + "\n";
      
      for(int i = upperLimit; i <= lowerLimit; i++)
      {
         String tmpLine = staff[i];
         if(getValue(note) == i)
         {
         tmpLine = tmpLine.replace('=', 'O');
         }
         else
         {
            if(i%2 == 0)
            {
               tmpLine = tmpLine.replace('=', '-');
            }
            else
            {
            tmpLine = tmpLine.replace('=', ' ');
            }
         }
         printable = printable + "\n" + tmpLine;
      }
      return printable;
   }
   
   //gives staff note value to determine where to draw
   //and how many staff lines are needed
   public static int getValue(String note)
   {
      int limit = 5;
      if(note.charAt(1) == '5')
      {
         if(note.charAt(0) == 'e')
         {
            limit = 0;
         }
         if(note.charAt(0) == 'd')
         {
            limit = 1;
         }
         if(note.charAt(0) == 'c')
         {
            limit = 2;
         }
         else
         {
            return -1;
         }
      }
      else if(note.charAt(1) == '4')
      {
         if(note.charAt(0) == 'b')
         {
            limit = 3;
         }
         if(note.charAt(0) == 'a')
         {
            limit = 4;
         }
         if(note.charAt(0) == 'g')
         {
            limit = 5;
         }
         if(note.charAt(0) == 'f')
         {
            limit = 6;
         }
         if(note.charAt(0) == 'e')
         {
            limit = 7;
         }
         if(note.charAt(0) == 'd')
         {
            limit = 8;
         }
         if(note.charAt(0) == 'c')
         {
            limit = 9;
         }
      }
      else if(note.charAt(1) == '3')
      {
         if(note.charAt(0) == 'b')
         {
            limit = 10;
         }
         if(note.charAt(0) == 'a')
         {
            limit = 11;
         }
         if(note.charAt(0) == 'g')
         {
            limit = 12;
         }
         if(note.charAt(0) == 'f')
         {
            limit = 13;
         }
         if(note.charAt(0) == 'e')
         {
            limit = 14;
         }
         if(note.charAt(0) == 'd')
         {
            limit = 15;
         }
         if(note.charAt(0) == 'c')
         {
            limit = 16;
         }
      }
      else if(note.charAt(1) == '2')
      {
         if(note.charAt(0) == 'b')
         {
            limit = 17;
         }
         if(note.charAt(0) == 'a')
         {
            limit = 18;
         }
         if(note.charAt(0) == 'g')
         {
            limit = 19;
         }
         if(note.charAt(0) == 'f')
         {
            limit = 20;
         }
         if(note.charAt(0) == 'e')
         {
            limit = 21;
         }
         else
         {
            return -1;
         }
      }
      return limit;
   }
   
   
}