package co.edu.eafit.an.onevar.methods;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.udojava.evalex.Expression;

import java.math.BigDecimal;

import co.edu.eafit.an.R;

public class NewtonActivity extends AppCompatActivity {

    EditText xa_et, gx_et, tol_et, niter_et, results;
    TextView func;
    Expression expr, gexpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newton);
        xa_et = (EditText)findViewById(R.id.newton_xa);
        gx_et = (EditText)findViewById(R.id.newton_gx);
        tol_et  = (EditText)findViewById(R.id.newton_tolerance);
        niter_et = (EditText)findViewById(R.id.newton_niter);
        func = (TextView)findViewById(R.id.newton_func);
        results = (EditText)findViewById(R.id.newton_result);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Intent i = getIntent();
        String s = "f(x) = " + i.getStringExtra("equation");
        func.setText(s);
        expr = new Expression(func.getText().toString());
    }

    public void runNewton(View v){
        String temp;
        BigDecimal x0 = BigDecimal.valueOf(Double.parseDouble(xa_et.getText().toString()));
        BigDecimal tol = BigDecimal.valueOf(Double.parseDouble(tol_et.getText().toString()));
        BigDecimal x1;
        int niter = Integer.parseInt(niter_et.getText().toString());
        //We have to trust in whoever set up the expression to not screw things up
        //TODO: We have to add checks to this function, otherwise this might crash the app.
        gexpr = new Expression(gx_et.getText().toString());
        if (niter < 1) {
            results.setHint("Bad number of iterations");
            return;
        }
        //Method Begins
        BigDecimal y = expr.with("x",x0).eval();
        BigDecimal dy = gexpr.with("x",x0).eval();
        int count = 0;
        BigDecimal error = tol.add(BigDecimal.ONE);
        while(error.compareTo(tol) > 0 && y.compareTo(BigDecimal.ZERO) != 0 && dy.compareTo(BigDecimal.ZERO) != 0 && count < niter){
            //x1 = x0 - (y/dy)
            x1 = x0.subtract(y.divide(dy,BigDecimal.ROUND_HALF_EVEN));
            y = expr.with("x",x1).eval();
            dy = gexpr.with("x",x1).eval();
            error = x1.subtract(x0).abs();
            x0 = x1;
            count++;
        }
        if(y.compareTo(BigDecimal.ZERO) == 0){
            temp = "x = " + x0.toString() + " is a root";
            results.setText(temp);
        }else if(error.compareTo(tol) < 0) {
            temp = "x = " + x0.toString() + " is an approximate root, err=" + error.toString();
            results.setText(temp);
        }else{
            temp = "the method failed after" + niter + " iterations";
            results.setText(temp);
        }
    }
}
