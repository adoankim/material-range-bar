package com.appyvet.rangebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.TypedValue;

/**
 * @author dkc.adam@gmail.com.
 */

public class BubbleBar extends Bar {
    /**
     * Bar constructor
     *
     * @param ctx          the context
     * @param x            the start x co-ordinate
     * @param y            the y co-ordinate
     * @param length       the length of the bar in px
     * @param tickCount    the number of ticks on the bar
     * @param tickHeightDP the height of each tick
     * @param tickColor    the color of each tick
     * @param barWeight    the weight of the bar
     * @param barColor     the color of the bar
     */
    public BubbleBar(Context ctx, float x, float y, float length, int tickCount, float tickHeightDP, int tickColor, float barWeight, int barColor) {
        super(ctx, x, y, length, tickCount, tickHeightDP, tickColor, getDP(ctx, barWeight), barColor);
    }

    private static float getDP(Context ctx, float barWeight) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                barWeight,
                ctx.getResources().getDisplayMetrics());
    }

    @Override
    protected Paint setupBarPaint(int barColor, float barWeight) {
        Paint paint = new Paint();
        paint.setColor(barColor);
        paint.setStrokeWidth(barWeight);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        return paint;
    }

    @Override
    public void draw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(getLeftX() - 75, getBarY() - 75, getRightX() + 75, getBarY() + 75, 100, 100, getBarPaint());
        }
    }
}
