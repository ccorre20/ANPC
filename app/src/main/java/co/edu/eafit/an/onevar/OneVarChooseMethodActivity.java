package co.edu.eafit.an.onevar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import co.edu.eafit.an.R;
import co.edu.eafit.an.onevar.methods.BisectionActivity;
import co.edu.eafit.an.onevar.methods.FalseRuleActivity;
import co.edu.eafit.an.onevar.methods.FixedPointActivity;
import co.edu.eafit.an.onevar.methods.IncrementalSearchActivity;
import co.edu.eafit.an.onevar.methods.MultipleRootActivity;
import co.edu.eafit.an.onevar.methods.NewtonActivity;
import co.edu.eafit.an.onevar.methods.SecantActivity;

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
        Intent i = new Intent(this, IncrementalSearchActivity.class);
        i.putExtra("equation", f);
        startActivity(i);
    }

    public void btnBisection(View v){
        Intent i = new Intent(this, BisectionActivity.class);
        i.putExtra("equation", f);
        startActivity(i);
    }

    public void btnFalseRule(View v){
        Intent i = new Intent(this, FalseRuleActivity.class);
        i.putExtra("equation", f);
        startActivity(i);
    }

    public void btnFixedPoint(View v){
        Intent i = new Intent(this, FixedPointActivity.class);
        i.putExtra("equation", f);
        startActivity(i);
    }

    public void btnNewton(View v){
        Intent i = new Intent(this, NewtonActivity.class);
        i.putExtra("equation", f);
        startActivity(i);
    }

    public void btnSecant(View v){
        Intent i = new Intent(this, SecantActivity.class);
        i.putExtra("equation", f);
        startActivity(i);
    }

    public void btnMultipleRoot(View v){
        Intent i = new Intent(this, MultipleRootActivity.class);
        i.putExtra("equation", f);
        startActivity(i);
    }
}
