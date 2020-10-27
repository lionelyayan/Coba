package com.example.coba;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barChart = findViewById(R.id.chart);

        setChart();
    }

    private void setChart() {
        float groupSpace = 0.2f;
        float barSpace = 0f;
        float barWidth = 0.2f;

        List<BarEntry> penjualan = new ArrayList<>();
        List<BarEntry> piutang = new ArrayList<>();
        List<BarEntry> overdue = new ArrayList<>();
        List<BarEntry> total_bayar = new ArrayList<>();
        ArrayList<String> bulan = new ArrayList<>();
        bulan.add("Jan");
        bulan.add("Feb");
        bulan.add("Mar");
        bulan.add("Apr");
        bulan.add("Mei");
        bulan.add("Jun");
        bulan.add("Jul");
        bulan.add("Agt");
        bulan.add("Sep");
        bulan.add("Okt");
        bulan.add("Nov");
        bulan.add("Des");

        for (int i=0; i<12; i++) {
            penjualan.add(new BarEntry(i, Float.parseFloat(String.valueOf(100000))));
            piutang.add(new BarEntry(i, Float.parseFloat(String.valueOf(200000))));
            overdue.add(new BarEntry(i, Float.parseFloat(String.valueOf(400000))));
            total_bayar.add(new BarEntry(i, Float.parseFloat(String.valueOf(300000))));
        }

        BarDataSet dataSet1 = new BarDataSet(penjualan, "Penjualan");
        dataSet1.setColor(getResources().getColor(R.color.colorAccent));
        BarDataSet dataSet2 = new BarDataSet(piutang, "Piutang");
        dataSet2.setColor(getResources().getColor(R.color.colorPrimary));
        BarDataSet dataSet3 = new BarDataSet(overdue, "Overdue");
        dataSet3.setColor(getResources().getColor(R.color.colorAccent1));
        BarDataSet dataSet4 = new BarDataSet(total_bayar, "Total Bayar");
        dataSet4.setColor(getResources().getColor(R.color.colorAccent2));

        barChart.animateY(2000);

        BarData barData = new BarData(dataSet1, dataSet2, dataSet3, dataSet4);
        barChart.setData(barData);
        barData.setDrawValues(false);
        barData.setBarWidth(barWidth);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(bulan));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularityEnabled(true);
        xAxis.setGranularity(0f);

        barChart.getAxisRight().setDrawLabels(false);
        barChart.getDescription().setEnabled(false);
        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMaximum(6);
        barChart.getXAxis().setAxisMinimum(0);
        barChart.getXAxis().setAxisMaximum(barChart.getBarData().getGroupWidth(groupSpace, barSpace) * 12);
        barChart.groupBars(0f, groupSpace, barSpace);
        barChart.getXAxis().setCenterAxisLabels(true);

        barChart.invalidate();
    }
}
