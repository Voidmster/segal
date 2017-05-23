package ru.ifmo.ctddev.segal_task;

public class Main {

    public static void main(String[] args) {
//        FastScanner f = new FastScanner(System.in);
//        int n = f.nextInt();
//        double [][] a = new double[10][10];
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                a[i][j] = f.nextDouble();
//            }
//        }
//        makeTest(a, n);
        makeTest(Utils.getIllConditionedMatrix(10), 10);
        makeTest(Utils.getIllConditionedMatrix(10), 10);
        makeTest(Utils.identityMatrix(10), 10);
        makeTest(Utils.zeroMatrix(10), 10);
    }

    public static void makeTest(double[][] a, int n) {
        for (int k = 0; k < n; k++) {
            System.out.print("Gauss answer to test " + k + ":");
            Gauss.solve(a);
            System.out.print("Jacobi answer to test " + k + ":");
            Jacobi.solve(a);
        }
    }
}
