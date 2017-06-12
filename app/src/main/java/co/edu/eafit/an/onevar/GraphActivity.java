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
        delta = new BigDecimal(0.05);
        dps = new DataPoint[400];
        BigDecimal x0 = new BigDecimal(-10d);
        double highest = 0.0d, lowest = 0.0d;
        for (int i = 0; i < 400; i++){
            double x = x0.add(delta.multiply(BigDecimal.valueOf((double)i))).doubleValue(), y = expr.with("x",BigDecimal.valueOf(x)).eval().doubleValue();
            dps[i] = new DataPoint(x, y);
            if(y > highest) highest = y;
            if(y < lowest) lowest = y;
        }
        ls = new LineGraphSeries(dps);
        gv.addSeries(ls);
        gv.getViewport().setXAxisBoundsManual(true);
        gv.getViewport().setMinX(-10d);
        gv.getViewport().setMaxX(10d);
        gv.getViewport().setMaxY(highest);
        gv.getViewport().setMinY(lowest);
    }
}
