package com.example.grapoffline;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Graph extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;
    String input_function = "x", color = "Blue";
    int flag, from, to;
    double r = 0, y = 0, x, a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph);
        input_function = getIntent().getExtras().getString("Input function");
        flag = getIntent().getExtras().getInt("Flag");
        from = getIntent().getExtras().getInt("From");
        to = getIntent().getExtras().getInt("To");
        color = getIntent().getExtras().getString("Color");
        MathParser p = new MathParser();
        GraphView graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        x = from;
        switch (color) {
            case "Blue":
                series.setColor(Color.BLUE);
                break;
            case "Red":
                series.setColor(Color.RED);
                break;
            case "Yellow":
                series.setColor(Color.YELLOW);
                break;
            case "Green":
                series.setColor(Color.GREEN);
                break;
        }
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(from);
        graph.getViewport().setMaxX(to);
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);
        for (int i = 0; i < (Math.abs(from) + Math.abs(to)) * 100; i++) {
            if (flag == 0) {
                x += 0.01;
                p.setVariable("x", x);
                try {
                    y = p.Parse(input_function);
                    if (p.flag_err == 1) {
                        p.flag_err = 0;
                        continue;
                    }
                } catch (Exception e) {
                    System.err.println("Error while parsing '" + input_function + "' with message: " + e.getMessage());
                }
            } else if (flag == 1) {
                a += 0.01;
                p.setVariable("α", a);
                try {
                    r = p.Parse(input_function + "+0");
                    y = r * Math.sin(a);
                    x = r * Math.cos(a);

                    if (p.flag_err == 1) {
                        p.flag_err = 0;
                        continue;
                    }
                } catch (Exception e) {
                    System.err.println("Error while parsing '" + input_function + "' with message: " + e.getMessage());
                }
            }
            series.appendData(new DataPoint(x, y), true, (Math.abs(from) + Math.abs(to)) * 100);
        }
        graph.addSeries(series);
    }
}