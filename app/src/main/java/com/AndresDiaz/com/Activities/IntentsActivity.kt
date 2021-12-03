package com.AndresDiaz.com.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.AndresDiaz.com.R
import com.AndresDiaz.com.models.Student
import com.AndresDiaz.com.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_intents.*

class IntentsActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)
        toolbarToLoad(toolbar as Toolbar)
        buttonIntentExtras.setOnClickListener{goIntentExtras()}
        buttonIntentFlags.setOnClickListener{goIntentFlags()}
        buttonIntentObject.setOnClickListener{goIntentObject()}
    }
    private fun goIntentExtras(){
        val intent=Intent(this,IntentExtrasActivity::class.java)
        intent.putExtra("name","Andres")
        intent.putExtra("lastName","Diaz")
        intent.putExtra("age",22)
        intent.putExtra("developer",true)

        startActivity(intent)
    }
    private fun goIntentFlags(){
        val intent=Intent(this,IntentExtrasActivity::class.java)
        //intent.flags=Intent.FLAG_ACTIVITY_NO_HISTORY //No guarda el activity en el stack
        //intent.flags=Intent.FLAG_ACTIVITY_NO_ANIMATION//trancision no animada
        intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK// borra el stack completo
        startActivity(intent)
        //finish()//destruye este activity evitando que entre en el stack
    }
    private fun goIntentObject(){
        /* la fun putExtra admite Parcelable y como el objeto implementa esa interfas se puede enviar asi */
        val intent=Intent(this,IntentExtrasActivity::class.java)
        val student=Student("Andres","Diaz",22, true )
        intent.putExtra("student",student)
        startActivity(intent)
    }


}
