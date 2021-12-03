package com.AndresDiaz.com.others

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.AndresDiaz.com.R
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

/*Las extenciones son para encapsular codigo que se usara mucho para poder usarlo despues
* de una froma mas sencilla*/
fun Int.isNatural()=this>=0
fun Activity.toast(message: CharSequence, duration: Int=Toast.LENGTH_SHORT)=Toast.makeText(this,message,duration).show()
fun Activity.snackBar(message: CharSequence,view : View?=findViewById(R.id.container),
                      duration: Int=Snackbar.LENGTH_SHORT,
                      action: String?=null,
                      actionEvt: (v:View)->Unit={}){
    if (view != null){
        val snackbar= Snackbar.make(view,message,duration)
        if (!action.isNullOrEmpty()){
            snackbar.setAction(action,actionEvt)
        }
        snackbar.show()
    }
}
fun ViewGroup.inflate(layoutId: Int)=LayoutInflater.from(context).inflate(layoutId,this,false)!!

fun ImageView.loadByURL(url: String)=Picasso.get().load(url).into(this)

inline fun <reified T: Activity>Activity.goToActivity(noinline init: Intent.()->Unit={}){//noinline permite crear un contexto al intent
    val intent= Intent(this,T::class.java)
    intent.init()
    startActivity(intent)
}
fun Activity.goToActivityResult(action: String,requestCode: Int, init: Intent.()->Unit={}){
    val intent= Intent(action)//ejemplo de action MediaStore.Action_IMAGE_CAPTURE
    intent.init()//por si pasamos un extra
    startActivityForResult(intent,requestCode)
}