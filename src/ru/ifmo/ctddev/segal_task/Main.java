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
        makeTest(Utils.getIllConditionedMatrix(10), "ill cond");
        makeTest(Utils.getWellConditionedMatrix(10), "well cond");
        makeTest(Utils.identityMatrix(10), "ident");
    }

    public static void makeTest(double[][] a, String comment) {
        System.out.println("=== Gauss (" + comment + "):");
        Gauss.solve(a);
        System.out.println("=== Jacobi (" + comment + "):");
        //Jacobi.solve(a);
    }
}
