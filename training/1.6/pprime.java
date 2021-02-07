
/*
ID: kevinst4
LANG: JAVA
TASK: pprime
*/
import java.util.*;
import java.io.*;

public class pprime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pprime.in"));
        pw = new PrintWriter(new FileWriter("pprime.out"));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        a = Integer.parseInt(st.nextToken());

        String bS = st.nextToken();
        b = Integer.parseInt(bS);

        // create prime checker
        // sieve = new boolean[100000000];

        // sieve[0] = true;
        // sieve[1] = true;

        // for (int i = 2; i < sieve.length; i++) {
        // if (!sieve[i]) {
        // for (int j = 2; j * i < sieve.length; j++) {
        // sieve[i * j] = true;
        // }
        // }
        // }

        // generate palindromes
        pali = new int[1000];
        Arrays.fill(pali, Integer.MAX_VALUE);
        pali();
        Arrays.sort(pali);
        // System.out.println(pali);
        for (int b : pali) {
            if (b == Integer.MAX_VALUE) {
                break;
            }
            // System.out.println(b);
            pw.println(b);
        }
        pw.close();

    }

    static int a, b;
    static boolean[] sieve;
    static int[] pali;
    static PrintWriter pw;
    static int pI = 0;

    static void pali() {

        for (int i = a; i < 10; i++) {
            if (isPrime(i)) {
                pali[pI] = i;
                pI++;
            }
        }

        if (a < 11 && b > 11) {
            pali[pI] = 11;
            pI++;
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int first = i * 100 + j * 10 + i;
                int second = i * 1000 + j * 100 + j * 10 + i;

                if (first >= a && first <= b && isPrime(first)) {
                    pali[pI] = first;
                    pI++;
                }
                if (second >= a && second <= b && isPrime(second)) {
                    pali[pI] = second;
                    pI++;
                }
                for (int k = 0; k < 10; k++) {
                    first = i * 10000 + j * 1000 + k * 100 + j * 10 + i;
                    second = i * 100000 + j * 10000 + k * 1000 + k * 100 + j * 10 + i;
                    if (first >= a && first <= b && isPrime(first)) {
                        pali[pI] = first;
                        pI++;
                    }
                    if (second >= a && second <= b && isPrime(second)) {
                        pali[pI] = second;
                        pI++;
                    }
                    for (int l = 0; l < 10; l++) {
                        first = i * 1000000 + j * 100000 + k * 10000 + l * 1000 + k * 100 + j * 10 + i;
                        second = i * 10000000 + j * 1000000 + k * 100000 + l * 10000 + l * 1000 + k * 100 + j * 10 + i;
                        if (first >= a && first <= b && isPrime(first)) {
                            pali[pI] = first;
                            pI++;
                        }
                        if (second >= a && second <= b && isPrime(second)) {
                            pali[pI] = second;
                            pI++;
                        }
                        for (int m = 0; m < 10; m++) {
                            first = i * 100000000 + j * 10000000 + k * 1000000 + l * 100000 + m * 10000 + l * 1000
                                    + k * 100 + j * 10 + i;
                            second = i * 1000000000 + j * 100000000 + k * 10000000 + l * 1000000 + m * 100000
                                    + m * 10000 + l * 1000 + k * 100 + j * 10 + i;
                            if (first >= a && first <= b && isPrime(first)) {
                                pali[pI] = first;
                                pI++;
                            }
                            if (second >= a && second <= b && isPrime(second)) {
                                pali[pI] = second;
                                pI++;
                            }
                        }
                    }
                }
            }
        }

    }

    static boolean isPrime(int n) {
        if (n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

}
