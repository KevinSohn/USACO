/*
ID: kevinst4
LANG: JAVA
TASK: subset
*/

import java.util.*;
import java.io.*;

public class subset {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("subset.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("subset.out"));
        //attempt 1 at an algo
        /*
         * // for (int n = 1; n <= 9; n++) {
         * 
         * // N = n; // ar = new int[N]; // int sum = 0; // for (int i = 0; i < N; i++)
         * { // ar[i] = i + 1; // sum += i + 1; // } // System.out.println("s: " + sum);
         * 
         * // HashSet<Integer> path = new HashSet<>(); // HashSet<Integer> path2 = new
         * HashSet<>(); // visited = new HashSet<>(); // cnt = 0; // combi(0, 0, 0,
         * path, path2); // System.out.println(cnt); // }
         */

        //attempt 2 at an algo
        N = scan.nextInt();

        int[] ar = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            ar[i] = i + 1;
            sum += i + 1;
        }
        visited = new int[N][(sum / 2) + 1];

        System.out.println(sum);
        if (sum % 2 != 0) {
            pw.println(0);
            System.out.println(0);
            pw.close();
            return;
        }

        Stack<Integer> path = new Stack<>();
        int cnt = combi(0, sum / 2, path);
        System.out.println(cnt);
        pw.println(cnt);
        pw.close();
    }

    static int N;
    static int[][] visited;

    //attempt 2 at an algo
    static int combi(int k, int sum, Stack<Integer> path) {
        if (k == N) {
            return 0;
        }
        if (sum < 0) {
            return 0;
        }

        if (sum == 0) {
            // System.out.println(path);
            return 1;
        }

        if (visited[k][sum] != 0) {
            return visited[k][sum];
        }

        int total = 0;
        path.push(k + 1);
        total += combi(k + 1, sum - (k + 1), path);
        path.pop();
        total += combi(k + 1, sum, path);
        visited[k][sum] = total;
        return visited[k][sum];

    }
    //attempt 1 at an algo
    /*
     * // static HashSet<HashSet<Integer>> visited; // static int cnt; // static int
     * N; // static int[] ar;
     * 
     * // static void combi(int k, int leftSum, int rightSum, HashSet<Integer> path,
     * // HashSet<Integer> path2) {
     * 
     * // if (k == N) { // if (leftSum == rightSum) {
     * 
     * // if (!visited.contains((HashSet) path.clone()) &&
     * !visited.contains((HashSet) // path2.clone())) { // HashSet<Integer> temp =
     * (HashSet) path.clone(); // HashSet<Integer> temp2 = (HashSet) path2.clone();
     * // visited.add(temp); // visited.add(temp2); // // System.out.println(path +
     * " | " + path2); // cnt++; // } // } // return; // }
     * 
     * // path.add(k + 1); // combi(k + 1, leftSum + k + 1, rightSum, path, path2);
     * // path.remove(k + 1); // path2.add(k + 1); // combi(k + 1, leftSum, rightSum
     * + k + 1, path, path2); // path2.remove(k + 1); // }
     */
}
