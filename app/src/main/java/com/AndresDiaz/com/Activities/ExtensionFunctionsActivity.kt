package com.AndresDiaz.com.Activities


import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.AndresDiaz.com.MainActivity
import com.AndresDiaz.com.R
import com.AndresDiaz.com.others.*
import kotlinx.android.synthetic.main.activity_extension_functions.*

class ExtensionFunctionsActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension_functions)
        toolbarToLoad(toolbar as Toolbar)
        buttonToast.setOnClickListener{toast(getString(R.string.genericMessage))}
        buttonSnackBar.setOnClickListener{snackBar("mami K TuKiere: Des Hacer",action = "Des Hacer"){toast("me das asco")} }
        buttonLoadByUrl.setOnClickListener{imageViewLoadedByUrl.loadByURL("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")}
        buttonGoToActivity.setOnClickListener{goToActivity<MainActivity>()}
    }
}


