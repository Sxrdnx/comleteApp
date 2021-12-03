package com.AndresDiaz.com.Activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.AndresDiaz.com.R
import com.AndresDiaz.com.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_permissions.*

class PermissionsActivity : ToolbarActivity() {
    private val requestCameraPermission =8//variable para el permiso de la camara
    private val requestCameraPicture =7
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)
        toolbarToLoad(toolbar as Toolbar)
        buttonPicture.setOnClickListener{getPictureFromCameraAskingPermissions()}
    }
    private fun getPictureFromCameraAskingPermissions(){
        //añadimos el permiso al manifest
        //comprobar el permiso de la camara
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED){//comprueba si el permiso es aseptado
            //si NO a sido aceptado previamente (para versiones desde la 6.0[API>=23])
            ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA),requestCameraPermission)//pide el permiso
        }else{
            //si a sido aceptado previamente o para verciones inferiores 6.0[API<=23]
            //Permiso aceptado
            val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)//se usa el activity de la camara que tiene el telefono por defecto
            startActivityForResult(intent,requestCameraPicture)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,permissions: Array<out String>,grantResults: IntArray){
        //Comprobara los permisos fueron aceptados regrresando el requestCode de cada permiso
        when(requestCode){
            requestCameraPermission->{
                if(grantResults.size==1 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    //Permiso aceptado
                    val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)//se usa el activiti de la camara que tiene el telefono por defecto
                    startActivityForResult(intent,requestCameraPicture)
                }else{
                    //permiso denegado
                    Toast.makeText(this,"No Puedes Tomar la FOTO Sin Aceptar el Permiso TOTO!",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            requestCameraPicture->{
                //comprbar si el resultado o foto es buena o fue tomada
                if(resultCode==Activity.RESULT_OK){
                    //Obtenemos los extras del intent resivido por parametrso
                    val extras=data!!.extras
                    //formamo el bitMap a partir de los extras
                    val imageBitMap=extras.get("data") as Bitmap
                    //cargamos la foto como bitmap en el imageView
                    imageViewPicture.setImageBitmap(imageBitMap)
                }else{
                    //foto no tomada correctamente o ubo un error
                    Toast.makeText(this,"No se tomo la foto",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}
