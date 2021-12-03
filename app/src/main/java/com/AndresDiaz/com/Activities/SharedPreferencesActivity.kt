package com.AndresDiaz.com.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.AndresDiaz.com.R
import com.AndresDiaz.com.app.preferences
import com.AndresDiaz.com.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity :ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)
        toolbarToLoad(toolbar as Toolbar)
        preferences.name=""
        buttonSave.setOnClickListener {setValuesSharedPreferences(); cleanEditTexts();getValuesSharedPreferences();}
        getValuesSharedPreferences()
    }
    private fun getValuesSharedPreferences(){//lo obtiene del shared preferences
        if((preferences.name.isNotEmpty())&&(preferences.age > 0)){
            textViewSahredPreferences.text="Hola vienvenido ${preferences.name} tu edad es ${preferences.age}"
        }else{
            textViewSahredPreferences.text="Hola, porfavor guarde su nombre y edad"
        }
    }
    private fun setValuesSharedPreferences(){//lo guarda en el shared preferences
        if (editTextName.text.toString().isNotEmpty() && editTextAge.text.toString().isNotEmpty()){
            preferences.name=editTextName.text.toString()
            preferences.age=editTextAge.text.toString().toInt()
            Toast.makeText(this,"Datos guardados correctamente",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Debe rellenar los campos",Toast.LENGTH_LONG).show()
        }

    }
    private fun cleanEditTexts(){//limpia despues de guardar
        editTextName.text.clear()
        editTextAge.setText("")
    }


}
