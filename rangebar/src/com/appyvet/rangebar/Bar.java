/*
 * Copyright 2013, Edmodo, Inc. 
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License.
 * You may obtain a copy of the License in the LICENSE file, or at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" 
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language 
 * governing permissions and limitations under the License. 
 */

package com.appyvet.rangebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.TypedValue;

/**
 * This class represents the underlying gray bar in the RangeBar (without the
 * thumbs).
 */
public class Bar {

    // Member Variables ////////////////////////////////////////////////////////
    private final RectF mBoundRect;
    private final Paint mBoundRectPaint;
    private final float mBarRoundRatio;
    // Left-coordinate of the horizontal bar.
    private final float mLeftX;

    private final float mRightX;

    private final float mY;

    private int mNumSegments;

    private float mTickDistance;


    // Constructor /////////////////////////////////////////////////////////////


    /**
     * Bar constructor
     *
     * @param x             the start x co-ordinate
     * @param y             the y co-ordinate
     * @param length        the length of the bar in px
     * @param tickCount     the number of ticks on the bar
     * @param barColor      the color of the bar
     * @param barPadding    the padding of the bar
     * @param barStroke     the stroke size of the bar
     * @param barRoundRatio the round edges ratio of the bar
     */
    public Bar(float x,
            float y,
            float length,
            int tickCount,
            float barPadding,
            float barStroke,
            float barRoundRatio,
            int barColor) {

        mLeftX = x;
        mRightX = x + length;
        mY = y;
        mBarRoundRatio = barRoundRatio;

        mNumSegments = tickCount - 1;
        mTickDistance = length / mNumSegments;

        mBoundRectPaint = new Paint();
        mBoundRectPaint.setColor(barColor);
        mBoundRectPaint.setStrokeWidth(barStroke);
        mBoundRectPaint.setAntiAlias(true);
        mBoundRectPaint.setStyle(Paint.Style.STROKE);

        mBoundRect = new RectF(mLeftX - barPadding/2.0f,
                mY - barPadding/2.0f,
                mRightX + barPadding/2.0f,
                mY + barPadding/2.0f);
    }

    // Package-Private Methods /////////////////////////////////////////////////

    /**
     * Draws the bar on the given Canvas.
     *
     * @param canvas Canvas to draw on; should be the Canvas passed into {#link
     *               View#onDraw()}
     */
    public void draw(Canvas canvas) {

        canvas.drawRoundRect(mBoundRect, mBarRoundRatio, mBarRoundRatio, mBoundRectPaint);
    }

    /**
     * Get the x-coordinate of the left edge of the bar.
     *
     * @return x-coordinate of the left edge of the bar
     */
    public float getLeftX() {
        return mLeftX;
    }

    /**
     * Get the x-coordinate of the right edge of the bar.
     *
     * @return x-coordinate of the right edge of the bar
     */
    public float getRightX() {
        return mRightX;
    }

    /**
     * Gets the x-coordinate of the nearest tick to the given x-coordinate.
     *
     * @param thumb the thumb to find the nearest tick for
     * @return the x-coordinate of the nearest tick
     */
    public float getNearestTickCoordinate(PinView thumb) {

        final int nearestTickIndex = getNearestTickIndex(thumb);

        return mLeftX + (nearestTickIndex * mTickDistance);
    }

    /**
     * Gets the zero-based index of the nearest tick to the given thumb.
     *
     * @param thumb the Thumb to find the nearest tick for
     * @return the zero-based index of the nearest tick
     */
    public int getNearestTickIndex(PinView thumb) {

        return (int) ((thumb.getX() - mLeftX + mTickDistance / 2f) / mTickDistance);
    }
}
