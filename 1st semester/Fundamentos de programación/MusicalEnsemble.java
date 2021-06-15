public class MusicalEnsemble{
    public static void main(String[] args) {
        String[][] songs = new String[0][0];
        int numC=0, numS=0, i, j, k;
        int[] total; 

        
        numC = Integer.parseInt(System.console().readLine());

        System.out.print("How many songs will be performed? ");
        numS = Integer.parseInt(System.console().readLine());
        songs = new String[numS][2];

        for (i=0; i<numS; i++){
            for (j=0; j<2; j++){
                if (j == 0){
                    System.out.print("Song "+(i+1)+" : ");
                    songs[i][j] = System.console().readLine();
                }else{
                    System.out.print("Duration (in seconds): ");
                    songs[i][j] = System.console().readLine();
                }
            }
        }

        for (i=0; i<numC; i++){
            System.out.println("CONTRACT: "+i": ");
            for (j=1; j<numS; j++){
                System.out.print("Is song "+j" in contrac "+i+"? ");
                total = 

            }
        }




        for (j=0; j<numS; j++){
            for (k=0; k<2; k++){
                System.out.print(songs[j][k]+"\t");
            }
            System.out.println();
        }     
    }
}