package com.example.latihanmultipleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String statusSwich = "zakat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchProductCatagory();

    }

    private void switchProductCatagory() {
        final Switch cSwitch = findViewById(R.id.cSwitch);
        final TextView cSwitch_Kiri = findViewById(R.id.cSwitch_Kiri);
        final TextView cSwitch_Kanan = findViewById(R.id.cSwitch_Kanan);
        cSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ConstraintLayout constraintLayout = findViewById(R.id.layoutSwichProductCode);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(constraintLayout);
                constraintSet.connect(R.id.cSwitch_Kiri, ConstraintSet.TOP, R.id.cSwitch, ConstraintSet.TOP, 0);
                constraintSet.connect(R.id.cSwitch_Kiri, ConstraintSet.BOTTOM, R.id.cSwitch, ConstraintSet.BOTTOM, 0);
                cSwitch.setThumbDrawable(getResources().getDrawable(R.drawable.switch_thumb));

                if (isChecked) {
                    statusSwich = "kiri";
                    cSwitch_Kiri.setTextColor(getApplication().getResources().getColor(R.color.black404040));
                    cSwitch_Kanan.setTextColor(getApplication().getResources().getColor(R.color.white));
                    cSwitch.setTrackDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.switch_track));
                } else {
                    statusSwich = "kanan";
                    cSwitch_Kiri.setTextColor(getApplication().getResources().getColor(R.color.white));
                    cSwitch_Kanan.setTextColor(getApplication().getResources().getColor(R.color.black404040));
                    cSwitch.setTrackDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.switch_track));
                    cSwitch.setThumbDrawable(getResources().getDrawable(R.drawable.switch_thumb));
                }
                constraintSet.applyTo(constraintLayout);
                Toast.makeText(MainActivity.this, "Kamu memilih" + statusSwich, Toast.LENGTH_LONG).show();

            }
        });
    }
}
