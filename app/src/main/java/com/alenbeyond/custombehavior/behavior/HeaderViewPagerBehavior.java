package com.alenbeyond.custombehavior.behavior;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.alenbeyond.custombehavior.R;

import java.util.List;

/**
 * Created by Allen on 2017/10/23.
 */

public class HeaderViewPagerBehavior extends CoordinatorLayout.Behavior<View> {

    private static final String TAG = "HeaderViewPagerBehavior";

    private final Rect mHeadRect = new Rect();

    public HeaderViewPagerBehavior() {
    }

    public HeaderViewPagerBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return isDependOn(dependency);
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        final List<View> dependencies = parent.getDependencies(child);
        final View dependency = findDependency(dependencies);
        if (dependency != null) {
            mHeadRect.set(dependency.getLeft(), dependency.getBottom(), dependency.getRight(), dependency.getBottom() + child.getMeasuredHeight());
            child.layout(mHeadRect.left, mHeadRect.top, mHeadRect.right, mHeadRect.bottom);
        }
        return true;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        child.setTranslationY(dependency.getTranslationY());
        return true;
    }

    private View findDependency(List<View> views) {
        for (int i = 0, z = views.size(); i < z; i++) {
            View view = views.get(i);
            if (isDependOn(view))
                return view;
        }
        return null;
    }

    private boolean isDependOn(View dependency) {
        return dependency != null && dependency.getId() == R.id.tab;
    }

}
