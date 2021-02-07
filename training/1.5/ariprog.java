/*
ID: kevinst4
LANG: JAVA
TASK: ariprog
*/

import java.util.*;
import java.io.*;

class ariprog {

    static int N;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("ariprog.out"));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        max = (int) Math.pow(M, 2) * 2;

        bisquares = new ArrayList<>();
        setBi = new HashSet<>();
        for (int i = 0; i <= M; i++) {
            for (int j = i; j <= M; j++) {
                if (!setBi.contains((int) Math.pow(i, 2) + (int) Math.pow(j, 2))) {
                    setBi.add((int) Math.pow(i, 2) + (int) Math.pow(j, 2));
                    bisquares.add((int) Math.pow(i, 2) + (int) Math.pow(j, 2));
                }
            }
        }
        Collections.sort(bisquares);

        List<List<Integer>> ret = new ArrayList<>();

        if (N < 10) {
            for (int i = 0; i < bisquares.size(); i++) {
                for (int j = i + 1; j < bisquares.size(); j++) {
                    int dif = bisquares.get(j) - bisquares.get(i);
                    if (search(bisquares.get(i), dif)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(bisquares.get(i));
                        temp.add(dif);
                        ret.add(temp);
                        // System.out.println("take " + bisquares.get(i) + " " + dif);
                    }
                }
            }
        } else {
            int[] fourAr = new int[(max / 4) / (N - 1)];
            for (int i = 1; i <= fourAr.length; i++) {
                fourAr[i - 1] = i * 4;
            }
            // System.out.println(bisquares.size());
            // System.out.println(bisquares);
            for (int i = 0; i < bisquares.size(); i++) {

                for (int j = 0; j < fourAr.length; j++) {
                    if (search(bisquares.get(i), fourAr[j])) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(bisquares.get(i));
                        temp.add(fourAr[j]);
                        ret.add(temp);
                    }
                }
            }
        }

        Collections.sort(ret, (a, b) -> a.get(1) == b.get(1) ? a.get(0) - b.get(0) : a.get(1) - b.get(1));
        // System.out.println(ret);
        for (List<Integer> cur : ret) {
            pw.println(cur.get(0) + " " + cur.get(1));
        }
        if (ret.isEmpty()) {
            pw.println("NONE");
        }

        pw.close();
    }

    static List<Integer> bisquares;
    static Set<Integer> setBi;

    static boolean search(int start, int dif) {
        // System.out.println(start + "___________");
        for (int i = 1; i < N; i++) {
            if (start > max || !setBi.contains(start)) {
                return false;
            }
            start += dif;
            // System.out.println(start);
        }
        return start <= max && setBi.contains(start);
    }

}
