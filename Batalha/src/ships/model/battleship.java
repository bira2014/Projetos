package ships.model;
import java.util.*;
public class battleship {

    //Rudimentary 
    public static void main(String[] args) {
        System.out.println(" Hello and welcome to a basic version of Battleship.");
        System.out.println(" The objective of this game is to sink all five ships located on the grid listed below.");
        System.out.println(" Follow the prompt located underneath the grid ");
        final int ROWS = 10;
        final String [ ] COLS = new String [ ]{"A","B","C","D","E","F","G","H","I","J"};
        int sum = 0;
         int [ ][ ] area = { {1,2,3,4,5,6,7,8,9,10},
                  {11,12,13,14,15,16,17,18,19,20},
                  {21,22,23,24,25,26,27,28,29,30},
                  {31,32,33,34,35,36,37,38,39,40},
                  {41,42,43,44,45,46,47,48,49,50},
                  {51,52,53,54,55,56,57,58,59,60},
                  {61,62,63,64,65,66,67,68,69,70},
                  {71,72,73,74,75,76,77,78,79,80},
                  {81,82,83,84,85,86,87,88,89,90},
                  {91,92,93,94,95,96,97,98,99,100} };

        for(int i=0; i < area.length; i++) {
            for (int j=0; j < area[i].length; j++) {


              if(area[i][j] < 10) 
                System.out.print("   "+(area[i][j])+" ");  
              else if(area[i][j] < 100) 
                System.out.print("  "+(area[i][j])+" ");
              else 
                System.out.print(" "+(area[i][j])+" ");
            }
          System.out.println("");
        }

    Scanner input = new Scanner(System.in);{
    System.out.println("Enter attack integer:");
    int t;
    while(true){
    t = input.nextInt();

    if ((t == 41) || (t == 42) || (t == 43)){
    System.out.println("Hit - Destroyer");}

    if ((t == 80) || (t == 90) || (t == 100)){
        System.out.println("Hit - Submarine");}


    if((t == 52) || (t == 62) || (t== 72) || (t == 82) || (t == 92)){
        System.out.println ("Hit - Aircraft Carrier");}

    if((t == 15) || (t == 16) || (t == 17) || (t == 18)){
        System.out.println ("Hit - Battleship");}

    if((t == 1) || (t == 2)){
        System.out.println ("Hit - PT Boat");}
    else{
        System.out.println ("Miss");
    }
    System.out.println("You have fired at:" + t);
    int w = 0;
    for(int i=0; i < area.length; i++) {
        for (int j=0; j < area[i].length; j++) {

            if (area[i][j] == t)

          if(area[i][j] < 10) 
            System.out.print("   "+(area[i][j])+" ");  
          else if(area[i][j] < 100) 
            System.out.print("  "+(area[i][j])+" ");
          else 
            System.out.print(" "+(area[i][j])+" ");
        }
      System.out.println("");
    }

        }
        }
    }
}