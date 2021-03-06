package com.AndresDiaz.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.AndresDiaz.com.Activities.*
import com.AndresDiaz.com.others.ToolbarActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : ToolbarActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbarToLoad(toolbar as Toolbar)

        val btnLifeCycle=findViewById<Button>(R.id.button_to_cycle)
        val btnClickEvents=findViewById<Button>(R.id.button_to_click)
        val btnAndroidExt=findViewById<Button>(R.id.button_to_android_extensions)
        val btnPicasso=findViewById<Button>(R.id.button_to_picasso)
        val btnListView=findViewById<Button>(R.id.button_to_list_view)
        val btnIntents=findViewById<Button>(R.id.button_to_intents)
        val btnPermission=findViewById<Button>(R.id.button_to_permissions)
        val btnSharedPreferences=findViewById<Button>(R.id.button_to_shared_preferences)
        val btnExtensionFunctions=findViewById<Button>(R.id.button_to_extension_functions)

        btnLifeCycle.setOnClickListener { goToLifeCycleActivity() }
        btnClickEvents.setOnClickListener { goToClickEventsActivity() }
        btnAndroidExt.setOnClickListener { goToKotlinAndroidExtActivity() }
        btnPicasso.setOnClickListener { goToPicassoActivity() }
        btnListView.setOnClickListener { goToListViewActivity() }
        btnIntents.setOnClickListener { goToIntentsActivity() }
        btnPermission.setOnClickListener { goToPermissionsActivity() }
        btnSharedPreferences.setOnClickListener { goToSharedPreferencesActivity() }
        btnExtensionFunctions.setOnClickListener { goToExtensionFunctionsActivity() }
    }
    fun showToast(){
        Toast.makeText(this,"hahah que mmadas por que no se be ", Toast.LENGTH_LONG).show()// toast simple
    }

    fun showSnackBar(){
        var layout= findViewById<ConstraintLayout>(R.id.constrainLayout)
        Snackbar.make(layout,"hahaha tas echo un pdndejo",Snackbar.LENGTH_LONG).setAction("si o no puto!"){
            Snackbar.make(layout,"ahahah listo bro no se armo", Snackbar.LENGTH_LONG).show()//metodo para el setAction del snackBar
        }.show()

 //Snackbar.make(layout,"hahaha tas echo un pdndejo",Snackbar.LENGTH_LONG).show()<-- asi es un snackBar simple
    }
    private fun goToLifeCycleActivity()=startActivity(Intent(this,LifeCycleActivity::class.java))
    private fun goToClickEventsActivity()=startActivity(Intent(this,ClickEventActivity::class.java))
    private fun goToKotlinAndroidExtActivity()=startActivity(Intent(this,KotlinAndroidExtensionsActivity::class.java))
    private fun goToPicassoActivity() = startActivity(Intent(this, PicassoActivity::class.java))
    private fun goToListViewActivity() = startActivity(Intent(this, ListViewActivity::class.java))
    private fun goToIntentsActivity() = startActivity(Intent(this, IntentsActivity::class.java))
    private fun goToPermissionsActivity() = startActivity(Intent(this, PermissionsActivity::class.java))
    private fun goToSharedPreferencesActivity() = startActivity(Intent(this, SharedPreferencesActivity::class.java))
    private fun goToExtensionFunctionsActivity() = startActivity(Intent(this, ExtensionFunctionsActivity::class.java))

}
