package com.AndresDiaz.com.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.AndresDiaz.com.R
import com.AndresDiaz.com.adapter.PersonAdapter
import com.AndresDiaz.com.models.Person
import com.AndresDiaz.com.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity :ToolbarActivity() {

    private lateinit var adapter: PersonAdapter
    private lateinit var personList: List<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        toolbarToLoad(toolbar as Toolbar)

        personList=getPersons()
        adapter=PersonAdapter(this,R.layout.list_view_person,personList)

        listView.adapter=adapter
    }
    private fun getPersons():List<Person>{
        return listOf(
            Person("Alejandro", "Lora", 27),
            Person("Fernando", "Vega", 37),
            Person("Alicia", "Gómez", 19),
            Person("Paula", "Escobar", 33),
            Person("Alberto", "Parada", 22),
            Person("Cristian", "Romero", 44),
            Person("Octavio", "Hernández", 23),
            Person("Yaiza", "Costi", 43),
            Person("Naomi", "Fernandexz", 57),
            Person("Jason", "Otah", 16),
            Person("Alejandro", "Lora", 27),
            Person("Fernando", "Vega", 37),
            Person("Alicia", "Gómez", 19),
            Person("Paula", "Escobar", 33),
            Person("Alberto", "Parada", 22),
            Person("Cristian", "Romero", 44),
            Person("Octavio", "Hernández", 23),
            Person("Yaiza", "Costi", 43),
            Person("Naomi", "Fernandexz", 57),
            Person("Jason", "Otah", 16),
        Person("Fernando", "Vega", 37),
        Person("Alicia", "Gómez", 19),
        Person("Paula", "Escobar", 33),
        Person("Alberto", "Parada", 22),
        Person("Cristian", "Romero", 44),
        Person("Octavio", "Hernández", 23),
        Person("Yaiza", "Costi", 43),
        Person("Naomi", "Fernandexz", 57),
        Person("Jason", "Otah", 16),
        Person("Alejandro", "Lora", 27),
        Person("Fernando", "Vega", 37),
        Person("Alicia", "Gómez", 19),
        Person("Paula", "Escobar", 33),
        Person("Alberto", "Parada", 22),
        Person("Cristian", "Romero", 44),
        Person("Octavio", "Hernández", 23),
        Person("Yaiza", "Costi", 43),
        Person("Naomi", "Fernandexz", 57),
        Person("Jason", "Otah", 16)
        )

    }
}
