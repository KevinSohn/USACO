/*
ID: kevinst4
LANG: JAVA
TASK: hamming
*/

import java.util.*;
import java.io.*;

public class hamming {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("hamming.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("hamming.out"));

        N = scan.nextInt();
        B = scan.nextInt();
        D = scan.nextInt();

        List<String> ar = new ArrayList<>();

        String a = "";
        for (int i = 0; i < B; i++) {
            a += "1";
        }

        for (int i = 0; i <= Integer.parseInt(a, 2); i++) {
            ar.add(toBinaryString(i));
        }

        boolean[] skip = new boolean[ar.size()];

        int totalCnt = 0;
        int amtPerLine = 0;
        for (int i = 0; i < ar.size(); i++) {
            if (totalCnt >= N) {
                break;
            }
            if (skip[i]) {
                continue;
            }
            totalCnt++;
            amtPerLine++;
            if (amtPerLine == 1) {
                pw.print(i);
            } else if (amtPerLine == 10 && totalCnt < N) {
                pw.println(" " + i);
                amtPerLine = 0;
            } else {
                pw.print(" " + i);
            }
            System.out.println(i);
            for (int j = i + 1; j < ar.size(); j++) {
                if (skip[j]) {
                    continue;
                }
                int cnt = 0;
                for (int k = 0; k < B; k++) {
                    if (ar.get(i).charAt(k) != ar.get(j).charAt(k)) {
                        cnt++;
                    }
                }
                if (cnt < D) {
                    skip[j] = true;
                }
            }
        }
        pw.println();
        pw.close();
    }

    static int N, B, D;

    public static String toBinaryString(int n) {
        return String.format("%" + B + "s", Integer.toBinaryString(n)).replaceAll(" ", "0");
    }
}
