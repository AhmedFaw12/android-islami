package com.example.islami.main_activity.main_fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islami.Constants
import com.example.islami.R
import com.example.islami.callbacks.OnSuraClickListener
import com.example.islami.data.model.ArSuras
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.main_activity.main_fragments.adapters.SurasNameAdapter
import com.example.islami.quran_details.SuraDetailsActivity

class QuranFragment : Fragment() {

    lateinit var fragmentQuranBinding: FragmentQuranBinding
    lateinit var quranRecyclerView:RecyclerView
    lateinit var quranAdapter:SurasNameAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentQuranBinding = FragmentQuranBinding.inflate(inflater, container, false)
        return fragmentQuranBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        switchModeLogic()

        quranRecyclerView = fragmentQuranBinding.quranRecyclerView
        quranAdapter = SurasNameAdapter(ArSuras)
        quranRecyclerView.adapter = quranAdapter
        quranRecyclerView.layoutManager = LinearLayoutManager(context)
        quranAdapter.onSuraClickListener = object:OnSuraClickListener{
            override fun onSuraClick(suraName: String, position: Int) {
                startSuraDetailsActivity(suraName, position)
            }
        }
    }

    fun startSuraDetailsActivity(suraName:String, position:Int){
        val intent1 = Intent(requireActivity(), SuraDetailsActivity::class.java)
        intent1.putExtra(Constants.EXTRA_SURA_POSITION,position)
        intent1.putExtra(Constants.EXTRA_SURA_NAME_KEY,suraName)
        startActivity(intent1)

    }

    private fun switchModeLogic(){
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){

            fragmentQuranBinding.switchModeButton.text = "Light"
        }else{
            fragmentQuranBinding.switchModeButton.text = "Dark"

        }


        fragmentQuranBinding.switchModeButton.setOnClickListener{
            if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                fragmentQuranBinding.switchModeButton.text = "Dark"
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                fragmentQuranBinding.switchModeButton.text = "Light"
            }
        }
    }




}