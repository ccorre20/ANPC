package co.edu.eafit.an.linearsystems.util;

/**
 * Created by User on 5/28/2017.
 */

public class Utils {

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

    public static double[][]  PartialPivot(double[][] Ab, int k){
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
                Ab = ExchangeRows(Ab, largestrow, k);
            }
            return Ab;
        }
    }

    public static double[][] ExchangeRows(double[][] Ab, int r1, int r2){
        double t[] = Ab[r1];
        Ab[r1] = Ab[r2];
        Ab[r2] = t;
        return Ab;
    }

}
