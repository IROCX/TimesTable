package com.example.timestable;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    int y;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Integer[] x = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        ArrayList<Integer> arrayListInit = new ArrayList();
        arrayListInit.addAll(Arrays.asList(x));
        final ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, arrayListInit);


        final TextView textView = findViewById(R.id.textView);
        final ListView listView = findViewById(R.id.LV);
        listView.setAdapter(arrayAdapter);

        final SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setProgress(10, true);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                y = i + 1;
                textView.setText((i + 1) + "");
                ArrayList<Integer> arrayList = new ArrayList();
                for (int z = 0; z < 10; z++) {
                    arrayList.add(y * (z + 1));
                }
//                Log.i("TAG", arrayList.toString());
                final ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//
            }
        });


    }
}
