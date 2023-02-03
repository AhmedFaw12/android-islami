package com.example.islami.quran_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islami.Constants
import com.example.islami.R
import com.example.islami.databinding.ActivitySuraDetailsBinding
import com.example.islami.quran_details.adapters.SuraContentAdapter

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var suraDetailsBinding: ActivitySuraDetailsBinding
    lateinit var suraContentRecyclerView: RecyclerView
    lateinit var adapter: SuraContentAdapter

    var suraName:String?= null
    var suraPosition:Int?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        suraDetailsBinding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(suraDetailsBinding.root)

        suraContentRecyclerView = suraDetailsBinding.suraContentRecyclerView
        adapter = SuraContentAdapter(null)

        suraName = intent.getStringExtra(Constants.EXTRA_SURA_NAME_KEY)
        suraPosition = intent.getIntExtra(Constants.EXTRA_SURA_POSITION, -1)
        suraContentRecyclerView.adapter= adapter
        suraContentRecyclerView.layoutManager = LinearLayoutManager(this@SuraDetailsActivity)
        readFileText()
        suraDetailsBinding.suraName.text = suraName
        suraDetailsBinding.icBack.setOnClickListener{
            finish()//closes current activity
        }


    }

    fun readFileText(){
        //IO Stream -> input/Output Stream -> Read From file/write to file
        val fileName = "${suraPosition?.plus(1)}.txt"
        val fileContent = assets.open(fileName)
            .bufferedReader()
            .use{ it.readText() }
        val suraContent = fileContent.trim().split("\n")
        adapter.updateData(suraContent)
    }
}