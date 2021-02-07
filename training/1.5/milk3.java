/*
ID: kevinst4
LANG: JAVA
TASK: milk3
*/

import java.util.*;

import javax.lang.model.util.ElementScanner6;

import java.io.*;

public class milk3 {
    static int A, B, C;
    static int[] maxBuckets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("milk3.out"));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int[] buckets = new int[3];
        buckets[0] = 0;
        buckets[1] = 0;
        buckets[2] = C;

        maxBuckets = new int[3];
        maxBuckets[0] = A;
        maxBuckets[1] = B;
        maxBuckets[2] = C;

        visited = new boolean[A + 1][B + 1][C + 1];

        ret = new ArrayList();
        temp = new HashSet<>();
        temp.add(C);

        dfs(buckets);

        for (int b : temp) {
            ret.add(b);
        }

        Collections.sort(ret);
        for (int i = 0; i < ret.size() - 1; i++) {
            pw.print(ret.get(i) + " ");
        }
        pw.print(ret.get(ret.size() - 1));
        pw.println();
        pw.close();
        br.close();
    }

    static List<Integer> ret;
    static Set<Integer> temp;
    static boolean[][][] visited;

    static void dfs(int[] buckets) {
        System.out.println("take " + Arrays.toString(buckets));
        if (buckets[0] == 0) {
            temp.add(buckets[2]);
            System.out.println(buckets[2]);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    int[] temp = Arrays.copyOf(buckets, 3);
                    pour(i, j, buckets);
                    System.out.println(Arrays.toString(buckets));
                    if (!visited[buckets[0]][buckets[1]][buckets[2]]) {
                        visited[buckets[0]][buckets[1]][buckets[2]] = true;
                        dfs(buckets);
                    }
                    buckets = Arrays.copyOf(temp, 3);
                    System.out.println("reset " + Arrays.toString(buckets));
                }
            }
        }
    }

    static void pour(int i, int j, int[] buckets) {
        if (buckets[i] == 0) {
            return;
        }
        System.out.println("pouring " + i + " into " + j);
        int amtFilled = maxBuckets[j] - buckets[j];
        if (buckets[i] > amtFilled) {
            buckets[j] = maxBuckets[j];
            buckets[i] -= amtFilled;
        } else if (buckets[i] < amtFilled) {
            buckets[j] += buckets[i];
            buckets[i] = 0;
        } else {
            buckets[j] = maxBuckets[j];
            buckets[i] = 0;
        }
    }
}
