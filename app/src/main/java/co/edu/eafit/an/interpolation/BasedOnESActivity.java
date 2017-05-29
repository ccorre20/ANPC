package co.edu.eafit.an.interpolation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.Arrays;

import co.edu.eafit.an.R;

public class BasedOnESActivity extends AppCompatActivity {

    Button knownPointsButton, nextPoint;
    EditText knownPoints, inputPoints;
    TextView insertPoints;

    int i, j, n;
    double points[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_based_on_es);

        knownPointsButton = (Button)findViewById(R.id.know_points_ok);
        knownPoints = (EditText) findViewById(R.id.known_points);
        inputPoints = (EditText) findViewById(R.id.inputPoints);
        nextPoint = (Button) findViewById(R.id.nextPoint);
        insertPoints = (TextView) findViewById(R.id.insertPoints);
    }

    public void insertPoints(View v) {
        n = Integer.parseInt(knownPoints.getText().toString());

        if (n > 0) {
            knownPointsButton.setEnabled(false);
            knownPointsButton.setVisibility(View.INVISIBLE);
            knownPoints.setEnabled(false);
            knownPoints.setVisibility(View.INVISIBLE);

            insertPoints.setVisibility(View.VISIBLE);
            inputPoints.setVisibility(View.VISIBLE);
            nextPoint.setVisibility(View.VISIBLE);

            i = 0;

            points = new double[n * 2];
        } else {
            Toast.makeText(getApplicationContext(), "Wrong parameter", Toast.LENGTH_SHORT).show();
        }
    }

    public void nextPoint(View v) {
        Double point = Double.parseDouble(inputPoints.getText().toString());

        if (i < (n * 2)) {
            points[i] = point;
            i++;
            if (i % 2 == 0) insertPoints.setText("x" + i / 2);
            else insertPoints.setText("y" + i / 2);
        }

        if (i == (n * 2)) {
            inputPoints.setEnabled(false);
            nextPoint.setEnabled(false);
            calculatePolynomial(points, n);
        }

    }

    public void calculatePolynomial(double[] points, int len) {
        double[][] matrix = new double[len][len];

        for (i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = Math.pow(points[i * 2], len - (j + 1));
            }
        }
    }
}
