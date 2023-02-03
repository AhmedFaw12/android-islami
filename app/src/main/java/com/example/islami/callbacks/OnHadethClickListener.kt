package com.example.islami.callbacks

import com.example.islami.data.model.Hadeth

interface OnHadethClickListener {
    fun onHadethClick(hadeth:Hadeth, position:Int)
}