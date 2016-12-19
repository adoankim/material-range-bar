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
import android.util.AttributeSet;

public class BubbleRangeBar extends RangeBar {
    private static final int BUBBLE_BAR_MARGIN = 50;

    public BubbleRangeBar(Context context) {
        super(context);
    }

    public BubbleRangeBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BubbleRangeBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected float getMarginLeft() {
        return super.getMarginLeft() + BUBBLE_BAR_MARGIN;
    }

    @Override
    protected Bar buildBar() {
        return new BubbleBar(getContext(),
                getMarginLeft(),
                getYPos(),
                getBarLength(),
                getTickCount(),
                getTickHeightDP(),
                getTickColor(),
                getBarWeight(),
                getBarColor());
    }

    @Override
    protected PinView buildPin() {
        return new BubblePinView(getContext());
    }
}
