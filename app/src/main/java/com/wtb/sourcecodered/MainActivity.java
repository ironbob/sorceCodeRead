package com.wtb.sourcecodered;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wtb.sourcecodered.layoutmanager.SampleActivity;
import com.wtb.sourcecodered.scrollview.ActivityScrollView;
import com.wtb.sourcecodered.viewdraghelper.ActivityViewDrag;

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
        Button sys = findViewById(R.id.view_drag);
        sys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityViewDrag.class));
            }
        });
        findViewById(R.id.scroll_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityScrollView.class));
            }
        });
    }
}
