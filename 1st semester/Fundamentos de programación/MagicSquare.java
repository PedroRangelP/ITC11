public class MagicSquare{
    public static void main(String[] args) {
        int x, y, rows, cols;
        int[][] array = {{0,0,0}, {0,0,0}, {0,0,0}};
        boolean isMagic = true;

        for (x=0; x<array.length; x++){
            for (y=0; y<array.length; y++){
                System.out.print("Value at "+(x+1)+", "+(y+1)+": ");
                array[x][y] = Integer.parseInt(System.console().readLine());
            }
        }

        for (x=0; x<array.length; x++){
            for (y=0; y<array.length; y++){
                System.out.print(array[x][y]+"\t");
            }
            System.out.println();
        }

        for (x=0; x<array.length; x++){
            rows = array[x][0]+array[x][1]+array[x][2];
            cols = array[0][x]+array[1][x]+array[2][x];
            
            if (rows != 15 | cols != 15);
                isMagic = false;
        }

        System.out.println((isMagic) ? "It´s magic square" : "It's not magic");

        
    }
}