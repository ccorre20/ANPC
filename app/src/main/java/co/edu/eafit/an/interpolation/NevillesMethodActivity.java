package co.edu.eafit.an.interpolation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.edu.eafit.an.R;

public class NevillesMethodActivity extends AppCompatActivity {

    double[] points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nevilles_method);

        Intent intent = getIntent();
        points = (double[]) intent.getExtras().getSerializable("points");
    }
}
