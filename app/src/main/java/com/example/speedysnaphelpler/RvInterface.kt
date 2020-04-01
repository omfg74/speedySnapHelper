package com.example.speedysnaphelpler

import android.graphics.Bitmap

interface RvInterface {

    interface ItemControl{
        fun bindItems(position:Int,item:ItemView)
        fun getItemsCount():Int
    }
    interface ItemView{
        fun bind(data: Int?)
    }
}