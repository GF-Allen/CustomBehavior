package com.alenbeyond.custombehavior.behavior;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Allen on 2017/10/23.
 */

public class HeaderScrollBehavior extends CoordinatorLayout.Behavior<View> {

    private static final String TAG = "HeaderScrollBehavior";

    private final Rect mHeadRect = new Rect();

    public HeaderScrollBehavior() {
    }

    public HeaderScrollBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        if (target instanceof RecyclerView) {
            RecyclerView rv = (RecyclerView) target;
            boolean down = rv.canScrollVertically(1);//向上推
            boolean up = rv.canScrollVertically(-1);//向下拉
            Log.e(TAG, "方向==>" + down + ":" + up + ":" + dy);
            int maxTranslationY = getMaxTranslationY(child);
            Log.e(TAG, "当前偏移==>" + (child.getTranslationY()) + "MAX==>" + maxTranslationY);
            if (dy > 0) {//底部
                if (Math.abs(child.getTranslationY() - dy) < maxTranslationY) {
                    child.setTranslationY((child.getTranslationY() - dy));
                } else {
                    child.setTranslationY(-maxTranslationY);
                }
            }
            if (!up && dy < 0) {//顶部
                float translationY = child.getTranslationY();
                if (translationY - dy <= 0) {
                    child.setTranslationY(translationY - dy);
                } else {
                    child.setTranslationY(0);
                }
            }
        }
    }

    private int getMaxTranslationY(View view) {
        return view.getMeasuredHeight();
    }
}
