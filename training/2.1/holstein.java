/*
ID: kevinst4
LANG: JAVA
TASK: holstein
*/

import java.util.*;
import java.io.*;

public class holstein {
    static boolean debug = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("holstein.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("holstein.out"));

        N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        require = new Integer[N];

        for (int i = 0; i < N; i++) {
            require[i] = Integer.parseInt(st.nextToken());
        }

        G = Integer.parseInt(br.readLine());
        feeds = new Integer[G][N];

        for (int i = 0; i < G; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < N; j++) {
                feeds[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<State> q = new LinkedList<>();
        HashSet<Integer[]> visited = new HashSet<>();
        visited.add(require);
        q.add(new State(require, -1, 0, new Stack<>()));

        while (!q.isEmpty()) {

            State u = q.remove();

            if (check(u.vitamins)) {
                pw.print(u.cnt);
                int len = u.path.size();
                List<Integer> ret = new ArrayList<>();
                for (int i = 0; i < len; i++) {
                    ret.add(u.path.pop());
                }
                for (int i = len - 1; i >= 0; i--) {
                    pw.print(" " + (ret.get(i) + 1));
                }
                pw.println();
                pw.close();
                break;
            }

            for (int g = u.i + 1; g < G; g++) {
                Integer[] cur = subtract(u.vitamins, feeds[g]);

                if (!visited.contains(cur)) {
                    Stack<Integer> curPath = (Stack<Integer>) u.path.clone();
                    curPath.push(g);
                    q.add(new State(cur, g, u.cnt + 1, curPath));
                }
            }
        }
    }

    static boolean check(Integer[] a) {
        for (Integer b : a) {
            if (b != 0) {
                return false;
            }
        }
        return true;
    }

    static Integer[] subtract(Integer[] a, Integer[] b) {
        Integer[] ret = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            ret[i] = Math.max(a[i] - b[i], 0);
        }
        return ret;
    }

    static int N, G;
    static Integer[][] feeds;
    static Integer[] require;
}

class State {
    Integer[] vitamins;
    int i;
    int cnt;
    Stack<Integer> path;

    public State(Integer[] vitamins, int i, int cnt, Stack<Integer> path) {
        this.i = i;
        this.path = path;
        this.vitamins = vitamins;
        this.cnt = cnt;
    }
}
