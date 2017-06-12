package co.edu.eafit.an.onevar;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.udojava.evalex.Expression;

import java.math.BigDecimal;

import co.edu.eafit.an.R;

public class GraphActivity extends AppCompatActivity {

    GraphView gv;
    Expression expr;
    DataPoint dps[];
    BigDecimal delta;
    LineGraphSeries ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        gv = (GraphView) findViewById(R.id.graph);
        Intent intent = getIntent();
        expr = new Expression(intent.getStringExtra("equation"));
        BigDecimal x0 = new BigDecimal(-10d), x1 = null;
        delta = new BigDecimal(0.05);
        for (int i = 0; i < 1000; i++){
            double x = x0.add(delta.multiply(BigDecimal.valueOf((double)i))).doubleValue();
            try{
                expr.with("x", BigDecimal.valueOf(x)).eval();
                x1 = BigDecimal.valueOf(x);
                break;
            } catch (Exception e){
                //
            }
            System.out.println(x);
        }
        if (x1 != null) x0 = x1;
        dps = new DataPoint[400];
        double highest = 0.0d, lowest = 0.0d;
        for (int i = 0; i < 400; i++){
            try{
                double x = x0.add(delta.multiply(BigDecimal.valueOf((double)i))).doubleValue(), y = expr.with("x",BigDecimal.valueOf(x)).eval().doubleValue();
                dps[i] = new DataPoint(x, y);
                if(y > highest) highest = y;
                if(y < lowest) lowest = y;
            } catch (Exception e){
                dps[i] = null;
            }
        }
        ls = new LineGraphSeries(dps);
        gv.addSeries(ls);
        gv.getViewport().setXAxisBoundsManual(true);
        gv.getViewport().setMinX(x0.doubleValue());
        gv.getViewport().setMaxX(x0.doubleValue() + 20d);
        gv.getViewport().setMaxY(highest);
        gv.getViewport().setMinY(lowest);
    }
}
