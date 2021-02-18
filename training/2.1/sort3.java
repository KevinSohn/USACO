
/*
ID: kevinst4
LANG: JAVA
TASK: sort3
*/

import java.util.*;
import java.io.*;

public class sort3 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("sort3.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("sort3.out"));

        int N = scan.nextInt();

        int[] ar = new int[N];
        int[] groupCnt = new int[3];

        for (int i = 0; i < N; i++) {
            ar[i] = scan.nextInt();
            groupCnt[ar[i] - 1]++;
        }

        int[] startIndex = { 0, groupCnt[0], groupCnt[0] + groupCnt[1] };

        // for (int i = 0; i < groupCnt[0]; i++) {
        // System.out.println(Arrays.toString(ar));
        // if (ar[i] != 1) {
        // // System.out.println(ar[i]);
        // int end;
        // if (ar[i] == 3) {
        // end = ar.length;
        // } else {
        // end = startIndex[ar[i]];
        // }
        // for (int j = startIndex[ar[i] - 1]; j < end; j++) {
        // if (ar[j] != ar[i]) {
        // int temp = ar[i];
        // ar[i] = ar[j];
        // ar[j] = temp;
        // break;
        // }
        // }
        // }
        // }

        int cur = 1;
        int swapCnt = 0;
        for (int i = 0; i < N; i++) {

            if (i == startIndex[1]) {
                cur = 2;
            }
            if (i == startIndex[2]) {
                cur = 3;
            }

            if (ar[i] != cur) {
                int end;
                if (ar[i] == 3) {
                    end = ar.length;
                } else {
                    end = startIndex[ar[i]];
                }

                boolean flag = true;
                for (int j = startIndex[ar[i] - 1]; j < end; j++) {
                    if (ar[j] == cur) {
                        swapCnt++;
                        int temp = ar[i];
                        ar[i] = ar[j];
                        ar[j] = temp;
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = startIndex[ar[i] - 1]; j < end; j++) {
                        if (ar[j] != ar[i]) {
                            swapCnt++;
                            int temp = ar[i];
                            ar[i] = ar[j];
                            ar[j] = temp;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(ar));
        System.out.println(swapCnt);
        pw.println(swapCnt);
        pw.close();
    }
}
