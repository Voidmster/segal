package ru.ifmo.ctddev.segal_task;

/**
 * Created by bigz on 23.05.17.
 */
public class Seidel {
    static final double eps = 1e-9;


    static void process(int size, double[][] matrix, double om) {
        double sumd = 0, sum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    sum += Math.abs(matrix[i][j]);
                } else {
                    sumd += Math.abs(matrix[i][j]);
                }
            }
        }
        if (sumd < sum) {
            System.out.println("Can`t solve");
            return;
        }
        double x[] = new double[10];
        for (int i = 0; i < size; i++) {
            x[i] = matrix[i][size] / matrix[i][i];
        }
        double tempX[] = new double[10];
        int iteration = 0;
        double norm;
        do {
            norm = -1;
            iteration++;
            for (int i = 0; i < size; i++) {
                tempX[i] = matrix[i][size] * om;
                for (int j = 0; j < size; j++) {
                    if (i != j) {
                        tempX[i] -= matrix[i][j] * x[j] * om;
                    }
                }
                if (Math.abs(matrix[i][i]) > eps) {
                    tempX[i] /= matrix[i][i];
                } else {
                    tempX[i] = 0;
                }
                double prev = x[i];
                x[i] = tempX[i] - x[i] * (om - 1);
                norm = Math.max(Math.abs(x[i] - prev), norm);
            }
        } while (norm > eps && iteration < 1e3);
        for (int i = 0; i < size; i++) {
            System.out.println(String.format("%.12f", x[i]));
        }
        System.out.println("Number of iterations:" + iteration);
    }

}