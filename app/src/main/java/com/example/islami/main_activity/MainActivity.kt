package com.example.islami.main_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.databinding.ActivityMainBinding
import com.example.islami.main_activity.main_fragments.QuranFragment
import com.example.islami.main_activity.main_fragments.RadioFragment
import com.example.islami.main_activity.main_fragments.SebhaFragment
import com.example.islami.main_activity.main_fragments.hadethFragment

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initViews()
        viewBinding.bottomNavigationView.selectedItemId = R.id.quran
    }

    private fun initViews(){
        viewBinding.bottomNavigationView.setOnItemSelectedListener {item->
            if(item.itemId == R.id.quran){
                pushFragment(QuranFragment())
            }else if(item.itemId == R.id.ahadeeth){
                pushFragment(hadethFragment())
            }else if(item.itemId == R.id.sebha){
                pushFragment(SebhaFragment())
            }else if(item.itemId == R.id.radio){
                pushFragment(RadioFragment())
            }

            return@setOnItemSelectedListener true
        }
    }

    private fun pushFragment(fragment:Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragments_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}