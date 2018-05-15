package com.wtb.sourcecodered.layoutmanager;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wtb.sourcecodered.R;
import com.wtb.sourcecodered.recyclerview.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ToggleButton;


/**
 * Created by Julian Villella on 16-02-24.
 */
public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }

        PhotosAdapter photosAdapter = new PhotosAdapter(this);
        final GreedoLayoutManager layoutManager = new GreedoLayoutManager(photosAdapter);
        layoutManager.setMaxRowHeight(MeasUtils.dpToPx(150, this));

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(photosAdapter);
        int spacing = MeasUtils.dpToPx(4, this);
        recyclerView.addItemDecoration(new GreedoSpacingItemDecoration(spacing));
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0,50);
        findViewById(R.id.toggle_fixed_height).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutManager.setFixedHeight(((ToggleButton) view).isChecked());
                layoutManager.requestLayout();
            }
        });
    }
}
