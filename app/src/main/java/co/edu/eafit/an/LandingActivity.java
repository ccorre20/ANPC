package co.edu.eafit.an;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import co.edu.eafit.an.diff.DiffLandingActivity;
import co.edu.eafit.an.interpolation.InterpolationChooseMethodActivity;
import co.edu.eafit.an.interpolation.InterpolationLandingActivity;
import co.edu.eafit.an.linearsystems.LinearSystemLandingActivity;
import co.edu.eafit.an.onevar.OneVarLandingActivity;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
    }

    public void Button1(View v){
        Intent i = new Intent(this, OneVarLandingActivity.class);
        startActivity(i);
    }

    public void Button2(View v){
        Intent i = new Intent(this, LinearSystemLandingActivity.class);
        startActivity(i);

    }

    public void Button3(View v){
        Intent i = new Intent(this, InterpolationLandingActivity.class);
        startActivity(i);
    }

    public void Button4(View v){
        Intent i = new Intent(this, DiffLandingActivity.class);
        startActivity(i);
    }
}
