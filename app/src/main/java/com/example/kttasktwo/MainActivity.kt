package com.example.kttasktwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity(),onItemClickListener {

        private lateinit var recyclerView: RecyclerView
        private lateinit var viewAdapter: RecyclerView.Adapter<*>
        private lateinit var viewManager: RecyclerView.LayoutManager



    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val myDataset = ArrayList<Items>()
            myDataset.add(Items(R.drawable.avocado,R.string.avocado,"$20",R.string.avocado_description))
            myDataset.add(Items(R.drawable.mask,R.string.faceMask,"$200",R.string.faceMask_description))
            myDataset.add(Items(R.drawable.apple,R.string.apple,"$10",R.string.apple_description))
            myDataset.add(Items(R.drawable.water,R.string.bottle_water,"$5",R.string.water_description))
            myDataset.add(Items(R.drawable.meat,R.string.meat,"$50",R.string.meat_details))
            myDataset.add(Items(R.drawable.crown,R.string.crown,"$100",R.string.crown_descriptiion))
            myDataset.add(Items(R.drawable.orange,R.string.orange,"$3",R.string.orange_description))
            myDataset.add(Items(R.drawable.pineapple,R.string.pineapple,"$7",R.string.pineapple_description))
            myDataset.add(Items(R.drawable.toiletroll,R.string.tissue,"$300",R.string.tissue_description))
            myDataset.add(Items(R.drawable.medicine,R.string.multiVitamins,"$70",R.string.multiVitamins_description))
            myDataset.add(Items(R.drawable.electronics,R.string.mp3player,"$150",R.string.mp3player_description))
            myDataset.add(Items(R.drawable.hand_sanitizer,R.string.sanitizer,"$80",R.string.sanitizer_details))


            viewManager = LinearLayoutManager(this)
            viewAdapter = MyAdapter(myDataset,this)


            recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
                // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                setHasFixedSize(true)

                // use a linear layout manager
                layoutManager = viewManager

                // specify an viewAdapter (see also next example)
                adapter = viewAdapter


            }


}

    override fun OnItemClick(items: Items, position: Int) {
//        Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show()
        val intent = Intent(this,Details::class.java)


        intent.putExtra("Image",items.image)
        intent.putExtra("name",items.name)
        intent.putExtra("details",items.details)
        intent.putExtra("price",items.price)
        startActivity(intent)
    }
}
