package com.wtb.sourcecodered.scrollview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wtb.sourcecodered.R;

/**
 * Created by baobaowang on 2018/5/17.
 */
public class ActivityScrollView extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
    }
}
