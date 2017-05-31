package co.edu.eafit.an.diff.methods;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

import co.edu.eafit.an.R;
import co.edu.eafit.an.diff.util.Utils;

public class TwoPointActivity extends AppCompatActivity {

    Button x0_btn, x1_btn;
    EditText res_et;
    TextView res_tv;

    double y[], x[], h, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_point);
        Intent intent = getIntent();
        x = (double[])intent.getExtras().getSerializable("x");
        y = (double[])intent.getExtras().getSerializable("y");
        h = Math.abs(intent.getExtras().getDouble("h"));
        res_et = (EditText)findViewById(R.id.two_point_diff_res_et);
        res_tv = (TextView)findViewById(R.id.two_point_diff_res_tv);
        String s = BigDecimal.valueOf(x[0]).setScale(6, BigDecimal.ROUND_HALF_UP).toString() + "...";
        x0_btn = (Button)findViewById(R.id.two_point_diff_x0_btn);
        x0_btn.setText(s);
        s = BigDecimal.valueOf(x[1]).setScale(6, BigDecimal.ROUND_HALF_UP).toString() + "...";
        x1_btn = (Button)findViewById(R.id.two_point_diff_x1_btn);
        x1_btn.setText(s);
    }

    public void x0(View v){
        res = Utils.twoPointDiffForward(h,y);
        Log.d("RES", Double.toString(res));
        res_et.setText(Double.toString(res));

    }

    public void x1(View v){
        res = Utils.twoPointDiffForward(-h,y);
        Log.d("RES", Double.toString(res));
        res_et.setText(Double.toString(res));
    }
}
