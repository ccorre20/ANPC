package co.edu.eafit.an.onevar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import co.edu.eafit.an.R;

public class OneVarChooseMethodActivity extends AppCompatActivity {

    String f;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_var_choose_method);

        Intent i = getIntent();
        f = i.getStringExtra("equation");
        t = (TextView)findViewById(R.id.tviewchoosemethod);
    }

    @Override
    protected void onStart(){
        super.onStart();
        String s = "f(x) = " + f;
        t.setText(s);
    }

    public void btnIncSearch(View v){

    }

    public void btnBisection(View v){

    }

    public void btnFalseRule(View v){

    }

    public void btnFixedPoint(View v){

    }

    public void btnNewton(View v){

    }

    public void btnSecant(View v){

    }

    public void btnMultipleRoot(View v){

    }
}
