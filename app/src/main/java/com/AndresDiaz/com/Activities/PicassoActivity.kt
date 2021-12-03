package com.AndresDiaz.com.Activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.AndresDiaz.com.R
import com.AndresDiaz.com.others.ToolbarActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picasso.*
import java.lang.Exception

class PicassoActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)
        toolbarToLoad(toolbar as Toolbar)
        buttonLoader.setOnClickListener{loadImages()}
        Picasso.get().load("https://static.pexels.com/photos/288264/pexels-photo-288264.jpeg").fetch()//precacheo
    }
    private fun loadImages(){
        /*.fit() para tomar tod el imageview*/
        Picasso.get()//<--esta imagen se carga primero por se cacheada primero
            .load("https://static.pexels.com/photos/288264/pexels-photo-288264.jpeg")
            .resize(400,400)
            .centerCrop()
            .into(imageViewTop)

        /*Picasso.get()
            .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
            .fit()
            .into(imageViewBottom)*/
        /*Picasso.get()
            .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
            .fit()
            .transform(CircleTransform())//renderisa como circulo
            .into(imageViewBottom)*/
        val context: Context =this
        Picasso.get()
            .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
            .fetch(object : Callback{
                override fun onSuccess() {
                    imageViewBottom.alpha=0f
                    Picasso.get()
                        .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
                        .fit()
                        .into(imageViewBottom)
                    imageViewBottom.animate().setDuration(1500).alpha(1f).start()


                }

                override fun onError(e: Exception?) {
                    TODO("Not yet implemented")
                }

            })

    }
}
