package com.wtb.sourcecodered.dispatchevent;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by baobaowang on 2018/5/16.
 */
public class ClickThroughImageView extends ImageView {
    public ClickThroughImageView(Context context) {
        this(context,null);
    }

    public ClickThroughImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if(action == MotionEvent.ACTION_DOWN){
            Log.i("ClickThroughImageView","ACTION_DOWN");
            return super.onTouchEvent(event);
        }else if(action == MotionEvent.ACTION_MOVE){
            Log.i("ClickThroughImageView","ACTION_MOVE");
            return super.onTouchEvent(event);
        }else{
            Log.i("ClickThroughImageView","ACTION_OTHER = "+action);
            return super.onTouchEvent(event);
        }
    }
}
