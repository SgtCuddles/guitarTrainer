import java.util.Scanner;
import java.util.Random;

public class GuitarTrainer{

   public static void main(String[] args){
      char note = 'x';
      boolean hard = false;
      Scanner userInput = new Scanner(System.in);
      Random rand = new Random();
      
      int noteNum = Math.abs(rand.nextInt())%7;
      
      System.out.print("Note :\t" + lineToNote(noteNum) + "\n" + drawStaff(hard, noteNum) + "\n");
   }
   
   //draws staff with note when given a note and difficulty boolean
   public static String drawStaff(boolean hard, int note){
      String[] staff = new String[] {
                        "       =      ", "F |----_------",
                        " E|    =      ", "D |----_------",
                        " C|    =      ", "B |----_------",
                        " A|    =      ", "G |----_------",
                        " F|    =      ", "E |----_------",
                        "       =      "};
      String printAble = "";
      for(int i = 0; i < staff.length; i++){
         String tmp = staff[i];
         if (i == note){
            if (i%2 == 1){
               tmp = tmp.replace('_','O');
            }
            else{
               tmp = tmp.replace('=','O');
            }
         }
         else{
            if (i%2 == 1){
               tmp = tmp.replace('_','-');
            }
            else{
               tmp = tmp.replace('=',' ');
            }
         
         if (hard){
            tmp = tmp.substring(2);
            }
         }
         
         printAble += tmp + "\n";
      }
      return printAble;
   }
   
   //converts line address to note
   public static char lineToNote(int note)
   {
      if(note%7==4){
         return 'C';
      }
      else if(note%7==3){
         return 'D';
      }
      else if(note%7==2){
         return 'E';
      }
      else if(note%7==1){
         return 'F';
      }
      else if(note%7==0){
         return 'G';
      }
      else if(note%7==6){
         return 'A';
      }
      else if(note%7==5){
         return 'B';
      }
      return 'x';
   }
   
   //converts note to staff array address
   public static int noteToLine(String note){
      if (note.equals("e1")){
         return 9;
      }
      else if (note.equals("f1")){
         return 8;
      }
      else if (note.equals("g1")){
         return 7;
      }
      else if (note.equals("a1")){
         return 6; 
      }
      else if (note.equals("b1")){
         return 5;
      }
      else if (note.equals("c1")){
         return 4;
      }
      else if (note.equals("d1")){
         return 3;
      }
      else if (note.equals("e2")){
         return 2;
      }
      else if (note.equals("f2")){
         return 1;
      }
   return -1;
   }
}