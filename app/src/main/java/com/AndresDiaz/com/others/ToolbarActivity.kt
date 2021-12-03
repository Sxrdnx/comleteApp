package com.AndresDiaz.com.others

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.AndresDiaz.com.models.IToolbar

open class ToolbarActivity : AppCompatActivity(),IToolbar {//implementacion de la interfas y sobrescribiendo el metodo
    protected var _toolbar:Toolbar?=null

    override fun toolbarToLoad(toolbar: Toolbar?) {
        _toolbar=toolbar
        _toolbar?.let{
            setSupportActionBar(_toolbar)
        }
    }

    override fun enableHomeDisplay(value: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(value)
    }
}
