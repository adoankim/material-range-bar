package com.appyvet.rangebar;

import android.content.Context;
import android.graphics.Canvas;

/**
 * @author dkc.adam@gmail.com.
 */

public class BubblePinView extends PinView {
    private static final float DEFAULT_TEXT_Y_PADDING = -4f;

    public BubblePinView(Context context) {
        super(context);
    }

    protected float getTextYPadding() {
        return DEFAULT_TEXT_Y_PADDING;
    }

    @Override
    protected void drawPin(Canvas canvas) {
        //Avoid draw pin view
    }
}
