package com.davidriad.se.project.se_project_grp8.scallinglayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.davidriad.se.project.se_project_grp8.R;
import com.google.android.material.appbar.AppBarLayout;


public class ScalingLayoutBehavior extends CoordinatorLayout.Behavior<ScalingLayout> {

    private final float toolbarHeightInPixel;

    public ScalingLayoutBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        toolbarHeightInPixel = context.getResources().getDimensionPixelSize(R.dimen.sl_toolbar_size);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ScalingLayout child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ScalingLayout child, View dependency) {
        int totalScrollRange = ((AppBarLayout) dependency).getTotalScrollRange();
        child.setProgress((-dependency.getY()) / totalScrollRange);
        if (totalScrollRange + dependency.getY() > (float) child.getMeasuredHeight() / 2) {
            child.setTranslationY(totalScrollRange + dependency.getY() + toolbarHeightInPixel - (float) child.getMeasuredHeight() / 2);
        } else {
            child.setTranslationY(toolbarHeightInPixel);
        }
        return super.onDependentViewChanged(parent, child, dependency);
    }
}
