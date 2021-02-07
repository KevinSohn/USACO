import java.io.BufferedReader;
import java.io.IOException;
/*
ID: kevinst4
LANG: JAVA
TASK: numtri
*/
import java.util.*;
import java.io.*;

public class numtri {

    static List<List<Integer>> rows;
    static int R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("numtri.out"));

        R = Integer.parseInt(br.readLine());

        rows = new ArrayList<>();
        visited = new int[R][R];

        for (int i = 0; i < R; i++) {
            Arrays.fill(visited[i], -1);
        }

        for (int i = 1; i <= R; i++) {
            List<Integer> cur = new ArrayList<>();
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for (int j = 0; j < i; j++) {
                cur.add(Integer.parseInt(st.nextToken()));
            }
            rows.add(cur);
        }
        // System.out.println(rows);
        // max = 0;
        int cnt = dfs(0, 0);

        pw.println(cnt);
        pw.close();

        for (int[] b : visited) {
            System.out.println(Arrays.toString(b));
        }

    }

    static int max;
    static int[][] visited;

    static int dfs(int rowNum, int i) {

        if (i > rowNum) {
            return 0;
        }

        if (rowNum == R - 1) {
            visited[rowNum][i] = rows.get(rowNum).get(i);
            return visited[rowNum][i];
        }

        if (visited[rowNum][i] == -1) {
            visited[rowNum][i] = rows.get(rowNum).get(i) + Math.max(dfs(rowNum + 1, i), dfs(rowNum + 1, i + 1));
        }
        return visited[rowNum][i];
    }

    // Queue<State> q = new LinkedList<>();
    // q.add(new State(0, 0, rows.get(0).get(0)));

    // while (!q.isEmpty()) {

    // State u = q.remove();
    // if (visited[u.rowNum][u.i] > u.sum) {
    // continue;
    // }
    // visited[u.rowNum][u.i] = u.sum;

    // if (u.rowNum == R - 1) {
    // max = Math.max(u.sum, max);
    // continue;
    // }

    // List<Integer> next = rows.get(u.rowNum + 1);

    // if (u.i <= u.rowNum) {
    // if (u.sum + next.get(u.i) > visited[u.rowNum + 1][u.i]) {
    // q.add(new State(u.rowNum + 1, u.i, u.sum + next.get(u.i)));
    // }
    // if (u.sum + next.get(u.i + 1) > visited[u.rowNum + 1][u.i + 1]) {
    // q.add(new State(u.rowNum + 1, u.i + 1, u.sum + next.get(u.i + 1)));
    // }
    // }

    // }

}

class State {
    int rowNum;
    int i;
    int sum;

    public State(int rowNum, int i, int sum) {
        this.rowNum = rowNum;
        this.i = i;
        this.sum = sum;
    }
}
