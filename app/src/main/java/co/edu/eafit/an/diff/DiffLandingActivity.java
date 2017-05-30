package co.edu.eafit.an.diff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import co.edu.eafit.an.R;
import co.edu.eafit.an.diff.methods.FivePointDiffActivity;
import co.edu.eafit.an.diff.methods.ThreePointDiffActivity;
import co.edu.eafit.an.diff.methods.TwoPointActivity;

public class DiffLandingActivity extends AppCompatActivity {

    Button two_btn, three_btn, five_btn, back_btn, insert_btn;
    EditText h_et, elem_et;
    TextView elemhelp_tv, elem_tv;
    int i, n;
    double h, x[], y[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diff_landing);
        two_btn = (Button)findViewById(R.id.diff_two_btn);
        three_btn = (Button)findViewById(R.id.diff_three_btn);
        five_btn = (Button)findViewById(R.id.diff_five_btn);
        back_btn = (Button)findViewById(R.id.diff_back);
        insert_btn = (Button)findViewById(R.id.diff_insertbtn);
        h_et = (EditText)findViewById(R.id.diff_h_et);
        elem_et = (EditText)findViewById(R.id.diff_elem_et);
        elemhelp_tv = (TextView)findViewById(R.id.diff_elemhelp_tv);
        elem_tv = (TextView)findViewById(R.id.diff_elem_tv);
        i = -1;
    }

    public void two(View v){
        h = Double.parseDouble(h_et.getText().toString());
        two_btn.setEnabled(false);
        three_btn.setEnabled(false);
        five_btn.setEnabled(false);
        back_btn.setVisibility(View.VISIBLE);
        insert_btn.setVisibility(View.VISIBLE);
        h_et.setEnabled(false);
        elem_et.setVisibility(View.VISIBLE);
        elemhelp_tv.setVisibility(View.VISIBLE);
        elem_tv.setVisibility(View.VISIBLE);
        elem_et.requestFocus();
        x = new double[2];
        y = new double[2];
        n = 2;
        if (h < 0) {
            String s = "x1 =";
            elem_tv.setText(s);
        }

    }

    public void three(View v){
        h = Double.parseDouble(h_et.getText().toString());
        two_btn.setEnabled(false);
        three_btn.setEnabled(false);
        five_btn.setEnabled(false);
        back_btn.setVisibility(View.VISIBLE);
        insert_btn.setVisibility(View.VISIBLE);
        h_et.setEnabled(false);
        elem_et.setVisibility(View.VISIBLE);
        elemhelp_tv.setVisibility(View.VISIBLE);
        elem_tv.setVisibility(View.VISIBLE);
        elem_et.requestFocus();
        x = new double[3];
        y = new double[3];
        n = 3;
        if(h < 0) {
            String s = "x2 =";
            elem_tv.setText(s);
        }
    }

    public void five(View v){
        h = Double.parseDouble(h_et.getText().toString());
        two_btn.setEnabled(false);
        three_btn.setEnabled(false);
        five_btn.setEnabled(false);
        back_btn.setVisibility(View.VISIBLE);
        insert_btn.setVisibility(View.VISIBLE);
        h_et.setEnabled(false);
        elem_et.setVisibility(View.VISIBLE);
        elemhelp_tv.setVisibility(View.VISIBLE);
        elem_tv.setVisibility(View.VISIBLE);
        elem_et.requestFocus();
        x = new double[5];
        y = new double[5];
        n = 5;
        if (h < 0){
            String s = "x4 =";
            elem_tv.setText(s);
        }
    }

    public void back(View v){

    }

    public void insert(View v){
        String s;
        double val = Double.parseDouble(elem_et.getText().toString());
        if(i < 0){
            if (h > 0){
                x[i+1] = val;
                for (int j = i + 1; j < n; j++){
                    x[j] = x[i+1] + (j * h);
                }
                s = "f(x0) = ";
            } else {
                x[n-1] = val;
                for (int j = n - 2; j > -1; j--){
                    x[j] = x[i+1] + (j+1 * h);
                }
                s = "f(x0) = ";
            }
            elem_tv.setText(s);
            elem_et.setText("");
            i++;
        } else if (i < n){
            s = "f(x"+(i+1)+") =";
            elem_tv.setText(s);
            elem_et.setText("");
            y[i] = val;
            i++;
            if (i == n){
                Intent intent = null;
                switch(n){
                    case 5:{
                        intent = new Intent(this, FivePointDiffActivity.class);
                        break;
                    }
                    case 3:{
                        intent = new Intent(this, ThreePointDiffActivity.class);
                        break;
                    }
                    case 2:{
                        intent = new Intent(this, TwoPointActivity.class);
                        break;
                    }
                }
                Bundle b = new Bundle();
                b.putSerializable("x",x);
                b.putSerializable("y",y);
                b.putDouble("h",h);
                intent.putExtras(b);
                startActivity(intent);
            }
        }
    }
}
