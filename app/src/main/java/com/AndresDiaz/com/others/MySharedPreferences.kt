package com.AndresDiaz.com.others

import android.content.Context

class MySharedPreferences (context: Context){
    //nombre Fichero shared Preferences
    private  val fileName="mis preferencias"
    //Instancia de ese fichero
    private val prefs=context.getSharedPreferences(fileName,Context.MODE_PRIVATE)//para que solo lo peda leer nuestra app y no apps de 3ros
    //por cada una de las variables que vamos a guardar en nuetro fichero shared Preferences
    var name: String
        get()=prefs.getString("name","")
        set(value)=prefs.edit().putString("name",value).apply()
    var age:Int
        get()=prefs.getInt("age",-1)
        set(value) = prefs.edit().putInt("age",value).apply()

}