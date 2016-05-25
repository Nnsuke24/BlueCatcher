package com.nnsuke.bluecatcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.nnsuke.bluecatcher.domain.ScanManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onChangeScanToggle();

    }

    public void onChangeScanToggle(){
        ToggleButton scan_toggle = (ToggleButton)findViewById(R.id.scan_toggle);
        scan_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // OFF→ON

                    ScanManager scanManager = new ScanManager(MainActivity.this);
                    scanManager.startScan();


                } else {
                    // ON→OFF
                }
            }
        });

    }
}
