package app.flix.free;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * A custom GridView which can wrap content.
 */
public class WrapGridView extends GridView {

    public WrapGridView(Context context) {
        super(context);
    }

    public WrapGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WrapGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /*
     * http://www.jayway.com/2012/10/04/how-to-make-the-height-of-a-gridview-wrap
     * -its-content/
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightSpec;
        if (getLayoutParams().height == LayoutParams.WRAP_CONTENT) {
            // The great Android "hackatlon", the love, the magic.
            // The two leftmost bits in the height measure spec have
            // a special meaning, hence we can't use them to describe height.
            heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        } else {
            // Any other height should be respected as is.
            heightSpec = heightMeasureSpec;
        }

        super.onMeasure(widthMeasureSpec, heightSpec);
    }

}