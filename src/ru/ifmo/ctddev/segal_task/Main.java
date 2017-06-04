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
        System.out.println("Ill conditioned matrix: ");
        double[][] tt = Utils.getIllConditionedMatrix(10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= 10; j++) {
                System.out.print(tt[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.println("Well conditioned matrix: ");
        double[][] ttt = Utils.getWellConditionedMatrix(10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= 10; j++) {
                System.out.print(ttt[i][j] + " ");

            }
            System.out.print("\n");
        }
        System.out.println("Random conditioned matrix: ");

        double[][] rndM = Utils.randomMatrix(10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= 10; j++) {
                System.out.print(rndM[i][j] + " ");

            }
            System.out.print("\n");
        }
        makeTest(tt, "ill cond");
        makeTest(ttt, "well cond");
        makeTest(rndM, "random matrix");
    }

    public static void makeTest(double[][] a, String comment) {
        System.out.println("=== Gauss (" + comment + "):");
        Gauss.solve(makeArrayCopy(a));
        System.out.println("=== Jacobi (" + comment + "):");
        Jacobi.solve(makeArrayCopy(a));
        System.out.println("=== Seidel (" + comment + "):");
        Seidel.process(10, makeArrayCopy(a), 1);
        System.out.println("=== Gradient (" + comment + "):");
        Grad.process(10, makeArrayCopy(a));
    }

    private static double[][] makeArrayCopy(double[][] a){
        double ret[][] = new double[10][11];
        for (int i =0;i<10;i++){
            System.arraycopy(a[i], 0, ret[i], 0, 11);
        }
        return ret;
    }
}
