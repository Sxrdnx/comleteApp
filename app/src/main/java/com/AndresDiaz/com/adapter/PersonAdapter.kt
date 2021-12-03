package com.AndresDiaz.com.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.AndresDiaz.com.R
import com.AndresDiaz.com.models.Person
import com.AndresDiaz.com.others.inflate
import kotlinx.android.synthetic.main.list_view_person.view.*

class PersonAdapter (val contex: Context,val layout:Int, val list: List<Person>): BaseAdapter(){
    /*nos permite tomar ese layout y usarlocon los campos nuevos */
    //private  val mInflator: LayoutInflater= LayoutInflater.from(contex)

    override fun getItem(position: Int): Any {//que item dar
       return list[position]
    }

    override fun getItemId(position: Int): Long {//casi nunca se usa
        return position.toLong()
    }

    override fun getCount(): Int {//numero de items de la lista
        return list.size
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {//es llamado cada vez que se rellene un nuevo item (toda la logica)
        val view : View
        val vh: PersonViewHolder
        if (convertView==null){
            //view=mInflator.inflate(layout,parent,false)
            view=parent.inflate(layout)
            vh= PersonViewHolder(view)
            view.tag=vh
        }else{
            view=convertView
            vh=view.tag as PersonViewHolder
        }
        val fullName="${list[position].firstName},${list[position].lastName}"// variable con el nombre completo
        vh.fullName.text=fullName
        vh.age.text="${list[position].age}"
        return view
    }

}
private  class PersonViewHolder(view: View){//patron de diceño view holder
    val fullName: TextView=view.textViewName
    val age: TextView=view.textViewAge

}