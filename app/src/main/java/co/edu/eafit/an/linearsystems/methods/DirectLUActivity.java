package co.edu.eafit.an.linearsystems.methods;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import co.edu.eafit.an.R;
import co.edu.eafit.an.linearsystems.util.Utils;

public class DirectLUActivity extends AppCompatActivity {

    double a[][], b[];
    int choice;

    Button bdoolitle, bcroutl, bcholesky, brun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_lu);
        Intent intent = getIntent();
        a = (double[][]) intent.getExtras().getSerializable("a");
        b = (double[]) intent.getExtras().getSerializable("b");
        bdoolitle = (Button)findViewById(R.id.direct_lu_doolitle);
        bcroutl = (Button)findViewById(R.id.direct_lu_croult);
        bcholesky = (Button)findViewById(R.id.direct_lu_cholesky);
        brun = (Button)findViewById(R.id.direct_lu_run);
    }

    public void doolitle(View v){
        choice = 1;
        brun.setEnabled(true);
        bdoolitle.setEnabled(false);
        bcroutl.setEnabled(true);
        bcholesky.setEnabled(true);
    }

    public void croult(View v){
        choice = 2;
        brun.setEnabled(true);
        bdoolitle.setEnabled(true);
        bcroutl.setEnabled(false);
        bcholesky.setEnabled(true);
    }

    public void cholesky(View v){
        choice = 3;
        brun.setEnabled(true);
        bdoolitle.setEnabled(true);
        bcroutl.setEnabled(true);
        bcholesky.setEnabled(false);
    }

    public void runDirectLU(View v){
        Utils.LU mlu;
        switch(choice){
            default:
            case 1:{
                mlu = Utils.LUDoolitle(a);
                break;
            }
            case 2:{
                mlu = Utils.LUCroult(a);
                break;
            }
            case 3:{
                mlu = Utils.LUCholesky(a);
                break;
            }
        }
        double z[] = Utils.progressiveSubstitution(Utils.augmentMatrix(mlu.L,b));
        double x[] = Utils.regressiveSubstitution(Utils.augmentMatrix(mlu.U,z));
        Log.d("XOUTPUT",x.toString());
    }
}
