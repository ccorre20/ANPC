package co.edu.eafit.an.linearsystems.methods;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import co.edu.eafit.an.R;
import co.edu.eafit.an.linearsystems.util.Utils;

public class GaussActivity extends AppCompatActivity {

    double a[][], b[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gauss);
        Intent intent = getIntent();
        a = (double[][]) intent.getExtras().getSerializable("a");
        b = (double[]) intent.getExtras().getSerializable("b");

        runGauss();
    }

    public void runGauss() {
        int n = a.length;
        double mult;
        //Method Begins
        double m[][] = Utils.augmentMatrix(a,b);
        for (int k = 0; k < n-1; k++){
            for (int i = k+1; i < n; i++){
                mult = m[i][k]/m[k][k];
                for (int j = k; j < n+1; j++){
                    m[i][j] = m[i][j] - mult*m[k][j];
                }
            }
        }
        double x[] = Utils.regressiveSubstitution(m);
    }
}
