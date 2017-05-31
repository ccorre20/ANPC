package co.edu.eafit.an.interpolation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import co.edu.eafit.an.R;
import co.edu.eafit.an.linearsystems.LinearSystemChooseMethodActivity;

public class InterpolationLandingActivity extends AppCompatActivity {

    Button knownPointsButton, nextPoint;
    EditText knownPoints, inputPoints;
    TextView insertPoints;

    int i, j, n;
    double points[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolation_landing);

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
            if (i % 2 == 0) insertPoints.setText("Enter x" + i / 2);
            else insertPoints.setText("Enter y" + i / 2);
        }

        if (i == (n * 2)) {
            inputPoints.setEnabled(false);
            nextPoint.setEnabled(false);
            Intent i = new Intent(this,InterpolationChooseMethodActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("points", points);
            i.putExtras(bundle);
            startActivity(i);
        }
        inputPoints.setText("");
    }
}
