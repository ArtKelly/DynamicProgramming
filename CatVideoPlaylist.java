import java.util.ArrayList;

public class CatVideoPlaylist {

    public static boolean[][] longestPlaylist(int input[], int total) {

        boolean T[][] = new boolean[input.length + 1][total + 1];
        ArrayList<Integer> playlist = new ArrayList<Integer>();

        for (int i = 0; i <= input.length; i++) {
            T[i][0] = true;
        }
        
        int q = Integer.MIN_VALUE;

        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j - input[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
                } else {
                    T[i][j] = T[i-1][j];
                }
                if (T[i][j] == true) { q = Math.max(q,j); }
            }
        }
        int P = q;
        for (int i = input.length; i > 0; i--) {
            if (T[i][P] == true && T[i - 1][P] == false) {
                playlist.add(i-1);
                P -= input[i-1];
            }
        }
        System.out.println(q);
        System.out.println(playlist);
        return T;
    }

    public static void main(String args[]) {
        int target = 30;
        int arr[] = {12,3,25,17,15,13};

        boolean T[][] = longestPlaylist(arr, target);
            
        for (int i = 1; i <= T.length - 1; i++) {
            
            System.out.print(arr[i - 1] + " -> ");
            
            for (int j = 0; j <= target; j++) {
                System.out.print(T[i][j] + " ");
            }
            System.out.println();
        }
    }
}
