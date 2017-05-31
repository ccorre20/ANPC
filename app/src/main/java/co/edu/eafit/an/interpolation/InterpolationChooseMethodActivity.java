package co.edu.eafit.an.interpolation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import co.edu.eafit.an.R;
import co.edu.eafit.an.interpolation.BasedOnESActivity;

public class InterpolationChooseMethodActivity extends AppCompatActivity {

    double points[];
    Bundle bun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolation_choose_method);

        Intent intent = getIntent();
        points = (double[]) intent.getExtras().getSerializable("points");
        bun = new Bundle();
        bun.putSerializable("points", points);
    }

    public void boesMethod(View v) {
        Intent i = new Intent(this, BasedOnESActivity.class);
        i.putExtras(bun);
        startActivity(i);
    }

    public void nipMethod(View v) {
        Intent i = new Intent(this, NewtonPolynomialActivity.class);
        i.putExtras(bun);
        startActivity(i);
    }

    public void nipddMethod(View v) {
        Intent i = new Intent(this, NewtonPolynomialDDActivity.class);
        i.putExtras(bun);
        startActivity(i);
    }

    public void lipMethod(View v) {
        Intent i = new Intent(this, LagrangePolynomialActivity.class);
        i.putExtras(bun);
        startActivity(i);
    }

    public void nmMethod(View v) {
        Intent i = new Intent(this, NevillesMethodActivity.class);
        i.putExtras(bun);
        startActivity(i);
    }
}
