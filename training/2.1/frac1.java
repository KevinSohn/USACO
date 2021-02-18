
/*
ID: kevinst4
LANG: JAVA
TASK: frac1
*/

import java.util.*;
import java.io.*;

public class frac1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("frac1.out"));

        int N = Integer.parseInt(br.readLine());

        List<Node> frac = new ArrayList<>();
        HashSet<Double> valTrack = new HashSet<>();
        frac.add(new Node(0, 0, 1));
        frac.add(new Node(1, 1, 1));
        valTrack.add(0.0);
        valTrack.add(1.0);

        for (double i = 1; i <= N; i++) {
            for (double j = 1; j < i; j++) {
                if (!valTrack.contains(j / i)) {
                    valTrack.add(j / i);
                    frac.add(new Node(j / i, (int) j, (int) i));
                    // System.out.println((int) j + "/" + (int) i + " : " + (j / i));
                }
            }
        }
        Collections.sort(frac, (a, b) -> (int) ((a.val - b.val) * 100000));
        for (Node b : frac) {
            pw.println(b.numer + "/" + b.denom);
            System.out.println(b.numer + "/" + b.denom);
        }
        pw.close();
    }
}

class Node {
    double val;
    int numer;
    int denom;

    public Node(double val, int numer, int denom) {
        this.val = val;
        this.numer = numer;
        this.denom = denom;
    }
}
