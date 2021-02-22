/*
ID: kevinst4
LANG: JAVA
TASK: preface
*/

import java.util.*;
import java.io.*;

public class preface {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("preface.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("preface.out"));

        int N = Integer.parseInt(br.readLine());
        track = new HashMap<>();
        for (String b : single) {
            track.put(b, 0);
        }
        for (String b : fives) {
            track.put(b, 0);
        }
        for (int i = 1; i <= N; i++) {
            convert(i);
        }
        // System.out.println(track);

        for (int i = 0; i < 3; i++) {
            if (track.get(single[i]) != 0) {
                System.out.println(single[i] + " " + track.get(single[i]));
                pw.println(single[i] + " " + track.get(single[i]));
            }
            if (track.get(fives[i]) != 0) {
                System.out.println(fives[i] + " " + track.get(fives[i]));
                pw.println(fives[i] + " " + track.get(fives[i]));
            }
        }
        if (track.get(single[3]) != 0) {
            System.out.println(single[3] + " " + track.get(single[3]));
            pw.println(single[3] + " " + track.get(single[3]));
        }
        pw.close();

    }

    static String[] single = { "I", "X", "C", "M" };
    static String[] fives = { "V", "L", "D" };

    static HashMap<String, Integer> track;

    static void convert(int N) {
        int digits = -1;
        if (N < 10000) {
            digits = 4;
        }
        if (N < 1000) {
            digits = 3;
        }
        if (N < 100) {
            digits = 2;
        }
        if (N < 10) {
            digits = 1;
        }
        String ret = "";
        int len = digits - 1;
        for (int i = digits - 1; i >= 0; i--) {
            int cur = N / ((int) Math.pow(10, len));
            // System.out.println(cur);
            // System.out.println((int) Math.pow(10, len));
            if (cur < 5) {
                if (cur == 4) {
                    // System.out.println(single[i] + " " + fives[i]);
                    ret += single[i] + fives[i];
                    track.put(single[i], track.get(single[i]) + 1);
                    track.put(fives[i], track.get(fives[i]) + 1);

                } else {
                    for (int j = 0; j < cur; j++) {
                        // System.out.println(single[i]);
                        ret += single[i];
                        track.put(single[i], track.get(single[i]) + 1);
                    }
                }
            } else if (cur == 5) {
                // System.out.println(fives[i]);
                ret += fives[i];
                track.put(fives[i], track.get(fives[i]) + 1);

            } else {
                if (cur == 9) {
                    ret += single[i] + single[i + 1];
                    track.put(single[i], track.get(single[i]) + 1);
                    track.put(single[i + 1], track.get(single[i + 1]) + 1);

                    // System.out.println(single[i] + " " + single[i + 1]);
                } else {
                    // System.out.println(fives[i]);
                    ret += fives[i];
                    track.put(fives[i], track.get(fives[i]) + 1);
                    for (int j = 0; j < cur - 5; j++) {
                        ret += single[i];
                        track.put(single[i], track.get(single[i]) + 1);
                        // System.out.println(single[i]);
                    }
                }
            }

            N %= (int) Math.pow(10, len);
            // System.out.println("N " + N);
            len--;
        }
        // System.out.println(ret);
    }
}
