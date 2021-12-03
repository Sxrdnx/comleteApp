package com.AndresDiaz.com.models

import androidx.appcompat.widget.Toolbar
 interface IToolbar {//interfas para toolbar y utilisarlo en todas las ctivity
    fun toolbarToLoad(toolbar:Toolbar?)
    fun enableHomeDisplay(value: Boolean)
}