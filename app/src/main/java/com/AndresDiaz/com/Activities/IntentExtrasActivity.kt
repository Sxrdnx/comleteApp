package com.AndresDiaz.com.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.AndresDiaz.com.R
import com.AndresDiaz.com.models.Student
import com.AndresDiaz.com.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_intent_extras.*

class IntentExtrasActivity : ToolbarActivity (){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extras)
        toolbarToLoad(toolbar as Toolbar)//usar o abilitar el toolbaar
        enableHomeDisplay(true)//abilita el backHome (si la funcion existe en el maanifest)
        buttonBack.setOnClickListener{startActivity(Intent(this,IntentsActivity::class.java))}
        val isExtraSet=setIntentExtrasFromPreviousActivity()
        val isParcelableSet=setParcelableExtrasFromPreviousActivity()
        if(!isExtraSet && !isParcelableSet){
            checkBoxDeveloper.visibility= View.INVISIBLE
        }
    }

    fun setParcelableExtrasFromPreviousActivity():Boolean{
        val student=intent.getParcelableExtra<Student>("student")
        student?.let{//if (student!=null)
            textViewName.text = student.name
            textViewLastName.text = student.lastName
            textViewAge.text = "${student.age}"
            checkBoxDeveloper.text="Developer"
            checkBoxDeveloper.isChecked = student.isDeveloper
            return true
        }
        return false
    }

    private fun setIntentExtrasFromPreviousActivity():Boolean{
        val name=intent.getStringExtra("name")
        val lastName=intent.getStringExtra("lastName")
        val age=intent.getIntExtra("age",-1)
        val developer=intent.getBooleanExtra("developer",false)
        if(name!=null && lastName!=null && age>=0) {
            textViewName.text = name
            textViewLastName.text = lastName
            textViewAge.text = "$age"
            checkBoxDeveloper.text="Developer"
            checkBoxDeveloper.isChecked = developer
            return true
        }
        return false
    }

}
