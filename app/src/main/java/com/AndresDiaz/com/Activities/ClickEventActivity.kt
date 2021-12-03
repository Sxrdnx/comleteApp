package com.AndresDiaz.com.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.AndresDiaz.com.R
import com.AndresDiaz.com.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_click_event.*

class ClickEventActivity : ToolbarActivity(),View.OnLongClickListener {
/*1)Click en xml
  2)click en linea
  3)click by IDS en 'when'*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_event)
        toolbarToLoad(toolbar as Toolbar)
        clickInLine()
        val btn1=findViewById<Button>(R.id.buttonClickMulti1)
        val btn2=findViewById<Button>(R.id.buttonClickMulti2)
        val btn3=findViewById<Button>(R.id.buttonClickMulti3)
        btn1.setOnLongClickListener(this)
        btn2.setOnLongClickListener(this)
        btn3.setOnLongClickListener(this)
    }
    //Regla obligatoria para clicks en XML
    //El metodo debe ser publico
    //nombres deben de coincidir
    //resive solo un parametro(view)
    fun xmlClick(view: View){//<-- lo llamama un xml
        Toast.makeText(this,"click by XML",Toast.LENGTH_LONG).show()
    }
    private fun clickInLine(){
        val btn=findViewById<Button>(R.id.buttonClickInLine)//<-- lo llamas en onCreate
        btn.setOnClickListener{ Toast.makeText(this,"click in Line",Toast.LENGTH_LONG).show()}
    }

    override fun onLongClick(view: View): Boolean {
        when(view.id){
            R.id.buttonClickMulti1->Toast.makeText(this,"click Multi1!",Toast.LENGTH_LONG).show()
            R.id.buttonClickMulti2->Toast.makeText(this,"click Multi2!",Toast.LENGTH_LONG).show()
            R.id.buttonClickMulti3->Toast.makeText(this,"click Multi3!",Toast.LENGTH_LONG).show()
        }
        return true
    }

}
