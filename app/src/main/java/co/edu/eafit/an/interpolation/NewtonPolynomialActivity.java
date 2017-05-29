package co.edu.eafit.an.interpolation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.edu.eafit.an.R;

public class NewtonPolynomialActivity extends AppCompatActivity {

    double[] points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newton_polynomial);

        Intent intent = getIntent();
        points = (double[]) intent.getExtras().getSerializable("points");
    }
}
