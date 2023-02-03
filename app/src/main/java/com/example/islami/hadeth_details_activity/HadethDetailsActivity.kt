package com.example.islami.hadeth_details_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.example.islami.Constants
import com.example.islami.R
import com.example.islami.databinding.ActivityHadethDetailsBinding
import com.example.islami.databinding.ActivitySuraDetailsBinding
import com.example.islami.hadeth_details_activity.adapters.HadethContentAdapter

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var activityHadethDetailsBinding: ActivityHadethDetailsBinding
    lateinit var adapter:HadethContentAdapter

    var hadethTitle:String ?= null
    var hadethContent:String ?= null
    var hadethPosition:Int ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHadethDetailsBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(activityHadethDetailsBinding.root)

        initializeActivityLogic()

    }

    private fun initializeActivityLogic(){
        hadethTitle = intent.getStringExtra(Constants.EXTRA_HADETH_TITILE_KEY)
        hadethContent = intent.getStringExtra(Constants.EXTRA_HADETH_CONTENT_KEY)
        hadethPosition = intent.getIntExtra(Constants.EXTRA_HADETH_POSITION, -1)

        activityHadethDetailsBinding.hadethName.text = hadethTitle
        adapter = HadethContentAdapter(null)
        activityHadethDetailsBinding.hadethContentRecyclerView.adapter = adapter
        initializeContentListForAdapter()

        activityHadethDetailsBinding.icBack.setOnClickListener{
            back()
        }

    }

    private fun initializeContentListForAdapter(){
        var hadethContentList = hadethContent?.split("\n")
        hadethContentList?.forEach {
            Log.e("Line", it)
        }
        adapter.updateContent(hadethContentList)
    }

    private fun back(){
        finish()
    }
}