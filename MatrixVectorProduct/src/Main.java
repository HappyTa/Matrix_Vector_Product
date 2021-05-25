import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * This method take user input and create a matrix
     * @return an x by y matrix with values given by the user
     */
    protected static int[][] matrixMaker(){
        Scanner in = new Scanner(System.in);

        // Grab the number of rows and columns
        System.out.print("Enter the number of rows: ");
        int row = in.nextInt();
        System.out.print("Enter the number of columns: ");
        int col = in.nextInt();
        int[][] result = new int[row][col];

        for(int r = 0; r < row; r++)
            for(int c = 0; c< col; c++){
                System.out.printf("Enter value for cell[%d][%d]: ",r,c);
                result[r][c] = in.nextInt();
            }
        
        // Debug
/*         for(int r = 0; r < row; r++)
            for(int c = 0; c< col; c++){
                
                System.out.printf("%d ",result[r][c]);
                if(c == col - 1)
                    System.out.println();
            } */

        return result;
    }

    protected static int[] vectorMaker(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of elements for this vector: ");
        int numOfElements = in.nextInt();

        int[] result = new int[numOfElements];

        for(int i = 0; i < numOfElements; i++) {
            System.out.printf("Enter value for element #[%d]: ",i);
            result[i] = in.nextInt();
        }
        // Debug
        /*         for(int c = 0; c< numOfElements; c++){
            
            System.out.printf("%d ",result[c]);
            if(c == numOfElements - 1)
            System.out.println();
        }  */
        in.close();
        return result;

    }
    
    protected static int[] product(int[][] matrix, int[] vector){
        int[] result = new int[matrix.length];
        Arrays.fill(result, 0);

        for(int row = 0; row < matrix.length; row++)
            for(int col = 0; col < matrix[0].length; col++){
                result[row] += matrix[row][col]*vector[col];
            }

        return result;
    }

    public static void main(String[] args) throws Exception {
        int[][] matrix = matrixMaker();
        int[] vector = vectorMaker();

        if(matrix[0].length != vector.length)
            System.out.println("The number of column in the matrix is not equal to the elements in the vector");
        else{
            // do the dot product
            int[] result = product(matrix, vector);
            System.out.print("Result: ");
            for(int i = 0; i < result.length; i++)
                System.out.printf("        |%d|\n",result[i]);
        }
        

    }
}
