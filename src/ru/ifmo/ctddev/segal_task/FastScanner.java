package ru.ifmo.ctddev.segal_task;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by tolmach on 24.05.17.
 */
public class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStream f) {
        br = new BufferedReader(new InputStreamReader(f));
    }

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }
}
