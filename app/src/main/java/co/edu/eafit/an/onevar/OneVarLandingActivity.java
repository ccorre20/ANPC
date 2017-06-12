package co.edu.eafit.an.onevar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.udojava.evalex.Expression;

import java.math.BigDecimal;

import co.edu.eafit.an.R;

public class OneVarLandingActivity extends AppCompatActivity {

    EditText func;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_var_landing);
        func = (EditText)findViewById(R.id.et1onevar);
    }

    public void parseAndVerify(View v){
        Expression expr = new Expression(func.getText().toString());
        /*
        //BigDecimal d = expr.with("x", BigDecimal.ZERO).eval();
        //Extremely rudimentary testing.
        Log.d("TEST",expr.toString());
        //Log.d("Testing expression", d.toString());
        BigDecimal e = expr.with("x", BigDecimal.ONE).eval();
        //Extremely rudimentary testing.
        Log.d("TEST",expr.toString());
        Log.d("Testing expression", e.toString());
        */
        BigDecimal x0 = BigDecimal.valueOf(-10d), x1 = null;
        BigDecimal delta = BigDecimal.valueOf(0.05);
        for (int i = 0; i < 1000; i++){
            double x = x0.add(delta.multiply(BigDecimal.valueOf((double)i))).doubleValue();
            try{
                expr.with("x", BigDecimal.valueOf(x)).eval();
                x1 = BigDecimal.valueOf(x);
                System.out.println("Okay" + x);
                break;
            } catch (Exception e){
                //
            }
            System.out.println(x);
        }
        if (x1 != null) {
            //If it gets here it means the expression can be successfully evaluated.
            Intent i = new Intent(this, OneVarChooseMethodActivity.class);
            i.putExtra("equation", func.getText().toString());
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void graph(View v){
        /*
        try {
            Expression expr = new Expression(func.getText().toString());
            //BigDecimal d = expr.with("x", BigDecimal.ZERO).eval();
            Log.d("TEST",expr.toString());
            //Log.d("Testing expression", d.toString());
            //Extremely rudimentary testing.
            BigDecimal e = expr.with("x", BigDecimal.ONE).eval();
            Log.d("TEST",expr.toString());
            Log.d("Testing expression", e.toString());
            //If it gets here it means the expression can be successfully evaluated.
            Intent i = new Intent(this, GraphActivity.class);
            i.putExtra("equation", func.getText().toString());
            startActivity(i);
        }catch (Expression.ExpressionException e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
        }
        */
        Expression expr = new Expression(func.getText().toString());
        BigDecimal x0 = BigDecimal.valueOf(-10d), x1 = null;
        BigDecimal delta = BigDecimal.valueOf(0.05);
        for (int i = 0; i < 1000; i++){
            double x = x0.add(delta.multiply(BigDecimal.valueOf((double)i))).doubleValue();
            try{
                expr.with("x", BigDecimal.valueOf(x)).eval();
                x1 = BigDecimal.valueOf(x);
                System.out.println("Okay" + x);
                break;
            } catch (Exception e){
                //
            }
            System.out.println(x);
        }
        if (x1 != null) {
            //If it gets here it means the expression can be successfully evaluated.
            Intent i = new Intent(this, GraphActivity.class);
            i.putExtra("equation", func.getText().toString());
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
