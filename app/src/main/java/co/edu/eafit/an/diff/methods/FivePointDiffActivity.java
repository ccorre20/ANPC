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
import java.util.Arrays;

import co.edu.eafit.an.R;
import co.edu.eafit.an.diff.util.Utils;

public class FivePointDiffActivity extends AppCompatActivity {
    
    Button x0_btn, x1_btn, x2_btn, x3_btn, x4_btn;
    EditText res_et;
    TextView res_tv;

    double y[], x[], h, res;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_point_diff);
        Intent intent = getIntent();
        x = (double[])intent.getExtras().getSerializable("x");
        y = (double[])intent.getExtras().getSerializable("y");
        h = Math.abs(intent.getExtras().getDouble("h"));
        res_et = (EditText)findViewById(R.id.five_point_diff_res_et);
        res_tv = (TextView)findViewById(R.id.five_point_diff_res_tv);
        String s = BigDecimal.valueOf(x[0]).setScale(6, BigDecimal.ROUND_HALF_UP).toString() + "...";
        x0_btn = (Button)findViewById(R.id.five_point_diff_x0_btn);
        x0_btn.setText(s);
        s = BigDecimal.valueOf(x[1]).setScale(6, BigDecimal.ROUND_HALF_UP).toString() + "...";
        x1_btn = (Button)findViewById(R.id.five_point_diff_x1_btn);
        x1_btn.setText(s);
        s = BigDecimal.valueOf(x[2]).setScale(6, BigDecimal.ROUND_HALF_UP).toString() + "...";
        x2_btn = (Button)findViewById(R.id.five_point_diff_x2_btn);
        x2_btn.setText(s);
        s = BigDecimal.valueOf(x[3]).setScale(6, BigDecimal.ROUND_HALF_UP).toString() + "...";
        x3_btn = (Button)findViewById(R.id.five_point_diff_x3_btn);
        x3_btn.setText(s);
        s = BigDecimal.valueOf(x[4]).setScale(6, BigDecimal.ROUND_HALF_UP).toString() + "...";
        x4_btn = (Button)findViewById(R.id.five_point_diff_x4_btn);
        x4_btn.setText(s);
    }

    public void x0(View v){
        res = Utils.fivePointDiffForward(h,y);
        Log.d("RES", Double.toString(res));
        res_et.setText(Double.toString(res));
    }

    public void x1(View v){
        res = Utils.threePointDiffForward(h, Arrays.copyOfRange(y,1,4));
        Log.d("RES", Double.toString(res));
        res_et.setText(Double.toString(res));
    }

    public void x2(View v){
        res = Utils.fivePointDiffCenter(h, y);
        Log.d("RES", Double.toString(res));
        res_et.setText(Double.toString(res));
    }

    public void x3(View v){
        res = Utils.threePointDiffForward(-h,Arrays.copyOfRange(y,1,4));
        Log.d("RES", Double.toString(res));
        res_et.setText(Double.toString(res));
    }

    public void x4(View v){
        res = Utils.fivePointDiffForward(-h,y);
        Log.d("RES", Double.toString(res));
        res_et.setText(Double.toString(res));
    }
}
