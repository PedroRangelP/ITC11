public class Exercise2 {
    public static void fill(String[][] screen, int x, int y, String oldColor, String newColor) {
        if (y-1 >= 0) {
            if (screen[y-1][x].equals(oldColor)) {
                screen[y-1][x] = newColor;
                fill(screen, x, y-1, oldColor, newColor);
            }
        }

        if (y+1 < screen.length) {
            if (screen[y+1][x].equals(oldColor)) {
                screen[y+1][x] = newColor;
                fill(screen, x, y+1, oldColor, newColor);
            }
        }

        if (x-1 >= 0) {
            if (screen[y][x-1].equals(oldColor)) {
                screen[y][x-1] = newColor;
                fill(screen, x-1, y, oldColor, newColor);
            }
        }

        if (x+1 < screen[0].length) {
            if (screen[y][x+1].equals(oldColor)) {
                screen[y][x+1] = newColor;
                fill(screen, x+1, y, oldColor, newColor);
            }
        }

        screen[y][x] = newColor;
    }
     
    public static void main(String[] args) {
        String[][] screen = {{"w", "r", "w", "o", "o"}, {"r", "b", "w", "o", "o"}, {"w", "w", "w", "w", "w"}};
        String newColor = "N";
        int pointX = 4;
        int pointY = 1;

        System.out.println("-----OLD SCREEN-----");
        for (int y = 0; y < screen.length; y++) { 
            for (int x = 0; x < screen[0].length; x++) { 
                System.out.print(screen[y][x] + " "); 
            } 
  
            System.out.println(); 
        }

        System.out.println("-----NEW SCREEN-----");

        fill(screen, pointX, pointY, screen[pointY][pointX], newColor);

        for (int y = 0; y < screen.length; y++) { 
            for (int x = 0; x < screen[0].length; x++) { 
                System.out.print(screen[y][x] + " "); 
            } 
  
            System.out.println(); 
        }
    }
}