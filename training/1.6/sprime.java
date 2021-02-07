
/*
ID: kevinst4
LANG: JAVA
TASK: sprime
*/
import java.util.*;
import java.io.*;

public class sprime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sprime.in"));
        pw = new PrintWriter(new FileWriter("sprime.out"));

        N = Integer.parseInt(br.readLine());

        combi("", 0);
        pw.close();
    }

    static int N;
    static boolean[] sieve;
    static PrintWriter pw;

    static void combi(String sum, int length) {
        if (length != 0) {
            int sumInt = Integer.parseInt(sum);
            System.out.println(sumInt);
            if (!isPrime(sumInt)) {
                return;
            }
        }

        if (length == N) {
            System.out.println(sum);
            pw.println(sum);
            return;
        }

        if (length == 0) {
            for (int i = 2; i <= 9; i++) {
                combi(sum + (i + ""), length + 1);
            }
        } else {
            for (int i = 0; i <= 9; i++) {
                combi(sum + (i + ""), length + 1);
            }
        }
    }
  
    //copy and pasted from pprime
    static boolean isPrime(int n) {
        if (n % 2 == 0 && n != 2)
            return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
