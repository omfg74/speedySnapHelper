package com.example.speedysnaphelpler

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), RvInterface.ItemControl {

    private var skip:Boolean = false
    private var dto: List<Int>? = null
    var listener: RecyclerView.OnScrollListener? = null
    var listener2: RecyclerView.OnScrollListener? = null
    private var rvAdapter: TestAdapter? = null
    private val lm = CenterLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDto()
        rvAdapter = TestAdapter(this)
        testRv.apply {
            adapter = rvAdapter
            layoutManager = lm
        }
        addListener()

    }

    override fun bindItems(position: Int, item: RvInterface.ItemView) {
        item.bind(dto?.get(position))
    }

    override fun getItemsCount(): Int {
        return dto?.size ?: 0
    }

    private fun addListener() {

        listener = object : RecyclerView.OnScrollListener() {
            var lastDy = 0
            val lastDy2 = 0
            var firstItemPosition: Int? = null
            var findFirstCompletelyVisibleItemPosition: Int? = null
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
//                Log.d("dx",""+dx)
                Log.d("dy", "" + dy)

                if (lastDy > dy) {
                    firstItemPosition = lm.findFirstVisibleItemPosition()
                    findFirstCompletelyVisibleItemPosition =
                        lm.findFirstCompletelyVisibleItemPosition()
                    Log.d("scroll", "firstItemPosition " + firstItemPosition)
                    Log.d(
                        "scroll",
                        "findFirstCompletelyVisibleItemPosition " + findFirstCompletelyVisibleItemPosition
                    )
                }
                lastDy = dy

            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                Log.d("newState", "new state" + newState)
                if (newState == SCROLL_STATE_IDLE) {
                    testRv.removeOnScrollListener(listener!!)
                    Log.d("", "scroll " + findFirstCompletelyVisibleItemPosition + " ")
                    if (findFirstCompletelyVisibleItemPosition!=0) {
                        lm.smoothScrollToPosition(
                            testRv,
                            RecyclerView.State(),
                            findFirstCompletelyVisibleItemPosition?:0
                        )
//                        addListener2()
                        testRv.addOnScrollListener(listener!!)
                    }else{
                        testRv.addOnScrollListener(listener!!)
                    }

                }
//                else {
//                    testRv.addOnScrollListener(listener!!)
//                }
            }
        }
        testRv.addOnScrollListener(listener!!)
    }

         fun addListener2(){
             listener2=object: RecyclerView.OnScrollListener() {
                 override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                     super.onScrolled(recyclerView, dx, dy)
                 }

                 override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                     super.onScrollStateChanged(recyclerView, newState)
                     if(newState==0){
                         testRv.removeOnScrollListener(listener2!!)
                         testRv.addOnScrollListener(listener!!)
                     }
                 }
             }

         }

    private fun initDto() {
        dto = listOf<Int>(
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground
        )
    }

}
