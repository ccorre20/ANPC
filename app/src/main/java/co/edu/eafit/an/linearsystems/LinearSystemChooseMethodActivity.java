package co.edu.eafit.an.linearsystems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import co.edu.eafit.an.R;

public class LinearSystemChooseMethodActivity extends AppCompatActivity {

    double a[][], b[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_system_choose_method);
        Intent intent = getIntent();
        a = (double[][]) intent.getExtras().getSerializable("a");
        b = (double[]) intent.getExtras().getSerializable("b");
    }

    public void gauss(View v){

    }

    public void partialPivotGauss(View v){

    }

    public void totalPivotGauss(View v){

    }

    public void luGauss(View v){

    }

    public void luPivotGauss(View v){

    }

    public void directLu(View v){

    }

    public void jacobi(View v){

    }

    public void gaussSeidel(View v){

    }
}
