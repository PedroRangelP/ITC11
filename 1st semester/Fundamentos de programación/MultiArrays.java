public class MultiArrays{
    public static void main(String[] args) {
        int i, j, rows, cols;
        int[][] array;

        System.out.print("Rows: ");
        rows = Integer.parseInt(System.console().readLine());
        System.out.print("Columns: ");
        cols = Integer.parseInt(System.console().readLine());

        array =  new int[rows][cols];

        for (i=0; i<rows; i++){
            for (j=0; j<cols; j++){
                System.out.print("Value at "+i+", "+j+": ");
                array[i][j] = Integer.parseInt(System.console().readLine());
            }
        }

        for (i=0; i<rows; i++){
            for (j=0; j<cols; j++){
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
        
    }
}