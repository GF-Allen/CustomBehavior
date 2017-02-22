package com.alenbeyond.custombehavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by alen on 17/2/21.
 */

public class CustomBehavior extends CoordinatorLayout.Behavior<ImageView> {
    private static final String TAG = "CustomBehavior";
    private final int width;

    int x, y = 0;

    public CustomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        width = context.getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ImageView child, View dependency) {
        return dependency instanceof Button;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ImageView child, View dependency) {

        if (x == 0 || y == 0) {
            x = dependency.getLeft();
            y = dependency.getTop();
        }

        int dx = dependency.getLeft() - x;
        int dy = dependency.getTop() - y;

        child.offsetLeftAndRight(-dx);
        child.offsetTopAndBottom(dy);

        x = dependency.getLeft();
        y = dependency.getTop();

        return true;
    }
}
