package com.AndresDiaz.com.models

import android.os.Parcel
import android.os.Parcelable
/*parcel es un contenedor para un mensaje
Puede ser usdo para mandar un objeto serializado a traves de Intent
Mejor rendimiento que serializer
el parcel no entiende de boleanos y se cambia por byte["parcel.readByte() !=0.toByte()"]*/


data class Student(var name: String, var lastName: String, var age:  Int, var isDeveloper: Boolean=true) : Parcelable {
    //Leer en el mismo orden que declaramos las propiedades
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        //tenemos que escribir los valores en el mismo orden en el que leemos en el contructor
        parcel.writeString(name)
        parcel.writeString(lastName)
        parcel.writeInt(age)
        parcel.writeByte(if (isDeveloper) 1 else 0)

    }

    /*Describe el tipo de contenido del objeto parcelable
    * 0 siempre se usa, el otro valor es 1 o CONTENTS_FILE_DESCRIPTOR,para tipos de objetos que implementan un File Descriptor*/
    override fun describeContents() = 0
    companion object CREATOR: Parcelable.Creator<Student>{
        //Esto creara el objeto desde el parcel llamado constuctor SECUNDARIO
        override fun createFromParcel(parcel: Parcel)=Student(parcel)
        //Esto ayudara a serializar arrays de objetos del mismo tipo que esta clase(Student)
        override fun newArray(size: Int)= arrayOfNulls<Student?>(size)
    }

}
