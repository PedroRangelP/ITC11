import java.util.*;

public class SF {
    private static TShirt[] swap(TShirt[] tShirts, int index1, int index2) {
        TShirt temp1 = tShirts[index1];
        TShirt temp2 = tShirts[index2];
        tShirts[index1] = temp2;
        tShirts[index2] = temp1;

        return tShirts;
    }

    private static TShirt[] swapByTeam(TShirt[] tShirts, int index1, int index2) {
        TShirt temp1 = tShirts[index1];
        TShirt temp2 = tShirts[index2];

        if (temp1.team.compareTo(temp1.team)<0)
            return tShirts;
        if (temp1.team.compareTo(temp2.team)>0)
            tShirts = swap(tShirts, index1, index2);

        return tShirts;
    }

    public static TShirt[] QuickSort(TShirt[] tShirts, int left, int right) {
        int pivotIndex = (left+right)/2;
        TShirt pivot = tShirts[pivotIndex];
        int i = left;
        int j = right;

        while (i<=j) {    
            if (tShirts[j].nationality.compareTo(pivot.nationality)==0)
                tShirts = swapByTeam(tShirts, j, pivotIndex);                
            if (tShirts[i].nationality.compareTo(pivot.nationality)<0)
                i++;
            if (tShirts[j].nationality.compareTo(pivot.nationality)>0)
                j--;

            if (i<=j) {
                if (i!=j)
                    tShirts = swap(tShirts, i, j);
                i++;
                j--;
            }
        }
        if (left<j)
            tShirts = QuickSort(tShirts, left, j);
        if (i<right)
            tShirts = QuickSort(tShirts, i, right);

        return tShirts;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TShirt[] tShirts = new TShirt[n];
        sc.nextLine();
        
        for (int i=0; i<n; i++) {
            String team = sc.nextLine();
            String nationality = sc.nextLine();
            tShirts[i] = new TShirt(team, nationality);
        }
        sc.close();

        TShirt[] sorted = QuickSort(tShirts, 0, n-1);

        for (int i=0; i<n; i++) {
            System.out.println(sorted[i].team);
        }
    }
    
}

class TShirt {
    String team;
    String nationality;

    public TShirt(String team, String nationality) {
        this.team = team;
        this.nationality = nationality;
    }

}