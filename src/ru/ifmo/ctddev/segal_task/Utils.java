package ru.ifmo.ctddev.segal_task;

public class Utils {
    public static double[][] getWellConditionedMatrix(int n) {
        double[][] a = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = Math.pow(-0.5, Math.abs(j - i)) / n;
            }
            a[i][i] = -1;
        }
        return a;
    }

    public static double[][] getIllConditionedMatrix(int n) {
        double[][] a = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = 1.0 / (i + j + 1);
            }
        }
        return a;
    }

    public static double[][] identityMatrix(int n) {
        double[][] a = new double[n][n];

        for (int i = 0; i < n; i++) {
            a[i][i] = 1.0;
        }
        return a;
    }

    public static double[][] zeroMatrix(int n) {
        double[][] a = new double[n][n];
        return a;
    }
}
