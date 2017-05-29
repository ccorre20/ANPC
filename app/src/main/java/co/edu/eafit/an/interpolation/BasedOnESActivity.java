package co.edu.eafit.an.interpolation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.Arrays;

import co.edu.eafit.an.R;
import co.edu.eafit.an.linearsystems.util.Utils;

public class BasedOnESActivity extends AppCompatActivity {

    Button knownPointsButton, nextPoint;
    EditText knownPoints, inputPoints;
    TextView insertPoints, solution, polynomial;

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
        solution = (TextView) findViewById(R.id.solution);
        polynomial = (TextView) findViewById(R.id.polynomial);
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
        double[][] a = new double[len][len];
        double[] b = new double[len];

        for (i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = Math.pow(points[i * 2], len - (j + 1));
            }
            b[i] = points[(i * 2) + 1];
            System.out.print(Arrays.toString(a[i]) + " = ");
            System.out.println(b[i]);

        }

        double[] sol = solveSystem(a,b);

        nextPoint.setVisibility(View.INVISIBLE);
        insertPoints.setVisibility(View.INVISIBLE);
        inputPoints.setVisibility(View.INVISIBLE);
        solution.setVisibility(View.VISIBLE);
        polynomial.setVisibility(View.VISIBLE);

        String pol = "p(x) = ";
        for (int i = 0; i < len; i++) {
            if (sol[i] >= 0 && i != 0) pol += "+";
            if ((len - (i + 1)) == 0) pol += sol[i];
            else if ((len - (i + 1)) == 1) pol += sol[i] + "x";
            else pol += sol[i] + "x^" + (len - (i + 1));
        }

        polynomial.setText(pol);
    }

    public double[] solveSystem(double[][] a, double[] b) {

        // Solving with Total Pivot Gauss

        int n = a.length;
        int marks[] = new int[n];
        for(int i = 0; i<n; i++){
            marks[i] = i;
        }
        double mult;
        Utils.MatrixMarks mm;
        //Method Begins
        double m[][] = Utils.augmentMatrix(a,b);
        for (int k = 0; k < n-1; k++){
            mm = Utils.totalPivot(m,k,marks);
            m = mm.Ab;
            marks = mm.marks;
            for (int i = k+1; i < n; i++){
                mult = m[i][k]/m[k][k];
                for (int j = k; j < n+1; j++){
                    m[i][j] = m[i][j] - mult*m[k][j];
                }
            }
        }
        double x[] = Utils.regressiveSubstitution(m);
        x = Utils.markAwareX(x,marks);

        return x;
    }
}
