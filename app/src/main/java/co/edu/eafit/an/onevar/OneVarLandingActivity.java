package co.edu.eafit.an.onevar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

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
        try {
            Expression expr = new Expression(func.getText().toString());
            BigDecimal d = expr.with("x", BigDecimal.ZERO).eval();
            Log.d("TEST",expr.toString());
            Log.d("Testing expression", d.toString());
            BigDecimal e = expr.with("x", BigDecimal.ONE).eval();
            Log.d("TEST",expr.toString());
            Log.d("Testing expression", e.toString());
            //If it gets here it means the expression can be successfully evaluated.
            Intent i = new Intent(this, OneVarChooseMethodActivity.class);
            i.putExtra("equation", func.getText().toString());
            startActivity(i);
        }catch (Expression.ExpressionException e){
            e.printStackTrace();
        }
    }
}
