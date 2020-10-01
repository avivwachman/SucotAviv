//import java.util.Scanner;

public class questionThirteenScouts {

  /*

  4 battalions (columns)
  6 teams each (rows)
  Find how highest value team in each battalion (could be more that one)
  From the highest value of the battalions, print the battalion with the smallest value

  Output example for following matrix

      1  2  3  4  5  6
  1
  2   09 15 23 18 15 20
  3   21 20 19 17 34 22
  4   30 28 25 19 20 19
  5   14 16 23 22 21 23

  (Output):
  Team 3 battalion 1 (Val = 23)
  Team 3 battalion 4 (Val = 23)
  Team 6 battalion 4 (Val = 23)

   */

  public static void main(String[] args) {
    //
    //  Scanner input = new Scanner(System.in);  // Create a Scanner object

      int[][] scouts = {
    // Column  1   2    3   4   5   6
              {9,  15,  23, 18, 15, 20}, //row 1
              {21, 20,  19, 17, 34, 22}, //row 2
              {30, 28,  25, 19, 20, 19}, //row 3
              {14, 16,  23, 22, 21, 23} //row 4
      };

      findH(scouts);
      /*
    int[][] matrix = new int[4][6];
    for (int row = 0; row < matrix.length; row++){
      for (int col = 0; col < matrix[row].length ; col++) {
            matrix[row][col] = input.nextInt();
      }
    }
    */
  }

  public static void findH(int[][] mat) {
    int[] maximum = new int[4];
    for (int i = 0; i < maximum.length; i++) {
      maximum[i] = mat[i][0];
    }

    for (int row = 0; row < mat.length; row++) {
      for(int col = 1; col < mat[row].length; col++) { //we already have col = 1 in maximum
          if (mat[row][col]> maximum[row]){
              maximum[row] = mat[row][col];
          }
      }
    }

    int min = maximum[0];
    for (int i = 1; i < maximum.length; i++) {
      if (maximum[i]<min){
          min = maximum[i];
      }
    }

      for (int row = 0; row < mat.length; row++) {
          for(int col = 0; col < mat[row].length; col++) { //we already have col = 1 in maximum
              if (mat[row][col] == min){
                System.out.println("Team " + (col+1) + " Battalion " + (row+1) + " (Val = " + min + ")" );
              }
          }
      }
  }
  
  
}