package com.alenbeyond.custombehavior;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

/**
 * Created by alen on 17/2/21.
 */

public class ButtonBehavior extends CoordinatorLayout.Behavior<View> {
    private static final String TAG = "ButtonBehavior";
    private boolean isShow = true;

    public ButtonBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        Log.d(TAG, "layoutDependsOn");
        return dependency instanceof ListView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        Log.d(TAG, "onDependentViewChanged");
        return true;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Log.d(TAG, "onNestedScroll:" + dyConsumed + ":" + dyUnconsumed + ":" + child.getTop());
        if (dyConsumed > 0) {
            showAnimation(child);
        } else if (dyConsumed < 0) {
            hideAnimation(child);
        }
    }

    private void showAnimation(View target) {
        if (isShow) return;
        startAnim(target, 0, 1);
        isShow = !isShow;
    }

    private void hideAnimation(View target) {
        if (!isShow) return;
        startAnim(target, 1, 0);
        isShow = !isShow;
    }

    private void startAnim(View target, float from, float to) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(target, "scaleX", from, to);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(target, "scaleY", from, to);
        AnimatorSet set = new AnimatorSet();
        set.setTarget(target);
        set.playTogether(scaleX, scaleY);
        set.start();
    }
}
