package com.example.shoppingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class itemAdapter:RecyclerView.Adapter<itemAdapter.itemHolder>() {
   var data=arrayOf<items>()
  set(value) {
    field=value
    notifyDataSetChanged()
  }

  private lateinit var mlistener: OnItemClickListener
  interface OnItemClickListener{
    fun onItemClick(position: Int)
  }
  fun setItemOnClickListener(listener:OnItemClickListener){
    mlistener=listener
  }


  class itemHolder(view: View, listener: OnItemClickListener):RecyclerView.ViewHolder(view) {
    val photo:ImageView= view.findViewById(R.id.item_image)
    val price:TextView=view.findViewById(R.id.price)
    val delivery:TextView=view.findViewById(R.id.del)
    val name:TextView=view.findViewById(R.id.name)
    val get:Button=view.findViewById(R.id.button)

    init {
        view.setOnClickListener {
       listener.onItemClick(adapterPosition)
        }
    }
  }



override fun getItemCount()=data.size

override fun onBindViewHolder(holder: itemHolder, position: Int) {
  with(holder)
  {
    photo.setImageResource(data[position].flagid)
    price.text= data[position].price
    delivery.text= data[position].del
    name.text= data[position].name
    get.text= data[position].get

  }
}


override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemHolder {
  val itemLayout= LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
  return itemHolder(itemLayout,mlistener)
}

override fun getItemId(position: Int): Long {
  return data[position].flagid.toLong()
}

}

//private fun AdapterView.OnItemClickListener.onItemClick(adapterPosition: Int) {
//
//}
