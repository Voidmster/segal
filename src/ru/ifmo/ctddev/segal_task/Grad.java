package ru.ifmo.ctddev.segal_task;

/**
 * Created by bigz on 24.05.17.
 */
public class Grad {
    private final double eps = 1e-9;

    static void process(int size, double[][] matrix) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    System.out.println("Unsolvable");
                    return;
                }
            }
        }
        double x[] = new double[size];
        for (int i = 0; i < size; ++i)
            x[i] = matrix[i][size] / matrix[i][i];
        double r[] = new double[size],
                z[] = new double[size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j)
                r[i] -= matrix[i][j] * x[j];
            r[i] += matrix[i][size];
            z[i] = r[i];
        }
        for (int it = 0; it < 4 * size; ++it) {
            double v = 0;
            for (int i = 0; i < size; ++i)
                v += r[i] * r[i];
            double w = 0;
            for (int i = 0; i < size; ++i) {
                double t = 0;
                for (int j = 0; j < size; ++j)
                    t += matrix[i][j] * z[j];
                w += t * z[i];
            }
            double alpha;
            if (v == 0 || w == 0) {
                alpha = 0;
            } else {
                alpha = v / w;
            }

            for (int i = 0; i < size; ++i)
                x[i] += alpha * z[i];
            double r_prev[] = r.clone();
            for (int i = 0; i < size; ++i) {
                double t = 0;
                for (int j = 0; j < size; ++j)
                    t += matrix[i][j] * z[j];
                r[i] -= alpha * t;
            }
            v = 0;
            for (int i = 0; i < size; ++i)
                v += r[i] * r[i];
            w = 0;
            for (int i = 0; i < size; ++i)
                w += r_prev[i] * r_prev[i];
            double beta;
            if (v == 0 || w == 0) {
                beta = 0;
            } else {
                beta = v / w;
            }

            for (int i = 0; i < size; ++i)
                z[i] = r[i] + beta * z[i];
        }
        for (int i = 0; i < size; i++) {
            System.out.println(String.format("%.12f", x[i]));
        }

    }
}
