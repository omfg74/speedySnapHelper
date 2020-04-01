package com.example.speedysnaphelpler

import android.content.Context
import android.graphics.PointF
import android.util.DisplayMetrics
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView


class CustomLayoutManager(context: Context) : LinearLayoutManager(context) {
    private val mContext: Context
    var rv: RecyclerView? = null
    var state: RecyclerView.State? = null
    var position: Int? = null
    fun provide(
        recyclerView: RecyclerView,
        state: RecyclerView.State, position: Int
    ) {
        this.rv = recyclerView
        this.state = state
        this.position = position


    }

    override fun smoothScrollToPosition(
        recyclerView: RecyclerView,
        state: RecyclerView.State, position: Int
    ) {
        val smoothScroller: LinearSmoothScroller = object : LinearSmoothScroller(mContext) {
            //This controls the direction in which smoothScroll looks
//for your view
            override fun computeScrollVectorForPosition(targetPosition: Int): PointF? {
                return this@CustomLayoutManager.computeScrollVectorForPosition(targetPosition)
            }

            //This returns the milliseconds it takes to
//scroll one pixel.
            override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics): Float {
                return MILLISECONDS_PER_INCH / displayMetrics.densityDpi
            }
        }
        smoothScroller.targetPosition = position
        startSmoothScroll(smoothScroller)
    }

    companion object {
        private const val MILLISECONDS_PER_INCH = 50f
    }

    init {
        mContext = context
    }

    override fun scrollToPositionWithOffset(position: Int, offset: Int) {
        super.scrollToPositionWithOffset(position, offset)

    }
}