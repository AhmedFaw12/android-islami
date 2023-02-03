package com.example.islami.main_activity.main_fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.Constants
import com.example.islami.R
import com.example.islami.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {
    lateinit var sebhaBinding: FragmentSebhaBinding
    var counter:Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sebhaBinding = FragmentSebhaBinding.inflate(inflater, container, false)
        return sebhaBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //tasbeeh_count_tv, tasbeeh_tyle, sebha_body_img
        sebhaBinding.tasbeehType.text = Constants.SUBHAN_ALLAH
        sebhaBinding.tasbeehCountTv.text = "$counter"

        sebhaBinding.sebhaBodyImg.setOnClickListener{
            onSebhaBodyClick()
        }
    }

    private fun onSebhaBodyClick(){
        sebhaBinding.sebhaBodyImg.rotation = (sebhaBinding.sebhaBodyImg.rotation  + 10.909F)%360// 360/33 = 10.9

        counter++
        sebhaBinding.tasbeehCountTv.text = "$counter"

        if(sebhaBinding.tasbeehType.text == Constants.ALKHATEMA){
            sebhaBinding.tasbeehType.text = Constants.SUBHAN_ALLAH
            counter = 0
            sebhaBinding.tasbeehCountTv.text = "$counter"
        }

        if(counter == 33){
            counter = 0
            if(sebhaBinding.tasbeehType.text == Constants.SUBHAN_ALLAH){
                sebhaBinding.tasbeehType.text = Constants.ALHAMDLLAH
                sebhaBinding.tasbeehCountTv.text = "$counter"

            }else if(sebhaBinding.tasbeehType.text == Constants.ALHAMDLLAH){
                sebhaBinding.tasbeehType.text = Constants.ALLAH_AKBAR
                sebhaBinding.tasbeehCountTv.text = "$counter"

            }else if(sebhaBinding.tasbeehType.text == Constants.ALLAH_AKBAR){
                sebhaBinding.tasbeehType.text = Constants.ALKHATEMA
                sebhaBinding.tasbeehCountTv.text = "$counter"
            }
        }
    }
}