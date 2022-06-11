package app.flix.free;

import androidx.viewpager.widget.*;
import android.content.*;
import android.view.MotionEvent;
import android.util.*;

public class CustomViewPager extends ViewPager {

    private boolean isPageScrollEnabled = false;
    
    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isPageScrollEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isPageScrollEnabled && super.onInterceptTouchEvent(event);
    }

    public void setPageScrollEnabled(boolean isPageScrollEnabled) {
        this.isPageScrollEnabled = isPageScrollEnabled;
    }
}