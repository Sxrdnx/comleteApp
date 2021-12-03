package com.AndresDiaz.com.Activities


import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.AndresDiaz.com.R
import com.AndresDiaz.com.others.LifeCyclesEventsActivity
import kotlinx.android.synthetic.main.activity_life_cycle.*


class LifeCycleActivity : LifeCyclesEventsActivity() {
    private var exitEnable=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        toolbarToLoad(toolbar as Toolbar)
    }

    override fun onBackPressed() {
        if(exitEnable){
            super.onBackPressed()
        }else{
            exitEnable=true
            Toast.makeText(this,"Presiones de nuevo para salir",Toast.LENGTH_SHORT).show()
            Handler().postDelayed(Runnable{exitEnable=false},2000)
        }

    }
}
