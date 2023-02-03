package com.example.islami.main_activity.main_fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.Constants.EXTRA_HADETH_CONTENT_KEY
import com.example.islami.Constants.EXTRA_HADETH_POSITION
import com.example.islami.Constants.EXTRA_HADETH_TITILE_KEY
import com.example.islami.callbacks.OnHadethClickListener
import com.example.islami.data.model.Hadeth
import com.example.islami.databinding.FragmentHadethBinding
import com.example.islami.hadeth_details_activity.HadethDetailsActivity
import com.example.islami.main_activity.main_fragments.adapters.HadethTitleRecyclerAdapter

class hadethFragment : Fragment() {
    lateinit var fragmentHadethBinding: FragmentHadethBinding
    lateinit var hadethTitleAdapter : HadethTitleRecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHadethBinding = FragmentHadethBinding.inflate(inflater, container, false)
        return fragmentHadethBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadethFile()
        hadethTitleAdapter = HadethTitleRecyclerAdapter(allAhadeth)
        fragmentHadethBinding.hadethRecyclerView.adapter = hadethTitleAdapter

        hadethTitleAdapter.onHadethTitleClickListener = object:OnHadethClickListener{
            override fun onHadethClick(hadeth: Hadeth, position: Int) {
                startHadethDetailsActivity(hadeth, position)
            }
        }
    }


    val allAhadeth = mutableListOf<Hadeth>()
    private fun readHadethFile(){
        val filename = "ahadeth.txt"
        val fileContent = activity?.assets?.open(filename)?.bufferedReader().use {
            it?.readText()
        }

        if(fileContent == null) return;

        val ahadethContent:List<String> = fileContent.trim().split("#")
        var title:String
        var content:String
        ahadethContent.forEach{singleHadethContent->
            //val indexOfFirstLine = singleHadethContent.indexOf("\n")
            //val title = singleHadethContent.substring(0, indexOfFirstLine)

            title = singleHadethContent.trim().substringBefore('\n')
            content = singleHadethContent.trim().substringAfter('\n')
            val hadeth = Hadeth(title, content)
            allAhadeth.add(hadeth)
        }
    }

    private fun startHadethDetailsActivity(hadeth:Hadeth ,position:Int){
        val intent1 = Intent(requireActivity(), HadethDetailsActivity::class.java)
        intent1.putExtra(EXTRA_HADETH_POSITION, position)
        intent1.putExtra(EXTRA_HADETH_TITILE_KEY, hadeth.title)
        intent1.putExtra(EXTRA_HADETH_CONTENT_KEY, hadeth.content)
        startActivity(intent1)
    }

}