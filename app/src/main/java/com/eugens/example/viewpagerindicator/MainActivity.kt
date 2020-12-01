package com.eugens.example.viewpagerindicator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator

class MainActivity : AppCompatActivity() {

    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postToList()

        view_pager2.adapter = ViewPagerAdapter(titlesList,descList,imageList)
        view_pager2.adapter = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator = findViewById<CircleIndicator>(R.id.indicator)
        indicator.setViewPager(view_pager2)

    }

    private fun addToList(title: String, description: String, image: Int) {
        titlesList.add(title)
        descList.add(description)
        imageList.add(image)
    }

    private fun postToList(){
         for (i in 1..5){
             addToList("title $i", "Description $i", R.mipmap.ic_launcher_round)
         }
    }
}