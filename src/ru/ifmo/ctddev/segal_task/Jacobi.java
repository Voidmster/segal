package ru.ifmo.ctddev.segal_task;

public class Jacobi {

    public static int N = 10;

    public static double EPS = 1e-9;

    public static void solve(double[][] a) {
        double sumD = 0;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    sum += Math.abs(a[i][j]);
                } else {
                    sumD += Math.abs(a[i][j]);
                }
            }
        }

        if (sumD < sum) {
            System.out.println("Sorry, I can't solve this!");
            return;
        }
        double[] x = new double[N];
        for (int i = 0; i < N; ++i) {
            if (Math.abs(a[i][i]) > EPS) {
                x[i] = (a[i][N] / a[i][i]);
            }
        }
        double[] TempX = new double[N];
        double norm;
        int iteration = 0;
        do {
            iteration++;
            for (int i = 0; i < N; i++) {
                TempX[i] = a[i][N];
                for (int j = 0; j < N; j++) {
                    if (i != j) {
                        TempX[i] -= a[i][j] * x[j];
                    }
                }
                if (Math.abs(a[i][i]) > EPS) {
                    TempX[i] /= a[i][i];
                } else {
                    TempX[i] = 0;
                }
            }
            norm = Math.abs(x[0] - TempX[0]);
            for (int j = 0; j < N; j++) {
                norm = Math.max(Math.abs(x[j] - TempX[j]), norm);
                x[j] = TempX[j];
            }
        } while (norm > 1e-9 && iteration < 1e6);
        for (int i = 0; i < N; i++) {
            System.out.println(String.format("%.12f", x[i]));
        }
        System.out.println("Count of iterations " + iteration);
    }
}
