//import java.util.Scanner;

public class questionThirteenScouts {

  /*

  Instructions
  4 Gduds (rows)  x  6 teams each (columns)
  Find the highest value team in each gdud (could be more than one)
  From the highest value of the gduds, print the gdud with the smallest value (again, could be more than one)

  Output example for following matrix (from book)

      1  2  3  4  5  6

  1   09 15 23 18 15 20
  2   21 20 19 17 34 22
  3   30 28 25 19 20 19
  4   14 16 23 22 21 23

  (Output):
  Team 3 gdud 1 (Value = 23)
  Team 3 gdud 4 (Value = 23)
  Team 6 gdud 4 (Value = 23)

   */

  public static void main(String[] args) {

    //  Scanner input = new Scanner(System.in);  // Create a Scanner object, used if matrix is by input
      int[][] scouts = { //example of matrix from book
    // Column  1   2   3   4   5   6
              {9,  15, 23, 18, 15, 20}, //row 1
              {21, 20, 19, 17, 34, 22}, //row 2
              {30, 28, 25, 19, 20, 19}, //row 3
              {14, 16, 23, 22, 21, 23} //row 4
      };

      findH(scouts);


      // Matrix by input implementation:

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
      //First we initialize smallMax with the max of the first row
      int smallMax = -2; //can't be less kids (negative number)
      for(int col = 0; col < mat[0].length; col++) {
        if(mat[0][col]>smallMax){ //if col in row 0 is bigger than max...
            smallMax = mat[0][col];
        }
    }
    //before going into this loop, we have smallMax which has the highest value from row = 0
    for (int row = 1; row < mat.length; row++) { //start from row 1, because we already have been through row = 0
        int rowMax = -2;
      for(int col = 0; col < mat[row].length; col++) {
          if (mat[row][col]> rowMax){
              rowMax = mat[row][col];
          }
      }
      if (rowMax<smallMax){ //if the maximum of this row, is smaller than the max from other row/s -> switch values...
          smallMax = rowMax;
      }
    }
    // now - smallMax has the smallest maximum value from all rows, and we know to might appear more
    // than once
    // only show if it is max in said row and = smallest Max
    for (int row = 0; row < mat.length; row++) {
      int rowMax = -2;
      for (int col = 0; col < mat[row].length; col++) {
        if (mat[row][col] > rowMax) {
          rowMax = mat[row][col];
        }
      }
      if (rowMax == smallMax) { // if max in row is what we are looking for (=smallest max)
        for (int col = 0; col < mat[row].length; col++) { // go through row again and find all max instances
          if (mat[row][col] == smallMax) {
            System.out.println(
                "Team " + (col + 1) + " gdud " + (row + 1) + " (Value = " + smallMax + ")");
          }
        }
      }
      }
  }
  
  
}
