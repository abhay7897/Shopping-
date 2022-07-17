package com.example.shoppingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.databinding.ActivityMainBinding

val arr= arrayOf(items("Infinity MiniSpeaker S1","FREE Delivery","Rs 699","GET",R.drawable.minispeaker),
        items("MI Smart Watch Y68 Boys ","Del.Charge Rs.40","Rs 999","GET",R.drawable.download),
        items("OnePlus Nord CE2","FREE Delivery","Rs 23999","GET",R.drawable.oneplus),
        items("RYNOCHI Eyewear M","FREE Delivery","Rs 389","GET",R.drawable.specs),
        items("Mi StepOut 12 Backpack","FREE Delivery","Rs 399","GET",R.drawable.bag),
        items("Milton Thermosteel Carate","FREE Delivery","Rs 1529","GET",R.drawable.milton),
        items("Crockery Palace Melamine","FREE Delivery","Rs 5499","GET",R.drawable.crockeryjpg),
        items("Diswa Plastic Shelf store","FREE Delivery","Rs 899","GET",R.drawable.store),
        items("Labrada Whey Protein","FREE Delivery","Rs 1389","GET",R.drawable.prootein),
        items("Paragon Mens Sport Shoes","Del.Charge Rs.40","Rs 499","GET", R.drawable.shoes),
        items("Nycil powder","Del.Charge Rs.40","Rs 99","GET",R.drawable.nycil)
)
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val itemlist=binding.recyclerView.apply {
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=itemAdapter().apply {
                setHasStableIds(true)
            }
            setHasFixedSize(true)
        }
        var adapter=
        (itemlist.adapter as itemAdapter).data= arr
        itemlist.adapter.setItemOnClickListener(object :itemAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {

            }

        })




    }
}