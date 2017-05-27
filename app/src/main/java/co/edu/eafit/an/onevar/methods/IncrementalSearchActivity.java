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

public class IncrementalSearchActivity extends AppCompatActivity {

    EditText x0_et, delta_et, niter_et, results;
    TextView func;
    Expression expr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incremental_search);
        x0_et = (EditText)findViewById(R.id.incsearch_x0);
        delta_et = (EditText)findViewById(R.id.incsearch_delta);
        niter_et = (EditText)findViewById(R.id.incsearch_niter);
        results = (EditText)findViewById(R.id.incsearch_results);
        func = (TextView)findViewById(R.id.incsearch_func);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Intent i = getIntent();
        String s = "f(x) = " + i.getStringExtra("equation");
        func.setText(s);
        expr = new Expression(func.getText().toString());
    }

    public void runIncSearch(View v){
        String temp;
        BigDecimal x0 = BigDecimal.valueOf(Double.parseDouble(x0_et.getText().toString()));
        BigDecimal delta = BigDecimal.valueOf(Double.parseDouble(delta_et.getText().toString()));
        int niter = Integer.parseInt(niter_et.getText().toString());
        if(niter < 1) {
            results.setHint("Bad number of iterations");
            return;
        }
        //Method begins
        try {
            //y0 = f(x0)
            BigDecimal y0 = expr.with("x", x0).eval();
            // if y0 = 0
            if(y0.compareTo(BigDecimal.ZERO) == 0){
                temp = "x = " + x0.toString() + " is a root";
                results.setText(temp);
            }else{
                //x1 = x0 + delta
                BigDecimal x1 = x0.add(delta);
                int count = 1;
                //y1 = f(x1)
                BigDecimal y1 = expr.with("x", x1).eval();
                // y0*y1 > 0 && count < niter
                while(y0.multiply(y1).compareTo(BigDecimal.ZERO) > 0 && count < niter){
                    x0 = x1;
                    y0 = y1;
                    //x1 = x0 + delta
                    x1 = x0.add(delta);
                    //y1 = f(x1)
                    y1 = expr.with("x", x1).eval();
                    count++;
                }
                if(y1.compareTo(BigDecimal.ZERO) == 0) {
                    temp = "x = " + x1.toString() + " is a root";
                    results.setText(temp);
                }else if(y0.multiply(y1).compareTo(BigDecimal.ZERO) < 0){
                    temp = "There is a root between x0=" + x0.toString() + " and x1=" + x1.toString();
                    results.setText(temp);
                }else{
                    temp = "The method failed after " + niter + " iterations";
                    results.setText(temp);
                }
            }
        }catch (Expression.ExpressionException e){
            e.printStackTrace();
        }
    }
}
