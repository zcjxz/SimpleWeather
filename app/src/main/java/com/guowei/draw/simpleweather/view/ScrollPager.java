package com.guowei.draw.simpleweather.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;


public class ScrollPager extends ViewPager{
    private float posX;
    private float posY;
    public ScrollPager(Context context) {
        super(context);
    }

    public ScrollPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                posX=ev.getX();
                posY=ev.getY();
                return true;
            case MotionEvent.ACTION_MOVE:
                float dx = ev.getX() - posX;
                float dy = ev.getY() - posY;
                if (dy>dx){
                    return false;
                }else{
                    return true;
                }
        }
        return super.onTouchEvent(ev);
    }
}
