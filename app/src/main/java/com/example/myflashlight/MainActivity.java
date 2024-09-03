package com.example.myflashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_result;
    Switch swOnOff;
    CameraManager cameraManager;
    String cameraid,result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swOnOff = findViewById(R.id.swOnOff);
        tv_result = findViewById(R.id.tvBoolean);
        swOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                torch(b);

            }
        });
    }
    private void torch(boolean isChecked) {
        try {
            cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
            cameraid = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraid,isChecked);
            result = isChecked ? "ON" : "OFF";
            tv_result.setText(result);
        }
        catch (CameraAccessException e){

        }


    }
}