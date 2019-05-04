package com.example.daily_page;

import android.graphics.Color;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Chronometer;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.github.mikephil.charting.utils.ColorTemplate.VORDIPLOM_COLORS;


public class MainActivity extends AppCompatActivity  {
    long now = System.currentTimeMillis();
    Date date = new Date(now);
    SimpleDateFormat sdfNow = new SimpleDateFormat("MM/dd");
    String formatDate = sdfNow.format(date);
    TextView dateNow;
    Chronometer mChronometer;
    PieChart pieChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //날짜 표시
        dateNow = (TextView) findViewById(R.id.dataNow);
        dateNow.setText(formatDate);

        //차트

        pieChart = (PieChart)findViewById(R.id.piechart);

        pieChart.setUsePercentValues(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        // pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();

        yValues.add(new PieEntry(20f,"수면"));
        yValues.add(new PieEntry(20f,"일"));
        yValues.add(new PieEntry(20f,"공부"));
        yValues.add(new PieEntry(20f,"자기계발"));
        yValues.add(new PieEntry(20f,"여가"));




        PieDataSet dataSet = new PieDataSet(yValues, "");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(VORDIPLOM_COLORS);



        PieData data = new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.WHITE);

        pieChart.setData(data);

        //스톱워치
        mChronometer = (Chronometer)findViewById(R.id.chronometer_view);

        Button startBtn = (Button) findViewById(R.id.start_button);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChronometer.setBase(SystemClock.elapsedRealtime());
                mChronometer.start();
            }
        });
    }

}