package com.example.speedysnaphelpler

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.test_item.view.*

class TestAdapter(private val control:RvInterface.ItemControl): RecyclerView.Adapter<TestAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestAdapter.ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.test_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
     return   control.getItemsCount()
    }

    override fun onBindViewHolder(holder: TestAdapter.ViewHolder, position: Int) {
        control.bindItems(position,holder)
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),RvInterface.ItemView {


        override fun bind(data: Int?) {
            itemView.testImg.setImageBitmap(drawableToBitmap(itemView.resources.getDrawable(data!!)))
        }
        fun drawableToBitmap(drawable: Drawable): Bitmap? {
            if (drawable is BitmapDrawable) {
                return drawable.bitmap
            }
            val bitmap = Bitmap.createBitmap(
                drawable.intrinsicWidth,
                drawable.intrinsicHeight,
                Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight())
            drawable.draw(canvas)
            return bitmap
        }
    }



}