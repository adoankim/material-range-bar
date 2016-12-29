package com.appyvet.rangebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;

/**
 * @author dkc.adam@gmail.com.
 */

public class LegendText {
    private final static float DEFAULT_LABEL_SIZE = 16f;
    private final static int DEFAULT_LABEL_COLOR = 0xCC000000;
    private final static int LEGEND_DEFAULT_X_PADDING = 68;
    private final static int LEGENT_DEFAULT_BOTTOM_MARGIN = 8;
    private final Paint mPaint;
    private float mX = 0;
    private float mY = 0;
    private String mLabel = "";

    public LegendText(Context context) {
        mPaint = new Paint(0);

        mPaint.setTextSize(getSP(context, DEFAULT_LABEL_SIZE));
        mPaint.setColor(DEFAULT_LABEL_COLOR);
        mPaint.setAntiAlias(true);
    }

    public LegendText(Context context, AttributeSet attrs) {
        mPaint = new Paint(0);
        initializeLegendAttributes(context, attrs);
        mPaint.setAntiAlias(true);
    }

    private void initializeLegendAttributes(Context context, AttributeSet attrs) {

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BubbleRangeBar, 0, 0);
        try {
            final float labelTextSize = ta
                    .getDimensionPixelSize(R.styleable.BubbleRangeBar_legendTextSize, (int)DEFAULT_LABEL_SIZE);
            final int labelTextColor = ta
                    .getColor(R.styleable.BubbleRangeBar_legendColor, DEFAULT_LABEL_COLOR);
            mPaint.setTextSize(getSP(context, labelTextSize));
            mPaint.setColor(labelTextColor);
        }finally {
            ta.recycle();
        }
    }

    public void setX(float x){
        mX = x + LEGEND_DEFAULT_X_PADDING;
    }

    public void setY(float y){
        mY = y - LEGENT_DEFAULT_BOTTOM_MARGIN;
    }

    public void setLabel(String label){
        mLabel = label;
    }

    public void draw(Canvas canvas){
        canvas.drawText(mLabel, mX, mY, mPaint);
    }

    private static float getSP(Context ctx, float spValue) {
        return spValue * ctx.getResources().getDisplayMetrics().density;
    }
}
