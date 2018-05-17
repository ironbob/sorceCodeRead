package com.wtb.sourcecodered.dispatchevent;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.wtb.sourcecodered.R;
import com.wtb.sourcecodered.horizontallistview.HorizontalListView;
import com.wtb.sourcecodered.recyclerview.RecyclerView;

/**
 * Created by baobaowang on 2018/5/16.
 */
public class ClickThroughLayout extends RelativeLayout {
    String TAG = "ClickThroughLayout";
    View test;
    RecyclerView recyclerview;
    public ClickThroughLayout(Context context) {
        this(context,null);
    }

    public ClickThroughLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        test = findViewById(R.id.test_click);
        recyclerview = findViewById(R.id.recycler_view);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    boolean hasDispatchDownEvent = false;
    boolean needReDispatch;
    Rect mImageRect = new Rect();

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean handle = false;
        int action = ev.getAction();
        if(action == MotionEvent.ACTION_DOWN){
            test.getHitRect(mImageRect);
            int x = (int) ev.getX();
            int y = (int) ev.getY();
            if(mImageRect.contains(x,y)){
                handle= super.dispatchTouchEvent(ev);
                if(handle){
                    needReDispatch = true;
                }else{
                    needReDispatch = false;
                }
            }else{
                handle= super.dispatchTouchEvent(ev);
                needReDispatch = false;
            }
            hasDispatchDownEvent = false;
        }else{
            handle= super.dispatchTouchEvent(ev);
        }
        if(needReDispatch && !test.isPressed() && recyclerview!=null){
            if(!hasDispatchDownEvent) {
                MotionEvent downEvent = MotionEvent.obtain(ev);
                downEvent.setAction(MotionEvent.ACTION_DOWN);
                recyclerview.onTouchEvent(downEvent);
                hasDispatchDownEvent = true;
            }
            recyclerview.onTouchEvent(ev);
        }
        return handle;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
    }
}
