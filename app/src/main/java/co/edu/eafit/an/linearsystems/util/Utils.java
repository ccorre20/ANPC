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

}
