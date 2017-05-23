package ru.ifmo.ctddev.segal_task;

public class Gauss {
    public static int N = 10;
    public static double EPS = 1e-9;

    public static void solve(double[][] a) {
        double[][] c = new double[N][N + 1];

        for (int i = 0; i < N; i++)
            for (int j = 0; j <= N; j++)
                c[i][j] = (i == j ? 1.0 : 0.0);
        double kf = 1;
        for (int i = 0; i < N; i++) {
            int j = 0;
            while (j < N && Math.abs(a[i][j]) < EPS) {
                j++;
            }
            if (j != N) {
                double d;
                for (int k = 0; k < N; k++) {
                    if (k != i) {
                        d = a[k][j] / a[i][j];
                        kf *= d;
                        for (int z = 0; z <= N; z++) {
                            a[k][z] -= a[i][z] * d;
                        }
                        for (int z = 0; z <= N; z++) {
                            c[k][z] -= c[i][z] * d;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(String.format("%.8f", a[i][N] / a[i][i]));
        }
        double mx1 = 0, mx2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mx1 = Math.max(mx1, Math.abs(a[i][j]));
                mx2 = Math.max(mx2, Math.abs(c[i][j] / a[i][i]));
            }
        }
        System.out.println(String.format("cond of matrix: %.9f", mx1 * mx2));
    }
}
