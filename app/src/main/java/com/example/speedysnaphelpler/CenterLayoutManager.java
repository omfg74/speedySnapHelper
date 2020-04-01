package com.example.speedysnaphelpler;


import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

public class CenterLayoutManager extends LinearLayoutManager {
    private boolean first = true;


    public CenterLayoutManager(Context context) {
        super(context);
    }

    public CenterLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public CenterLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        float speed = first ? 15 : 200;
        first = false;
        RecyclerView.SmoothScroller smoothScroller = new CenterSmoothScroller(recyclerView.getContext(), speed);
        smoothScroller.setTargetPosition(position);
        startSmoothScroll(smoothScroller);
    }

    private static class CenterSmoothScroller extends LinearSmoothScroller {
        private float speed;



        CenterSmoothScroller(Context context, float speed) {
            super(context);
            this.speed = speed;
        }

        @Override
        public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
//            return 150;
            int i = (boxStart + (boxEnd - boxStart) / 3) - (viewStart + (viewEnd - viewStart) /10);
           return i;
        }

        @Override
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return speed / displayMetrics.densityDpi;
        }

    }
}
