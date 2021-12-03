package com.AndresDiaz.com.app

import android.app.Application
import com.AndresDiaz.com.others.MySharedPreferences
val preferences:MySharedPreferences by lazy { MyApp.prefs!!}
class MyApp: Application(){/*<-- sobre escribir este metodo permite crear logica antes de que la app sea lanzada*/
    companion object{
        var prefs:MySharedPreferences?=null
    }

    override fun onCreate() {
        super.onCreate()
        prefs=MySharedPreferences(applicationContext)
    }

}