package com.AndresDiaz.com.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.AndresDiaz.com.R
import com.AndresDiaz.com.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_kotlin_android_extensions.*

class KotlinAndroidExtensionsActivity : ToolbarActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_android_extensions)//el nombre del layout es el mismo del kax para cargar toto elcontenido
        val btnId=findViewById<Button>(R.id.buttonById)
        toolbarToLoad(toolbar as Toolbar)
        btnId.setOnClickListener{ Toast.makeText(this,"Busqueda ByID", Toast.LENGTH_LONG).show()}
        buttonKAT.setOnClickListener{ Toast.makeText(this,"Busqueda By KAT", Toast.LENGTH_LONG).show()}
    }
}
