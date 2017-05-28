package co.edu.eafit.an.linearsystems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import co.edu.eafit.an.R;
import co.edu.eafit.an.linearsystems.methods.DirectLUActivity;
import co.edu.eafit.an.linearsystems.methods.GaussActivity;
import co.edu.eafit.an.linearsystems.methods.GaussSeidelActivity;
import co.edu.eafit.an.linearsystems.methods.JacobiActivity;
import co.edu.eafit.an.linearsystems.methods.LUGaussActivity;
import co.edu.eafit.an.linearsystems.methods.LUPivotGaussActivity;
import co.edu.eafit.an.linearsystems.methods.PartialPivotGaussActivity;
import co.edu.eafit.an.linearsystems.methods.TotalPivotGaussActivity;

public class LinearSystemChooseMethodActivity extends AppCompatActivity {

    double a[][], b[];
    Bundle bun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_system_choose_method);
        Intent intent = getIntent();
        a = (double[][]) intent.getExtras().getSerializable("a");
        b = (double[]) intent.getExtras().getSerializable("b");
        bun = new Bundle();
        bun.putSerializable("a", a);
        bun.putSerializable("b", b);
    }

    public void gauss(View v){
        Intent i = new Intent(this, GaussActivity.class);
        i.putExtras(bun);
        startActivity(i);
    }

    public void partialPivotGauss(View v){
        Intent i = new Intent(this, PartialPivotGaussActivity.class);
        i.putExtras(bun);
        startActivity(i);
    }

    public void totalPivotGauss(View v){
        Intent i = new Intent(this, TotalPivotGaussActivity.class);
        i.putExtras(bun);
        startActivity(i);
    }

    public void luGauss(View v){
        Intent i = new Intent(this, LUGaussActivity.class);
        i.putExtras(bun);
        startActivity(i);
    }

    public void luPivotGauss(View v){
        Intent i = new Intent(this, LUPivotGaussActivity.class);
        i.putExtras(bun);
        startActivity(i);
    }

    public void directLu(View v){
        Intent i = new Intent(this, DirectLUActivity.class);
        i.putExtras(bun);
        startActivity(i);
    }

    public void jacobi(View v){
        Intent i = new Intent(this, JacobiActivity.class);
        i.putExtras(bun);
        startActivity(i);
    }

    public void gaussSeidel(View v){
        Intent i = new Intent(this, GaussSeidelActivity.class);
        i.putExtras(bun);
        startActivity(i);
    }
}
