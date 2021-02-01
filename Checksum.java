import java.io.FileNotFoundException;
import java.util.Scanner;


public class Checksum {
  public static Boolean inputValidation(int[] receive, int maxVal) {
    Boolean status = true;
    for(int y=0; y<receive.length; y++) {
      if(receive[y]<0 || receive[y] >maxVal) {
        status = false;
    }
  }
  return status;
}
  public static void programEnd() {
    System.err.println("Error, invalid input.");
  }
public static void arithmetic (int quotient, int remainder, int sum, int checksum, int complement) {
  quotient = sum/(int) Math.pow(2,8);
  remainder = sum%(int) Math.pow(2, 8);
  sum = quotient + remainder;
  complement = (int) (Math.pow(2, 8)-1) - sum;

  System.out.printf("Stored Checksum: %d, Computed Checksum: %d\n", checksum, complement);
if (checksum != complement ) {
  System.err.printf("Error Detected!\n");
  
}  
}
  public static void main(String args[]) throws FileNotFoundException {

   final int max_int = 255;  // The maximum size for the input
    int count = 10;           // The number of integers to read from stdin
    int sum = 0;              // Note that the "sum" might exceed max_int
    int checksum = 0;         // The value of the 6th input integer
    int quotient =0;             // The result of evaluating the assignment:  quotient   = sum / (max_int + 1);
    int remainder=0;            // The result of evaluating the assignment:  remainder  = sum % (max_int + 1 );
    int complement=0;           // The result of evaluationg the assignment: complement = max_int - sum;
    
    /* The following block of code reads the contenst of the file
    and puts them into an array where the 6th input integer (index 5) is
    set to 0 */
    int[] fileContents = new int[count];
    Scanner stdin = new Scanner(System.in); 
  
    for(int x = 0; x<count; x++) {
      if(x==5) {
          fileContents[x] = 0;
          checksum = Integer.parseInt(stdin.nextLine());
      } else {
          fileContents[x] = Integer.parseInt(stdin.nextLine());
          sum+= fileContents[x];
      }
    }
    stdin.close(); 
    
    /* This method call ensures that every value in the created
    array is within the range 0...2^8-1 and ends the program
    if a value is not within that range; otherwise, it calls
    the arithmetic method to calculate and display the stored 
    and calculated checksums and whether they match.*/
    if(inputValidation(fileContents, max_int)) {
      arithmetic(quotient, remainder, sum, checksum, complement);
    } else {
      System.err.println("Error, invalid input. Ensure that values are within range of 0..(2^8)-1");
    }
  }
}