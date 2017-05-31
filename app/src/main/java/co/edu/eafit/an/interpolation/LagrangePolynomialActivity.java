package co.edu.eafit.an.interpolation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.edu.eafit.an.R;

public class LagrangePolynomialActivity extends AppCompatActivity {

    double[] points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lagrange_polynomial);

        Intent intent = getIntent();
        points = (double[]) intent.getExtras().getSerializable("points");

        String solve = "";

        for (int i = 0; i < points.length / 2; i++) {
            if (points[(i * 2) + 1] > 0 && i > 0)
                solve += "+" + points[(i * 2) + 1] + findL(points, i);
            else solve += points[(i * 2) + 1] + "*" + findL(points, i);
        }

        System.out.println("p(x) = " + solve); // Polynomial
    }

    public String findL(double[] points, int index) {
        String equation = "";
        double divider = 1;

        for (int i = 0; i < points.length / 2; i++)
            if (i != index)
                divider *= (points[index * 2] - points[i * 2]);

        for (int i = 0; i < points.length / 2; i++)
            if (i != index)
                if (points[i * 2] > 0)
                    equation += "(x-" + points[i * 2] + ")";
                else equation += "(x+" + (-1) * points[i * 2] + ")";

        equation = "[(" + equation + ")/" + divider + "]";

        return equation;
    }
}
