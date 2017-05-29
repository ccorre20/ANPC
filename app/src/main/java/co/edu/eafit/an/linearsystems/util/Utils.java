package co.edu.eafit.an.linearsystems.util;

/**
 * Created by User on 5/28/2017.
 */

public class Utils {

    public static class MatrixMarks{
        public double Ab[][];
        public int marks[];
    }

    public static double[][] augmentMatrix(double[][] a, double[] b){
        double Ab[][] = new double[a.length][a.length+1];
        for (int i=0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                Ab[i][j] = a[i][j];
            }
        }
        for (int i = 0; i < a.length; i++){
            Ab[i][a.length] = b[i];
        }
        return Ab;
    }

    public static double[] regresiveSubstitution(double[][] Ab){
        int n = Ab.length;
        double x[] = new double[n];
        double sum;
        x[n-1] = Ab[n-1][n]/Ab[n-1][n-1];
        for (int i = n -2; i > -1; i--){
            sum = 0;
            for (int p = i+1; p < n; p++){
                sum = sum + Ab[i][p]*x[p];
            }
            x[i] = (Ab[i][n] - sum)/Ab[i][i];
        }
        return x;
    }

    public static double[][] partialPivot(double[][] Ab, int k){
        int n = Ab.length;
        double largest = Math.abs(Ab[k][k]);
        int largestrow = k;
        for(int s = k+1; s < n; s++){
            if(Math.abs(Ab[s][k]) > largest){
                largest = Math.abs(Ab[s][k]);
                largestrow = s;
            }
        }
        if(largest == 0.0f){
            //TODO: Fix this and throw error instead, add error handling
            return Ab;
        } else {
            if (largestrow != k){
                Ab = exchangeRows(Ab, largestrow, k);
            }
            return Ab;
        }
    }

    public static MatrixMarks totalPivot(double[][] Ab, int k, int[] marks){
        int n = Ab.length;
        double largest = 0;
        int largestrow = k;
        int largestcolumn = k;
        for (int r = k; r < n; r++){
            for (int s = k; s < n; s++){
                if(Math.abs(Ab[r][s]) > largest){
                    largest = Math.abs(Ab[r][s]);
                    largestrow = r;
                    largestcolumn = s;
                }
            }
        }
        MatrixMarks mm = new MatrixMarks();
        if (largest == 0){
            //TODO: This is wrong, needs to be fixed with exception throwing.
            mm.Ab = Ab;
            mm.marks = marks;
            return mm;
        }else{
            if(largestrow != k){
                Ab = exchangeRows(Ab, largestrow, k);
            }
            if(largestcolumn != k){
                Ab = exchangeColumns(Ab, largestcolumn, k);
                marks = exchangeMarks(marks, largestcolumn, k);
            }
            mm.Ab = Ab;
            mm.marks = marks;
            return mm;
        }
    }

    public static double[][] exchangeRows(double[][] Ab, int r1, int r2){
        double t[] = Ab[r1];
        Ab[r1] = Ab[r2];
        Ab[r2] = t;
        return Ab;
    }

    public static double[][] exchangeColumns(double[][] Ab, int c1, int c2){
        int n = Ab.length;
        double t;
        for(int i = 0; i < n; i++){
            t = Ab[i][c1];
            Ab[i][c1] = Ab[i][c2];
            Ab[i][c2] = t;
        }
        return Ab;
    }

    public static int[] exchangeMarks(int[] marks, int m1, int m2){
        int t = marks[m1];
        marks[m1] = marks[m2];
        marks[m2] = t;
        return marks;
    }

    public static double[] markAwareX(double[] x, int[] marks){
        int n = x.length;
        int j;
        double result[] = new double[n];
        for(int i = 0; i < n; i++){
            j = marks[i];
            result[j] = x[i];
        }
        return result;
    }

}
