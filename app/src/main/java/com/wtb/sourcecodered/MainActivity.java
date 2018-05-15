package com.wtb.sourcecodered;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wtb.sourcecodered.layoutmanager.SampleActivity;

public class MainActivity extends AppCompatActivity {
    Button layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutManager = findViewById(R.id.layout_manager);
        layoutManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SampleActivity.class));
            }
        });
        Button sys = findViewById(R.id.layout_manager_sys);
        sys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, com.wtb.sourcecodered.layoutmanagersys.SampleActivity.class));
            }
        });
    }
}
